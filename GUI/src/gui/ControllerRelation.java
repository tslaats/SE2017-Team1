package gui;


/**
 *  @project >> Software Engineering 2017
 *  @authors >> Emil Slot Arakelian Jensen, Philip Falck
 *  @contact >> 
 *  @version >> 1.2.2
 *  @updated >> 23/03-2017
 *  @licence >> MIT
 *  @sources >> 
 */

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import resources.MalformedGraphException;
import utils.CRGVlib;


public class ControllerRelation extends JPanel
{
    public JPanel panel;
    
        ControllerRelation(int index)
        {
        panel = this;
        setLayout(null);
        setBackground(Color.WHITE);

        // Relation components initializations
        JButton                 buttonAddRelation   = new JButton       ("Add Relation");
        JTextField         		parentID            = new JTextField    ("Parent ID");
        JTextField          	childID             = new JTextField    ("Child ID");
        JRadioButton            condition           = new JRadioButton  ("Condition");
        JRadioButton            response            = new JRadioButton  ("Response");

        /* Creating radio button group */
        ButtonGroup group = new ButtonGroup();
        group.add(condition);
        group.add(response);
        condition.setSelected(true);

        /* Radio buttons coloring */
        condition.setBackground(Color.WHITE);
        response.setBackground(Color.WHITE);

        /* Setting size and position */
        parentID.setBounds                      (0, 0, 150, 20);
        childID.setBounds                       (0, 20, 150, 20);
        condition.setBounds                		(0, 40, 150, 20);
        response.setBounds                      (0, 60, 150, 20);
        buttonAddRelation.setBounds         	(0, 80, 150, 25);

        /* Centering text */
        parentID.setHorizontalAlignment     	(JTextField.CENTER);
        childID.setHorizontalAlignment          (JTextField.CENTER);

        /* Adding components to JPanel */
        add                                 (childID);
        add                                 (parentID);
        add                                 (condition);
        add                                 (response);
        add                                 (buttonAddRelation);
        
        buttonAddRelation.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed (MouseEvent e)
            {
                GraphData       currentData     = Main.graphData.get(index);
                
                ConresEvent     child           = null;
                ConresEvent     parent          = null;
                
                ConresRelation  relation;

                int             child_id;
                int             parent_id;
                
                /* Validating input ID's */
                try{
                    child_id = Integer.parseInt(childID.getText());
                    parent_id = Integer.parseInt(parentID.getText());;
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(currentData.frame, "Input for coordinates and ID's must be a number.", 
                              "Wrong input type", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                /* Closing tab after submission */ 
                setVisible(false);
                remove(panel);
                Main.graphData.get(index).frame.conresController.visTab = ViewConres.VisibleTab.None;
                
                /* Searching for corresponding ID's for events to set parent and child */
                
                try {
                	child = ((ConresGraph)currentData.graph).getEvent(child_id);
                	parent = ((ConresGraph)currentData.graph).getEvent(parent_id);
				} catch (IllegalArgumentException ex)
				{
                	JOptionPane.showMessageDialog(currentData.frame, "Parent or Child ID does not exist", 
							  "Invalid input", JOptionPane.WARNING_MESSAGE);
					return;
                }
                
                /* Creating condition/response relation */
                if(condition.isSelected()){
                    relation = new ConresRelation(parent, child, ConresRelation.Type.Condition);
                }
                else{
                    relation = new ConresRelation(parent, child, ConresRelation.Type.Response);
                }
                             
                /* Call visualization to get image and update the frame with this new image */
                System.out.println("<debug> Calling visualization group for an update..");
                /*
                 * OLD FOR PENGUIN USE
                 *
                Main.graphData.get(index).frame.UpdateBackground
                (
                    Main.callVisualizationGroup
                    (
                        ((ConresGraph)(Main.graphData.get(index).graph))
                    )
                );
                */
                
                // System.out.println(((ConresGraph)currentData.graph));
                
                CRGVlib lib = new CRGVlib();
                JPanel panelToDraw;
                try {
                	((ConresGraph)(Main.graphData.get(index).graph)).relations.add(relation);
                	panelToDraw = lib.draw((ConresGraph)currentData.graph);
                    currentData.frame.updateBackground(panelToDraw);
				} catch (MalformedGraphException e1) {
					((ConresGraph)(Main.graphData.get(index).graph)).relations.remove(relation);
					JOptionPane.showMessageDialog(currentData.frame, e1, 
							  "RELATIONS: Malformed Graph Exception", JOptionPane.WARNING_MESSAGE);
					return;
				}
            }
       });
    }
}

package gui;
/**
 *  @project >> Software Engineering 2017
 *  @authors >> Emil Slot Arakelian Jensen, Philip Falck
 *  @contact >> 
 *  @version >> 1.2.1
 *  @updated >> 22/03-2017
 *  @licence >> MIT
 *  @sources >> 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControllerTransition extends JPanel
{
    public JPanel panel;
    
    public ControllerTransition(int index)
    {
        panel = this;
        setLayout(null);
        setBackground(Color.WHITE);
        
        /* Transition components initialization */
        JButton         buttonAddTrans   = new JButton      ("Add Transition");
        JTextField      transName        = new JTextField   ("Transition name");
        JTextField      transX           = new JTextField   ("X coordinate");
        JTextField      transY           = new JTextField   ("Y coordinate"); 
        
        /* Setting size and position */
        transName.setBounds                 (0, 0, 150, 20);
        transName.setHorizontalAlignment    (JTextField.CENTER);
        transX.setBounds                    (0, 20, 75, 20);
        transY.setBounds                    (75, 20, 75, 20);
        buttonAddTrans.setBounds            (0, 40, 150, 25);
        
        /* Adding components to JPanel */
        add                                 (transName);
        add                                 (transX);
        add                                 (transY);
        add                                 (buttonAddTrans);
        repaint();
        
        buttonAddTrans.addMouseListener(new MouseAdapter ()
        {
            @Override
            public void mousePressed (MouseEvent e)
            {
                GraphData currentData = Main.graphData.get(index);
                
                PetriTransition transition;
                
                int       x_coord;
                int       y_coord;
                
                /* Validating input coordinates */
                try{
                    x_coord = Integer.parseInt(transX.getText());
                    y_coord = Integer.parseInt(transY.getText());
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(currentData.frame, "Input for coordinates must be a number.", 
                              "Wrong input type", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                /* Closing tab after submission */ 
                setVisible(false);
                remove(panel);
                Main.graphData.get(index).frame.petriController.visTab = ViewPetri.VisibleTab.None;
                
                /* Creating and adding the new transition to the graph data */
                transition = new PetriTransition(Main.uniqueNodeID++, new Point(x_coord,y_coord), transName.getText());
                ((PetriGraph)currentData.graph).transitions.add
                (
                    transition
                );
                
                /* Call visualization to get image and update the frame with this new image */
                /*
                 *  TEST
                 *
                currentData.frame.UpdateBackground
                (
                    Main.callVisualizationGroup
                    (
                        (PetriGraph)currentData.graph
                    )
                );
                */
                
                currentData.frame.g.addSingleTransition(transition);
				currentData.frame.updateBackground
                (
                	currentData.frame.g
                );
            }
        });
    }
}

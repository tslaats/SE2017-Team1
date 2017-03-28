package gui;
/**
 *  @project >> Software Engineering 2017
 *  @authors >> Emil Slot Arakelian Jensen
 *  @contact >> 
 *  @version >> 1.2.0
 *  @updated >> 16/03-2017
 *  @licence >> MIT
 *  @sources >> 
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


 class ControllerSubgraph extends JPanel {
	
	 ControllerSubgraph(int index, Main.GraphType type){
		setLayout(null);
		setBackground(Color.WHITE);
		
	    /* Subgraph components initialization */
		JTextField		parentTransition	= new JTextField	("Parent ID");
	    JButton 		buttonAddSubgraph 	= new JButton		("Add Subgraph");

		/* Setting size and position */
        parentTransition.setBounds					(0, 0, 150, 20);
        buttonAddSubgraph.setBounds					(0, 20, 150, 25);
        
        /* Centering text */
        parentTransition.setHorizontalAlignment		(JTextField.CENTER);
        
        /* Adding components to JPanel */
        add											(parentTransition);
        add											(buttonAddSubgraph);
        
        
        buttonAddSubgraph.addMouseListener(new MouseAdapter()
        {
        	@Override
        	public void mousePressed (MouseEvent e)
        	{
        		GraphData 	currentData = Main.graphData.get(index);
        		
        		int 		parentId;
        		
        		/* Validating input of parent ID */
        		try{
                	parentId = Integer.parseInt(parentTransition.getText());
                } catch (NumberFormatException ex){
                	JOptionPane.showMessageDialog(currentData.frame, "Input parent ID must be a number.", 
							  "Wrong input type", JOptionPane.WARNING_MESSAGE);
                	return;
                }
        		
        		/* Closing tab after submission */ 
                setVisible(false);
                
                /* Set subgraphID for parent transition */
                try
				{
	                if (type == Main.GraphType.Conres)
					{
	                	currentData.frame.petriController.visTab = ViewPetri.VisibleTab.None;
	                	((PetriGraph)currentData.graph).getTransition(parentId).subgraphID = Main.graphData.size();
						
						// System.out.println(((PetriGraph)currentData.graph));
						
						currentData.frame.updateBackground
						(
							currentData.frame.g
						);
	                }
	                else
					{
	                	 currentData.frame.conresController.visTab = ViewConres.VisibleTab.None;
	                	 ((ConresGraph)currentData.graph).getEvent(parentId).subgraphID = Main.graphData.size();
	                }
                }
				catch (IllegalArgumentException ex)
				{
                	JOptionPane.showMessageDialog(currentData.frame, "Parent ID does not exist", 
							  "Invalid input", JOptionPane.WARNING_MESSAGE);
					return;
                }
                
                
                /* Adding the new subgraph to the graph data */
                Main.graphData.add(new GraphData(Main.graphData.size(), parentId, type));
        	}
        });
	}
}

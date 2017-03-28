package gui;
/**
 *  @project >> Software Engineering 2017
 *  @authors >> Emil Slot Arakelian Jensen, Philip Falck
 *  @contact >> 
 *  @version >> 1.2.2
 *  @updated >> 21/03-2017
 *  @licence >> MIT
 *  @sources >> 
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



 class ControllerPlace extends JPanel
 {
	public JPanel panel;
	 ControllerPlace(int index)
	 {
		 panel = this;
		setLayout(null);
		setBackground(Color.WHITE);
		
	    // Place components initializations
	    JButton 				buttonAddPlace 	= new JButton		("Add Place");
	    JLabel 					labelCheckBox 	= new JLabel		("Token");
	    JCheckBox 				hasToken  		= new JCheckBox();
	    JTextField 				placeX 			= new JTextField	("X coordinate");
	    JTextField 				placeY 			= new JTextField	("Y coordinate");
	    JTextField 				incomingID 		= new JTextField	("Incoming transition ID");
	    JTextField 				outgoingID 		= new JTextField	("Outgoing transition ID");
	    JRadioButton			startPlace		= new JRadioButton	("Start place");
	    JRadioButton			endPlace		= new JRadioButton	("End place");
	    JRadioButton			nonePlace		= new JRadioButton	("None");
		ButtonGroup 			group 			= new ButtonGroup();

	    /* Adding to radio button group to make them depending on each other */
		group.add				(startPlace);
		group.add				(endPlace);
		group.add				(nonePlace);
		nonePlace.setSelected	(true);
		
		/* Radio buttons and token Coloring */
		startPlace.	setBackground	(Color.WHITE);
		endPlace.	setBackground	(Color.WHITE);
		nonePlace.	setBackground	(Color.WHITE);
		hasToken.	setBackground	(Color.WHITE);
		
		
		/* Setting size and position */
        hasToken.setBounds			(50, 0, 20, 20);  
        labelCheckBox.setBounds		(75, 0, 50, 20);
        placeX.setBounds			(0, 20, 75, 20);
        placeY.setBounds			(75, 20, 75, 20);
        incomingID.setBounds		(0, 40, 150, 20);
        outgoingID.setBounds		(0, 60, 150, 20);
        startPlace.setBounds		(0, 80, 150, 20);
        endPlace.setBounds			(0, 100, 150, 20);
        nonePlace.setBounds			(0, 120, 150, 20);
        buttonAddPlace.setBounds	(0, 140, 150, 25);
        
        /* Centering text */
        labelCheckBox.setHorizontalAlignment	(JTextField.CENTER);
		placeX.setHorizontalAlignment			(JTextField.CENTER);
        placeY.setHorizontalAlignment			(JTextField.CENTER);
        incomingID.setHorizontalAlignment		(JTextField.CENTER);
        outgoingID.setHorizontalAlignment		(JTextField.CENTER);        
        
        /* Adding componenets to JPanel */
        add							(hasToken);
        add							(labelCheckBox);
        add							(placeX);
        add							(placeY);
        add							(incomingID);
        add							(outgoingID);
        add							(startPlace);
        add							(endPlace);
        add							(nonePlace);
        add							(buttonAddPlace);
        
        
        buttonAddPlace.addMouseListener(new MouseAdapter()
        {
        	@Override
        	public void mousePressed (MouseEvent e)
        	{
        		GraphData 		currentData 	= Main.graphData.get(index);
        		
                PetriTransition incoming 		= null;
                PetriTransition outgoing 		= null;
                PetriPlace 		place;
                
                int 			x_coord;
                int 			y_coord;
                int 			inc_id = -1;
                int				out_id = -1;
               
                /* Validating input - coordinate */
                try{
                	x_coord = Integer.parseInt(placeX.getText());
                	y_coord = Integer.parseInt(placeY.getText());
                } catch (NumberFormatException ex){
                	JOptionPane.showMessageDialog(currentData.frame, "Input for coordinates must be a number.", 
							  "Wrong input type", JOptionPane.WARNING_MESSAGE);
                	return;
                }
                
                /* Validating input for incoming and outgoing transitions and setting incoming outgoing transitions */
                try {
					if (nonePlace.isSelected()){
					inc_id = Integer.parseInt(incomingID.getText());
                	out_id = Integer.parseInt(outgoingID.getText());
                	incoming = ((PetriGraph)currentData.graph).getTransition(inc_id);
                	outgoing = ((PetriGraph)currentData.graph).getTransition(out_id);
                	}
                	else if (startPlace.isSelected()) {
                		out_id = Integer.parseInt(outgoingID.getText());
						outgoing = ((PetriGraph)currentData.graph).getTransition(out_id);
					}
					else{
						inc_id = Integer.parseInt(incomingID.getText());
						incoming = ((PetriGraph)currentData.graph).getTransition(inc_id);
					}
				} catch (IllegalArgumentException ex){
                	JOptionPane.showMessageDialog(currentData.frame, "Missing or invalid input for incoming/outgoing transitions ID's.", 
							  "Wrong input type", JOptionPane.WARNING_MESSAGE);
                	return;
                }
                
                /* Closing tab after submission */
                setVisible(false);
				remove(panel);
                currentData.frame.petriController.visTab = ViewPetri.VisibleTab.None;
                
                /* Creating and adding the new place */
                place = new PetriPlace (Main.uniqueNodeID++, new Point(x_coord, y_coord),
            			hasToken.isSelected(), incoming, outgoing);
                
        		((PetriGraph)currentData.graph).places.add(place);
        		
        		/* Add as incoming or outgoing place to PetriTransition */
        		
        		
               	/* Setting Start/End place if needed and adding incoming outgoing places to transitions */
                if (startPlace.isSelected()){
                	outgoing.incoming.add(place);
                	((PetriGraph)currentData.graph).start = place;
                }
                else if (endPlace.isSelected()){
                	incoming.outgoing.add(place);
                	((PetriGraph)currentData.graph).end = place;
                }
                else{
                	incoming.outgoing.add(place);
                	outgoing.incoming.add(place);
               }
        		
				/* OLD
        		 * Call visualization to get image and update the frame with this new image
                currentData.frame.UpdateBackground
                (
                    Main.callVisualizationGroup
                    (
                        (PetriGraph)currentData.graph
                    )
                );
				*/
				
				// System.out.println(((PetriGraph)currentData.graph));
				
                currentData.frame.g.addSinglePlace(place);
                currentData.frame.updateBackground
                (
                    currentData.frame.g
                );
        	}
        });
	}
}

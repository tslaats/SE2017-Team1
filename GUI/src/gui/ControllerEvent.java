package gui;


/**
 *  @project >> Software Engineering 2017
 *  @authors >> Philip Falck, Emil Slot Arakelian Jensen
 *  @contact >> 
 *  @version >> 1.2.0
 *  @updated >> 23/03-2017
 *  @licence >> MIT
 *  @sources >> 
 */

import java.awt.*;

import resources.MalformedGraphException;
import utils.CRGVlib;

import java.awt.event.*;

import javax.swing.*;

public class ControllerEvent extends JPanel
{
    public JPanel panel;
    
    public ControllerEvent(int index)
    {
		panel = this;
        setLayout(null);
        setBackground(Color.WHITE);
        
        /* Event components initialization */
        JButton         buttonAddEvent   = new JButton      ("Add Event");
        JTextField      eventName        = new JTextField   ("Event name");
        JTextField      eventRole        = new JTextField   ("Event role");
        JTextField      eventX           = new JTextField   ("X coordinate");
        JTextField      eventY           = new JTextField   ("Y coordinate"); 
          

        System.out.println("<debug> Showing conres event panel");
        
        /* Setting size and position */
        eventName.setBounds                 (0, 0, 150, 20);
        eventRole.setBounds                 (0, 20, 150, 20);
        eventX.setBounds                    (0, 40, 75, 20);
        eventY.setBounds                    (75, 40, 75, 20);
        buttonAddEvent.setBounds            (0, 60, 150, 25);
       
        /* Centering of text */
        eventName.setHorizontalAlignment    (JTextField.CENTER);
        eventRole.setHorizontalAlignment    (JTextField.CENTER);
        eventX.setHorizontalAlignment       (JTextField.CENTER);
        eventY.setHorizontalAlignment       (JTextField.CENTER);
        
        /* Adding components to JPanel */
        add                                 (eventName);
        add                                 (eventRole);
        add                                 (eventX);
        add                                 (eventY);
        add                                 (buttonAddEvent);
        repaint();

        
        buttonAddEvent.addMouseListener(new MouseAdapter ()
        {
            @Override
            public void mousePressed (MouseEvent e)
            {
                GraphData currentData = Main.graphData.get(index);
                
                int x_coord;
                int y_coord;

                /* Validating input coordinates */
                try{
                    x_coord = Integer.parseInt(eventX.getText());
                    y_coord = Integer.parseInt(eventY.getText());
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(currentData.frame, "Input for coordinates must be a number.", 
                              "Wrong input type", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                /* Closing tab after submission */ 
                setVisible(false);
                remove(panel);
                currentData.frame.conresController.visTab = ViewConres.VisibleTab.None;
                
                
                /* Call visualization to get image and update the frame with this new image */
                System.out.println("<debug> Calling visualization group for an update..");
 
                ConresEvent event = new ConresEvent(Main.uniqueNodeID++, new Point(x_coord, y_coord), eventName.getText(), eventRole.getText());
                CRGVlib lib = new CRGVlib();
                JPanel panelToDraw;
                try {
                    ((ConresGraph)currentData.graph).events.add(event);
                	panelToDraw = lib.draw((ConresGraph)currentData.graph);
                    currentData.frame.updateBackground(panelToDraw);
				} catch (MalformedGraphException e1) {
					((ConresGraph)(Main.graphData.get(index).graph)).events.remove(event);
					JOptionPane.showMessageDialog(currentData.frame, e1, 
							  "EVENTS: Malformed Graph Exception", JOptionPane.WARNING_MESSAGE);
					return;
				}
                /* Adding the new event to the graph data */
            }
        });
    }
}

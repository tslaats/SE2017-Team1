package gui;

/**
 *  @project >> Software Engineering 2017
 *  @authors >> Philip Falck
 *  @contact >> 
 *  @version >> 1.2.0
 *  @updated >> 23/03-2017
 *  @licence >> MIT
 *  @sources >> 
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ViewConres extends JPanel
{

	public VisibleTab visTab = VisibleTab.None;

	/* enum to keep track of which task is active */
    public static enum VisibleTab
    {
        None,
        Event,
        Relation,
        Subgraph
    }
	
    public int index = 0;
    
    public ControllerEvent 		eventPanel;
    public ControllerRelation 	relationPanel;
    public ControllerSubgraph 	subgraphPanel;
    
    
    public ViewConres (int index)
    {
    	this.index = index;
    	
    	/* JPanel settings */
    	setBackground	(Color.WHITE);
        setLayout		(null);
        setSize			(5000, 190);
        setOpaque		(false);

        /* Initializing buttons */
        JButton buttonEvent 	= new JButton("Event");
        JButton buttonRelation	= new JButton("Relation");
        JButton buttonSubgraph 	= new JButton("Petri subgraph");
        JButton buttonReopen	= new JButton("Simulate");
		JButton buttonPrint		= new JButton("Debug: Print");
		JPanel spacer			= new JPanel();
		
        /* Setting size and position */
		spacer.setBounds			(0,   0, 5000, 25);
        buttonEvent.setBounds		(0, 0, 150, 25);
        buttonRelation.setBounds	(150, 0, 150, 25);
        buttonSubgraph.setBounds	(300, 0, 150, 25);
        buttonSubgraph.setBounds	(300, 0,  150, 25);
		buttonReopen.setBounds		(450, 0,  150, 25);
		buttonPrint.setBounds		(600, 0,  150, 25);
		
        /* Adding buttons to JPanel */
        add(buttonEvent);
        add(buttonRelation);
        add(buttonSubgraph);
        add(buttonReopen);
		add(buttonPrint);
        add(spacer);
        
		/*
         *  Open the simulation panel.
         */
		buttonReopen.addMouseListener(new MouseAdapter()
        {
        	@Override
        	public void mousePressed (MouseEvent e)
        	{
				System.out.println("<error> No simulation liberary added.");
			}
		});
		
		/*
         *  This prints the current frames graph data to console!
         */
        buttonPrint.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed (MouseEvent e)
            {
                System.out.println(Main.graphData.get(index).graph);
            }
        });
		
        /* Subgraph button listener 
         * Creates a SubgraphController object
         * which shows the options for a Subgraph
         */
        buttonSubgraph.addMouseListener(new MouseAdapter()
        {
        	@Override
        	 public void mousePressed (MouseEvent e)
        	{
        		if (!isVisible(VisibleTab.Subgraph))
        		{
	                subgraphPanel 				= new ControllerSubgraph(index, Main.GraphType.Petri);
	                
	                subgraphPanel.setBounds		(300, 25, 150, 45);
	                add							(subgraphPanel);
	                
	                visTab						 = VisibleTab.Subgraph;
        		}
                repaint();
                }
		});
        
        
        /* Event button listener 
         * Creates a ControllerEvent object
         * which shows the options for a event 
         */
        buttonEvent.addMouseListener(new MouseAdapter()
        {
        	@Override
        	 public void mousePressed (MouseEvent e)
        	{
        		if (!isVisible(VisibleTab.Event))
        		{
	                eventPanel 					= new ControllerEvent(index);
	                
	                eventPanel.setBounds		(0, 25, 150, 85);
	                add							(eventPanel);
	                visTab 						= VisibleTab.Event;
        		}
                repaint();
            }
		});
        
        /* Relation button listener 
         * Creates a ControllerRelation object
         * which shows the options for a Relation
         */
        buttonRelation.addMouseListener(new MouseAdapter()
        {
        	@Override
        	 public void mousePressed (MouseEvent e)
        	{
        		if (!isVisible(VisibleTab.Relation)){
	                relationPanel 				= new ControllerRelation(index);

	                relationPanel.setBounds		(150, 25, 150, 105);
	                add							(relationPanel);
	                visTab 						= VisibleTab.Relation;
        		}
                repaint();   
        	}
		});
    }
    
    /* Function to determine whether a tab should expand or collapse */
    private boolean isVisible(VisibleTab tab){
    	boolean isVis 		= visTab == tab;
		switch (visTab){
			case None:
				break;
			case Relation:
				remove		(relationPanel);
				visTab 		= VisibleTab.None;
				break;
			case Subgraph: 
				remove		(subgraphPanel);
				visTab 		= VisibleTab.None;
				break;
			case Event:
				remove		(eventPanel);
				visTab 		= VisibleTab.None;
				break;
			default:
				break;
		}
		return isVis;
    }
}

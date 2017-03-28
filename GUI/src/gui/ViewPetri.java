package gui;

/**
 *  @project >> Software Engineering 2017
 *  @authors >> Philip Falck, Emil Slot Arakelian Jensen
 *  @contact >> 
 *  @version >> 1.3.0
 *  @updated >> 23/03-2017
 *  @licence >> MIT
 *  @sources >> 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ViewPetri extends JPanel
{
    public VisibleTab visTab = VisibleTab.None;
    
    /* enum to keep track of which task i active */
    public static enum VisibleTab
    {
        None,
        Transition,
        Place,
        Subgraph
    }
    
    public int index = 0;
    
    public ControllerTransition transitionPanel;
    public ControllerPlace      placePanel;
    public ControllerSubgraph   subgraphPanel;
    
    
    public ViewPetri (int index)
    {
        this.index= index;
        
        /* JPanel settings */
        setBackground   (Color.WHITE);
        setLayout       (null);
        setSize         (5000, 190);
        setOpaque       (false);

        /* Initializing buttons */
        JButton buttonTrans     = new JButton("Transition");
        JButton buttonPlace     = new JButton("Place");
        JButton buttonSubgraph  = new JButton("CR subgraph");
        JButton buttonReopen    = new JButton("Simulate");
        JButton buttonPrint     = new JButton("Debug: Print");
        JPanel spacer           = new JPanel();
        
        /* Setting size and position */
        spacer.setBounds            (0,   0, 5000, 25);
        buttonTrans.setBounds       (0,   0,  150, 25);
        buttonPlace.setBounds       (150, 0,  150, 25);
        buttonSubgraph.setBounds    (300, 0,  150, 25);
        buttonReopen.setBounds      (450, 0,  150, 25);
        buttonPrint.setBounds       (600, 0,  150, 25);
       
        /* Adding to JPanel */
        add(buttonTrans);
        add(buttonPlace);
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
                    subgraphPanel               = new ControllerSubgraph(index, Main.GraphType.Conres);
                    
                    subgraphPanel.setBounds     (300, 25, 150, 45);
                    
                    add                         (subgraphPanel);
                    
                    visTab                      = VisibleTab.Subgraph;
                }
                repaint();
            }
        });
        
        /* Transition button listener 
         * Creates a TransitionController object
         * which shows the options for a transition 
         */
        buttonTrans.addMouseListener(new MouseAdapter()
        {
            @Override
             public void mousePressed (MouseEvent e)
            {
                if (!isVisible(VisibleTab.Transition))
                {
                    transitionPanel             = new ControllerTransition(index);
                    
                    transitionPanel.setBounds   (0, 25, 150, 65);
                    add                         (transitionPanel);
                    
                    visTab                      = VisibleTab.Transition;
                }
                repaint();
            }
        });
        
        /* Place button listener 
         * Creates a PlaceController object
         * which shows the options for a Place
         */
        buttonPlace.addMouseListener(new MouseAdapter()
        {
            @Override
             public void mousePressed (MouseEvent e)
            {
                if (!isVisible(VisibleTab.Place)){
                    placePanel                  = new ControllerPlace(index);

                    placePanel.setBounds        (150, 25, 150, 165);
                    add                         (placePanel);
                    
                    visTab                       = VisibleTab.Place;
                }
                repaint();   
            }
        });
    }
    
    /* Function to determine whether a tab should expand or collapse */
    private boolean isVisible(VisibleTab tab){
        boolean isVis        = (visTab == tab);
        switch (visTab){
            case None:
                break;
            case Place:
                remove      (placePanel);
                visTab      = VisibleTab.None;
                break;
            case Subgraph: 
                remove      (subgraphPanel);
                visTab      = VisibleTab.None;
                break;
            case Transition:
                remove      (transitionPanel);
                visTab      = VisibleTab.None;
                break;
            default:
                break;
        }
        return isVis;
    }
}

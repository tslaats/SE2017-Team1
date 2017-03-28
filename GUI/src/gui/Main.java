package gui;


/**
 *  @project >> Software Engineering 2017
 *  @authors >> Philip Falck
 *  @contact >> 
 *  @version >> 1.3.0
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

public class Main
{
    public static ArrayList<GraphData>  graphData       = new ArrayList<GraphData>();
    public static int                   uniqueNodeID    = 1;
    
    /*
     *
     *
     */
    public static void main (String[] args)
    {
        System.out.println("<debug> Starting the application..");
        
        System.out.println("<debug> Manually adding a new petri graph..");
        
        graphData.add(new GraphData(graphData.size(), 0, GraphType.Conres));
    }
    
    /*
     *
     *
     */
    public static enum GraphType
    {
        Petri,
        Conres
    }
    
    /*
     *
     *
     */
    public static BufferedImage callVisualizationGroup (Graph graph)
    {
        System.out.println("<debug> Attempting to call visualization..");
        
        try
        {
        	return (ImageIO.read(new File("C:\\Users\\USER\\Desktop\\x\\penguin.jpg")));
        }
        catch (Exception e)
        {
        }
        try{
        	return (ImageIO.read(new File("penguin.jpg")));
        }
        catch (Exception ex){
        	System.out.println("<debug> Exception caught..");
            return (null);
        }
    }
}

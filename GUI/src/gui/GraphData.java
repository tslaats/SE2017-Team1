package gui;

/**
 *  @project >> Software Engineering 2017
 *  @authors >> Philip Falck
 *  @contact >> 
 *  @version >> 1.2.1
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

/*
 *
 *
 */
public class GraphData
{
    public int                          parent          = 0;
    public Editor                       frame           = null;
    public Graph                        graph           = null;
    
    /*
     *
     *
     */
    public GraphData (int index, int parent, Main.GraphType type)
    {
        this.parent = parent;
        this.frame  = new Editor(index, type);
        
        if (Main.GraphType.Petri == type)
        {
            graph = new PetriGraph();
        }
        else
        {
            graph = new ConresGraph();
        }
    }
}

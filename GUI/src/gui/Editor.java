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

public class Editor extends JFrame
{
    public JPanel background = new JPanel();
    public ViewPetri petriController;
    public ViewConres conresController;
    public PetriNet g = new PetriNet();

    /*
     *
     *
     */
    public Editor (int index, Main.GraphType type)
    {
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        setLayout(null);
        
        add(background);
        
        if (type == Main.GraphType.Petri)
        {
            setTitle("Editor: Petri");
            
            petriController = new ViewPetri(index);
            
            add(petriController);
            
            updateBackground(g);
            
            repaint();
        }
        else
        {
            setTitle("Editor: Condition Response");
            
            conresController = new ViewConres(index);
            
            add(conresController);
            
            updateBackground(g);
            
            repaint();
        }
        
        setSize(750, 750);
    }

    /*
     * This is the old function used for debugging.
     *
    public void UpdateBackground (BufferedImage image)
    {
        System.out.println("<debug> Trying to update background..");

        remove(background);

        background = new JLabel(new ImageIcon(image));

        background.setBounds(0, 0, image.getWidth(), image.getHeight());

        add(background);

        repaint();
        
    }
    */
    
    /*
     *  This will update the background of the editor window, with a given panel
     *  that has all of the graphics drawn on top of it.
     */
    public void updateBackground (JPanel panel)
    {
        remove(background);
        
        background = panel;
        
        background.setBounds(0, 0, 2500, 2500);
        
        add(background);
        
        repaint();
    }
}

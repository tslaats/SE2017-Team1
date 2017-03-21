package petriNet.visualization;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;


/**
 * Created by root on 3/14/17.
 */

public class draw_place{
    private Point coord;
    private int diameter = 30;
    private int place_id = null;
    

    public draw_place(Point c, int place_id){
        coord = c;
	place_id = place_id;
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        Ellipse2D.Double circle = new Ellipse2D.Double(coord.x, coord.y, diameter, diameter);
        g2d.fill(circle);
    }
}

package petriNet.visualization;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by root on 3/14/17.
 */

public class draw_transition extends JPanel{
    private Point coord;
    private int width = 20;
    private int height = 50;
    private int transition_id = null;

    public draw_transition(Point p, int id){
        coord = p;
	transition_id = id;
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.draw(new Rectangle2D.Double(coord.x, coord.y, width, height));
    }
}

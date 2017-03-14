import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;


/**
 * Created by root on 3/14/17.
 */

public class draw_circle{
    private int start_x_coord;
    private int start_y_coord;
    private int diameter = 50;

    public draw_circle(int x, int y){
        start_x_coord = x;
        start_y_coord = y;
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        Ellipse2D.Double circle = new Ellipse2D.Double(start_x_coord, start_y_coord, diameter, diameter);
        g2d.fill(circle);
    }

}

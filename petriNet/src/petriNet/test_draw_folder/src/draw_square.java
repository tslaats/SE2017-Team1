import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by root on 3/14/17.
 */

public class draw_square extends JPanel{
    private int start_x_coord;
    private int start_y_coord;
    private int width = 20;
    private int height = 50;

    public draw_square(int x, int y){
        start_x_coord = x;
        start_y_coord = y;
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.draw(new Rectangle2D.Double(start_x_coord, start_y_coord, width, height));
    }
}

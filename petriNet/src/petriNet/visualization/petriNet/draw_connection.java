package petriNet.visualization.petriNet;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;


public class draw_connection{
    private int from_id;
    private int to_id;
    private Point start_coord;
    private Point end_coord;

    public draw_connection(Point start, Point stop, int from_id, int to_id){
        from_id = from_id;
        to_id = to_id;
        start_coord = start;
        end_coord = stop;
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.draw(new Line2D.Double(start_coord.x, start_coord.y, end_coord.x, end_coord.y));
    }


}

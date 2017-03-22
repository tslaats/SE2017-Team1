package petriNet.src.petriNet.visualization.petriNet;

import java.awt.*;
import java.awt.geom.Ellipse2D;


/**
 * Created by root on 3/14/17.
 */

public class drawPlace{
    private Point coord;
    private int diameter = 30;
    private int place_id;
    

    public drawPlace(Place p){
        this.coord = p.getPosition();
        this.place_id = p.getId();
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        Ellipse2D.Double circle = new Ellipse2D.Double((coord.x - (diameter / 2)), (coord.y - (diameter / 2)), diameter, diameter);
        g2d.fill(circle);

        g2d.setColor(Color.GREEN);
        g2d.fill(circle);
    }
}

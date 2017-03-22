package petriNet.src.petriNet.visualization.petriNet;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by root on 3/14/17.
 */

public class drawTransition{
    private Point coord;
    private int width = 10;
    private int height = 50;
    private int transition_id;

    public drawTransition(Transition t){
        this.coord = t.getPosition();
        this.transition_id = t.getId();
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        Rectangle2D.Double rect = new Rectangle2D.Double((coord.x - (width / 2)), (coord.y - (height / 2)), width, height);
        g2d.fill(rect);

        g2d.setColor(Color.BLUE);
        g2d.draw(rect);
    }
}

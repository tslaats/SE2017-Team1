package petriNet.src.petriNet.visualization.petriNet;

import java.awt.*;
import java.awt.geom.Line2D;


public class Connection{
    private Place place;
    private Transition transition;
    private String whereTo;

    public Connection(Place place, Transition transition, String whereTo){
        this.place = place;
        this.transition = transition;
        this.whereTo = whereTo;
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);

        Point from;
        Point to;
        if (whereTo.equals("to_transition")){
            from = place.getPosition();
            to = transition.getPosition();
        } else {
            to = place.getPosition();
            from = transition.getPosition();
        }

        /*
        int xS = end_coord.x - 35;
        int yS = end_coord.y - 0;
        int endX = end_coord.x - 30;
        int endY = end_coord.y - 0;

        int xMark1 = (int) ((xS * Math.cos(90.0)) + (yS * Math.sin(90.0)));
        int yMark1 = (int) ((yS * Math.cos(90.0)) - (xS * Math.sin(90.0)));
        int xMark2 = (int) ((xS * Math.cos(90.0)) - (yS * Math.sin(90.0)));
        int yMark2 = (int) ((yS * Math.cos(90.0)) + (xS * Math.sin(90.0)));

        g2d.draw(new Line2D.Double(xMark1, yMark1, endX, endY));
        g2d.draw(new Line2D.Double(xMark2, yMark2, endX, endY));
        */
        g2d.draw(new Line2D.Double(from.x, from.y, to.x, to.y));
    }


}

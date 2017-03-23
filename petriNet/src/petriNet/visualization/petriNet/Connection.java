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


    private Point turnVec(Point from_p, Point to_p, boolean inverse){

        /* Theory for Matrix rotation: http://math.stackexchange.com/questions/1058898/having-problem-with-rotation-and-reflection */
        Point vec = new Point((to_p.x - from_p.x), (to_p.y - from_p.y));

        int xMark1;
        int yMark1;
        if(inverse){
            xMark1 = (int) ((vec.x * Math.cos(90.0)) - (vec.y * Math.sin(90.0)));
            yMark1 = (int) ((vec.y * Math.cos(90.0)) + (vec.x * Math.sin(90.0)));
        }else {
            xMark1 = (int) ((vec.x * Math.cos(90.0)) + (vec.y * Math.sin(90.0)));
            yMark1 = (int) ((vec.y * Math.cos(90.0)) - (vec.x * Math.sin(90.0)));
        }

        return new Point((xMark1 + from_p.x), (yMark1 + from_p.y));
    }

    private Point retVectorByPercent(Point from_p, Point to_p, double percent){
        Point vec = new Point((to_p.x - from_p.x), (to_p.y - from_p.y));

        double length = Math.sqrt(Math.pow(vec.x, 2.0) + Math.pow(vec.y, 2.0));

        double x;
        double y;

        if (vec.x != 0){
            x = vec.x / length;
            x *= ((length / 100.0) * percent);
        } else{
            x = 0;
        }
        if (vec.y != 0){
            y = vec.y / length;
            y *= ((length / 100.0) * percent);
        } else{
            y = 0;
        }

        return new Point((int) (x + from_p.x), (int) (y + from_p.y));
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

        Point resizedTo = retVectorByPercent(from, to, 75.0);
        Point arrowSize = retVectorByPercent(from, to, 65.0);

        Point pOne = turnVec(arrowSize, resizedTo, false);
        Point pTwo = turnVec(arrowSize, resizedTo, true);

        g2d.draw(new Line2D.Double(from.x, from.y, resizedTo.x, resizedTo.y));
        g2d.fill( new Polygon(new int[] {pOne.x, resizedTo.x, pTwo.x}, new int[] {pOne.y, resizedTo.y, pTwo.y}, 3));
    }


}

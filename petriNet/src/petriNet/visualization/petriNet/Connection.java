package petriNet.visualization.petriNet;
/**
 *  @project >> Software Engineering 2017
 *  @authors >> Emil, Frederik, Mads, Susanne, Philip Falck
 */

import java.awt.*;
import java.awt.geom.Line2D;



/**
 * Connection handles the logic concerning the drawing arrows between a place & transition
 */
public class Connection{
    private Place place;
    private Transition transition;
    private String whereTo;

    /**
     * Innitiates a Connection
     * @param place
     * @param transition
     * @param whereTo - Dictates the direction of the arrow
     */
    public Connection(Place place, Transition transition, String whereTo){
        this.place = place;
        this.transition = transition;
        this.whereTo = whereTo;
    }

    private double lengthBetweenPoints(Point a, Point b){
        Point vec = new Point((a.x - b.x), (a.y - b.y));
        double length = Math.sqrt(Math.pow(vec.x, 2.0) + Math.pow(vec.y, 2.0));
        return length;
    }

    /**
     * Logic to determine the point on each side of the vector that marks the arrow-head
     * @param from_p - in our implementation, this point is the tip of the arrow and also the point we rotate the vector around.
     * @param to_p - This os a point on the line between the tip and the beginning of the line. This point decides the size of the arrow-head
     * @param inverse - A ssomewhat deceptive name, this decides what side of the vector we calculate the point(e.g one arrow will need both an inverse=false, and inverse=true)
     * @return one of the Point's of the arrow-head corner
     */
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

    /**
     * A small ease-of-use function that help shrink a vector by a percentage.
     * @param from_p - starting-point of the vector
     * @param to_p - end-point of the vector
     * @param percent - percentage to schrink
     * @return the new "to_p", now "percent" closer to "from_p"
     */
    private Point retVectorByPercent(Point from_p, Point to_p, double percent){
        Point vec = new Point((to_p.x - from_p.x), (to_p.y - from_p.y));

        double length = lengthBetweenPoints(from_p, to_p);

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

    /**
     * Used to draw a Connection. A lot going on here, but it mostly boils down to rotation matrices & reducing vector
     * length based on the receiving type (e.g Transition)
     * @param g - graphical object that contains the arrow
     */
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);


        Point from;
        Point to;
        if (whereTo.equals("to_transition")){
            int trans_heigth = 20;

            from = place.getPosition();
            to = transition.getPosition();

            // Determining ho much to shrink the vector based on whether the arrow is straight or not.
            Point resizedTo;
            if (to.x == from.x) { // The arrow is straigth

            	double resize = ((Math.abs(to.y - from.y) - trans_heigth)/Math.abs((double) (to.y-from.y)))*100.0;
            	resizedTo = retVectorByPercent(from, to, resize);
            	
            } else if(to.y == from.y){
                int width = (int) Math.ceil(7.5 * transition.getName().length()) / 2; // determins the Transitions width
                double resize = ((Math.abs(to.x - from.x) - width)/Math.abs((double) (to.x-from.x)))*100.0;
                resizedTo = retVectorByPercent(from, to, resize);
            }
            else {
                // on angles, that's not dead on, a circle is with radius = the far corner of the transition is used to limit the length
                int width = (int) Math.ceil(7.5 * transition.getName().length()) / 2;
                Point cornerPoint = new Point((to.x - width), (to.y - trans_heigth));
                double lengthRadius = lengthBetweenPoints(to, cornerPoint);
                double lengthTotal = lengthBetweenPoints(to, from);
                double resize = ((lengthTotal - lengthRadius) / lengthTotal)*100.0;

            	resizedTo = retVectorByPercent(from, to, resize);
            }
            double length = Math.sqrt(Math.pow(Math.abs(resizedTo.x - from.x), 2) + Math.pow(Math.abs(resizedTo.y - from.y), 2));
            double original_length = Math.sqrt(Math.pow(Math.abs(to.x - from.x), 2) + Math.pow(Math.abs(to.y - from.y), 2));
            double arrowlength = (length - 15) / original_length;
            Point arrowSize = retVectorByPercent(from, to, arrowlength*100);

            Point pOne = turnVec(arrowSize, resizedTo, false);
            Point pTwo = turnVec(arrowSize, resizedTo, true);

            g2d.draw(new Line2D.Double(from.x, from.y, resizedTo.x, resizedTo.y));
            g2d.fill( new Polygon(new int[] {pOne.x, resizedTo.x, pTwo.x}, new int[] {pOne.y, resizedTo.y, pTwo.y}, 3));
        } else {
            to = place.getPosition();
            from = transition.getPosition();
            
            Point resizedTo;
            int radius = 15;
            if(to.x == from.x){
                double resize = ((Math.abs(to.y - from.y) - radius)/Math.abs((double) (to.y-from.y)))*100.0;
                resizedTo = retVectorByPercent(from, to, resize);
            } else{
                double resize = ((Math.abs(to.x - from.x) - radius)/Math.abs((double) (to.x-from.x)))*100.0;
                resizedTo = retVectorByPercent(from, to, resize);
            }

            double length = lengthBetweenPoints(resizedTo, from);
            double original_length = Math.sqrt(Math.pow(Math.abs(to.x - from.x), 2) + Math.pow(Math.abs(to.y - from.y), 2));
            double arrowlength = (length - 15) / original_length;
            Point arrowSize = retVectorByPercent(from, to, arrowlength*100);

            Point pOne = turnVec(arrowSize, resizedTo, false);
            Point pTwo = turnVec(arrowSize, resizedTo, true);

            g2d.draw(new Line2D.Double(from.x, from.y, resizedTo.x, resizedTo.y));
            g2d.fill( new Polygon(new int[] {pOne.x, resizedTo.x, pTwo.x}, new int[] {pOne.y, resizedTo.y, pTwo.y}, 3));
        }

        
    }


}

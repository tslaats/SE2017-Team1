import java.awt.*;
import java.awt.geom.Line2D;


public class drawConnection{
    private int from_id;
    private int to_id;
    private Point start_coord;
    private Point end_coord;

    public drawConnection(Point start, Point stop, int from_id, int to_id){
        this.from_id = from_id;
        this.to_id = to_id;
        this.start_coord = start;
        this.end_coord = stop;
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.draw(new Line2D.Double(start_coord.x, start_coord.y, end_coord.x, end_coord.y));
    }


}

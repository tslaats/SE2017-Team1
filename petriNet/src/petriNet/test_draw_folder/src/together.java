import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by root on 3/14/17.
 */
public class together extends JPanel{
    int num_circles = 3; int num_square = 2;
    private ArrayList<Tuple> coords;

    public together(ArrayList<Tuple> coordinates){
        coords = coordinates;
    }

    @Override
    public void paint(Graphics g){
        for (int i = 0; i < coords.size(); i++) {
            Tuple current_c = coords.get(i);
            if(i > num_circles){
                draw_circle new_circle = new draw_circle(current_c.x, current_c.y);
                new_circle.paint(g);
            } else{
                draw_square new_square = new draw_square(current_c.x, current_c.y);
                new_square.paint(g);
            }
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by root on 3/14/17.
 */


public class Main {
    public static void main(String args[]){
        JFrame frame = new JFrame("Test");
        ArrayList<Tuple> list = new ArrayList<Tuple>();
        list.add(new Tuple(10, 30)); list.add(new Tuple(70, 30));
        list.add(new Tuple(150, 30)); list.add(new Tuple(210, 30));
        list.add(new Tuple(10, 100)); list.add(new Tuple(10, 200));
        together p = new together(list);

        frame.add(p);
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

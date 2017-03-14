import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.applet.*;
import java.util.ArrayList;


public class draw extends Applet {
	double x1 = 20.0;	double y1 = 0.0;
	double x2 = 60.0;	double y2 = 80.0;
	
	double box_width = 100;
	double box_height = 50;
	
	
	public void paint (Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;

	    /* how to draw a point
		 * Point2D.Double point = new Point2D.Double(x1, y1); */
		
		/* how to draw a 2D line 
		g2.draw(new Line2D.Double(x1+50, y1+25, x2+50, y2+25));

		/* how to draw a 2D rectangle */
		g2.draw(new Rectangle2D.Double(x1, y1, box_width, box_height));
	    
	}
	
	
	public static void main(String ad[]) {
		//Applet class calls function paint() for us
        JFrame jp1 = new JFrame();
        draw a = new draw ();
        jp1.getContentPane().add(a, BorderLayout.CENTER);
        jp1.setSize(new Dimension(500,500));
        jp1.setVisible(true);
    }	
	
}

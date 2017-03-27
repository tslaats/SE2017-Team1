package drawings;

import java.awt.*;
import javax.swing.JPanel;

import resources.Constants;
import utils.TestUtil;

public class Condition extends JPanel {

  private static final long serialVersionUID = 1L;

  /*
   * test case: 
   * - act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
   * - act2 = new ConresActivity(0, new Point(250, 35), "Activity 2", "ROLE", false, false, false);
   * - rel = new ConresRelation(act2, act1, "cond")
   */
  public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
    
	// ACTIVITY 1
	Point center1 = new Point(100, 100);
    TestUtil.drawAct(g2d, center1, "ROLE", "Activity 1", false, false, false);

	// ACTIVITY 2
	Point center2 = new Point(300, 100);
    TestUtil.drawAct(g2d, center2, "ROLE", "Activity 2", false, false, false);
    
    // CONDITION
    int circleCondX = TestUtil.getRightX(center1) + Constants.DOT_SIZE / 2;
    int circleCondY = TestUtil.getUpperY(center1)+ Constants.ACTIVITY_HEIGHT / 2 + Constants.DOT_SIZE / 2;
    int triangleCondX = TestUtil.getRightX(center1) + Constants.DOT_SIZE;
    int triangleCondY = TestUtil.getUpperY(center1)+ Constants.ACTIVITY_HEIGHT / 2 + Constants.DOT_SIZE / 2;
    int lineCondStartX = TestUtil.getLeftX(center2);
    int lineCondEndX = TestUtil.getUpperY(center2) + Constants.ACTIVITY_HEIGHT / 2 + Constants.DOT_SIZE / 2;
    TestUtil.drawCond(g2d, circleCondX, circleCondY, triangleCondX, triangleCondY,
    		lineCondStartX, lineCondEndX, 'L', 0, 0);
  }
  
  public static void main(String[] args) {
    String fileName = "images/cond";
    Condition graphDrawing = new Condition();
    TestUtil.drawAndSave(graphDrawing, fileName);
  }
}
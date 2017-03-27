package drawings;

import java.awt.*;
import javax.swing.JPanel;

import resources.Constants;
import utils.TestUtil;

public class ConditionStacked extends JPanel {

  private static final long serialVersionUID = 1L;

  /*
   * test case: 
   * - act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
   * - act2 = new ConresActivity(0, new Point(50, 235), "Activity 2", "ROLE", false, false, false);
   * - rel = new ConresRelation(act2, act1, "cond")
   */
  public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
    
	// ACTIVITY 1
	Point center1 = new Point(100, 100);
    TestUtil.drawAct(g2d, center1, "ROLE", "Activity 1", false, false, false);

	// ACTIVITY 2
	Point center2 = new Point(100, 300);
    TestUtil.drawAct(g2d, center2, "ROLE", "Activity 2", false, false, false);

	// CONDITION
    int circleCondX = TestUtil.getLeftX(center1) + Constants.DOT_SIZE / 2;
    int circleCondY = TestUtil.getUpperY(center1)+ Constants.ACTIVITY_HEIGHT + Constants.DOT_SIZE / 2;
    int triangleCondX = TestUtil.getLeftX(center1) + Constants.DOT_SIZE / 2;
    int triangleCondY = TestUtil.getUpperY(center1) + Constants.ACTIVITY_HEIGHT + Constants.DOT_SIZE;
    int lineCondStartX = TestUtil.getLeftX(center2) + Constants.DOT_SIZE / 2;
    int lineCondEndX = TestUtil.getUpperY(center2);
    TestUtil.drawCond(g2d, circleCondX, circleCondY, triangleCondX, triangleCondY,
    		lineCondStartX, lineCondEndX, 'U', 0, -Constants.DOT_SIZE / 2);
  }
  
  public static void main(String[] args) {
    String fileName = "images/cond_stack";
    ConditionStacked graphDrawing = new ConditionStacked();
    TestUtil.drawAndSave(graphDrawing, fileName);
  }
}
package drawings;

import java.awt.*;
import javax.swing.JPanel;

import resources.Constants;
import utils.TestUtil;

public class TwoRelationsFlipped extends JPanel {

  private static final long serialVersionUID = 1L;

  /*
   * test case: 
   * - act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
   * - act2 = new ConresActivity(0, new Point(250, 35), "Activity 2", "ROLE", false, false, false);
   * - rel1 = new ConresRelation(act1, act2, "cond");
   * - rel2 = new ConresRelation(act2, act1, "resp")
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
    int circleCondX = TestUtil.getLeftX(center2) - Constants.DOT_SIZE / 2;
    int circleCondY = TestUtil.getUpperY(center2) + Constants.DOT_SIZE / 2;
    int triangleCondX = TestUtil.getLeftX(center2) - Constants.DOT_SIZE;
    int triangleCondY = TestUtil.getUpperY(center2) + Constants.DOT_SIZE / 2;
    int lineCondStartX = TestUtil.getRightX(center1);
    int lineCondEndX = TestUtil.getUpperY(center1) + Constants.DOT_SIZE / 2;
    TestUtil.drawCond(g2d, circleCondX, circleCondY, triangleCondX, triangleCondY,
    		lineCondStartX, lineCondEndX, 'R', Constants.DOT_SIZE / 2, 0);
    
    // RESPONSE
    g2d.setColor(Constants.RESPONSE_RELATION_COLOR);
    int circleRespX = TestUtil.getLeftX(center2) - Constants.DOT_SIZE / 2;
    int circleRespY = TestUtil.getUpperY(center2) + Constants.ACTIVITY_HEIGHT / 2 + Constants.DOT_SIZE / 2;
    int triangleRespX = TestUtil.getRightX(center1);
    int triangleRespY = TestUtil.getUpperY(center1) + Constants.ACTIVITY_HEIGHT / 2 + Constants.DOT_SIZE / 2;
    TestUtil.drawResp(g2d, circleRespX, circleRespY, triangleRespX, triangleRespY, 'L', Constants.DOT_SIZE / 2, 0);
  }
  
  public static void main(String[] args) {
    String fileName = "images/two_rels_flip";
    TwoRelationsFlipped graphDrawing = new TwoRelationsFlipped();
    TestUtil.drawAndSave(graphDrawing, fileName);
  }
}
package drawings;

import java.awt.*;
import javax.swing.JPanel;

import resources.Constants;
import utils.TestUtil;

public class ResponseStacked extends JPanel {

  private static final long serialVersionUID = 1L;

  /*
   * test case: 
   * - act1 = new ConresActivity(0, new Point(50, 35), "Activity 1", "ROLE", false, false, false);
   * - act2 = new ConresActivity(0, new Point(50, 235), "Activity 2", "ROLE", false, false, false);
   * - rel = new ConresRelation(act1, act2, "resp")
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
    
    // RESPONSE
    g2d.setColor(Constants.RESPONSE_RELATION_COLOR);
    int circleRespX = TestUtil.getLeftX(center1) + Constants.DOT_SIZE / 2 + Constants.ACTIVITY_WIDTH / 2;
    int circleRespY = TestUtil.getUpperY(center1) + Constants.ACTIVITY_HEIGHT + Constants.DOT_SIZE / 2;
    int triangleRespX = TestUtil.getLeftX(center2) + Constants.DOT_SIZE / 2 + Constants.ACTIVITY_WIDTH / 2;
    int triangleRespY = TestUtil.getUpperY(center2);
    TestUtil.drawResp(g2d, circleRespX, circleRespY, triangleRespX, triangleRespY, 'D', 0, -Constants.DOT_SIZE / 2);
  }
  
  public static void main(String[] args) {
    String fileName = "images/resp_stack";
    ResponseStacked graphDrawing = new ResponseStacked();
    TestUtil.drawAndSave(graphDrawing, fileName);
  }
}
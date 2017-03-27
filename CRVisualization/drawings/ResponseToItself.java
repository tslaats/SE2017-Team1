package drawings;

import java.awt.*;
import javax.swing.JPanel;

import resources.Constants;
import utils.TestUtil;

public class ResponseToItself extends JPanel {

  private static final long serialVersionUID = 1L;

  /*
   * test case: 
   * - act = new ConresActivity(0, new Point(50, 35), "Activity", "ROLE", false, false, false);
   * - rel = new ConresRelation(act, act, "resp")
   */
  public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g; 
	Point center = new Point(100, 100);
    TestUtil.drawAct(g2d, center, "ROLE", "Activity", false, false, false);
    
    g2d.setColor(Constants.RESPONSE_RELATION_COLOR);
    
    // circle
    int circleX = TestUtil.getRightX(center) + Constants.DOT_SIZE / 2;
    int circleY = TestUtil.getUpperY(center) + Constants.ACTIVITY_HEIGHT / 2 - Constants.DOT_SIZE / 2;
    g2d.fillOval(circleX - Constants.DOT_SIZE / 2, circleY - Constants.DOT_SIZE /2, Constants.DOT_SIZE, Constants.DOT_SIZE);
    
    // triangle
    int triangleX1 = TestUtil.getRightX(center);
    int triangleY1 = TestUtil.getUpperY(center) + Constants.ACTIVITY_HEIGHT - Constants.DOT_SIZE / 2;
    
    int triangleX2 = triangleX1 + Constants.TRIANGLE_HEIGHT;
    int triangleY2 = triangleY1 - Constants.TRIANGLE_HEIGHT / 2;
    
	int triangleX3 = triangleX1 + Constants.TRIANGLE_HEIGHT;
	int triangleY3 = triangleY1 + Constants.TRIANGLE_HEIGHT / 2;
	
	int[] xsResp = {triangleX1, triangleX2, triangleX3};
	int[] ysResp = {triangleY1, triangleY2, triangleY3};
	g2d.fillPolygon(xsResp, ysResp, 3);
    
	// line
	int lineEndX = circleX + Constants.ACTIVITY_PADDING - Constants.DOT_SIZE / 2;
	g2d.drawLine(circleX, circleY, lineEndX, circleY);
	g2d.drawLine(lineEndX, circleY, lineEndX, triangleY1);
	g2d.drawLine(lineEndX, triangleY1, triangleX1, triangleY1);
  }
  
  public static void main(String[] args) {
    String fileName = "images/resp_itself";
    ResponseToItself graphDrawing = new ResponseToItself();
    TestUtil.drawAndSave(graphDrawing, fileName, 650);
  }
}
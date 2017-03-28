package drawings;

import java.awt.*;
import javax.swing.JPanel;

import resources.Constants;
import utils.TestUtil;

public class ComplexGraph extends JPanel {

  private static final long serialVersionUID = 1L;

  /*
   * test case: 
   * - actNorth = new ConresActivity(0, new Point(250, 35), "North", "ROLE", false, false, false);
   * - actWest = new ConresActivity(1, new Point(50, 235), "West", "ROLE", false, false, false);
   * - actCenter = new ConresActivity(2, new Point(250, 235), "Center", "ROLE", false, false, false);
   * - actEast = new ConresActivity(3, new Point(450, 235), "East", "ROLE", false, false, false);
   * - actSouth = new ConresActivity(3, new Point(250, 435), "South", "ROLE", false, false, false);
   * - relN1 = new ConresRelation(actNorth, actCenter, "cond");
   * - relN2 = new ConresRelation(actCenter, actNorth, "resp");
   * - relW1 = new ConresRelation(actWest, actCenter, "cond");
   * - relW2 = new ConresRelation(actCenter, actWest, "resp");
   * - relE1 = new ConresRelation(actEast, actCenter, "cond");
   * - relE2 = new ConresRelation(actCenter, actEast, "resp");
   * - relS1 = new ConresRelation(actSouth, actCenter, "cond");
   * - relS2 = new ConresRelation(actCenter, actSouth, "resp");
   */
  public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
    
	// ACTIVITY North
    Point centerNorth = new Point(300, 100);
    TestUtil.drawAct(g2d, centerNorth, "ROLE", "North", false, false, false);
    
    // ACTIVITY West
    Point centerWest = new Point(100, 300);
    TestUtil.drawAct(g2d, centerWest, "ROLE", "West", false, false, false);
    
    // ACTIVITY Center
    Point centerCenter = new Point(300, 300);
    TestUtil.drawAct(g2d, centerCenter, "ROLE", "Center", false, false, false);
    
    // ACTIVITY East
    Point centerEast = new Point(500, 300);
    TestUtil.drawAct(g2d, centerEast, "ROLE", "East", false, false, false);
    
    // ACTIVITY South
    Point centerSouth = new Point(300, 500);
    TestUtil.drawAct(g2d, centerSouth, "ROLE", "South", false, false, false);
    
    // RESPONSE North
    int circleRespXNorth = TestUtil.getLeftX(centerCenter) + Constants.DOT_SIZE / 2;
    int circleRespYNorth = TestUtil.getUpperY(centerCenter) - Constants.DOT_SIZE / 2;
    int triangleRespXNorth = TestUtil.getLeftX(centerNorth) + Constants.DOT_SIZE / 2;;
    int triangleRespYNorth = TestUtil.getUpperY(centerNorth) + Constants.ACTIVITY_HEIGHT;
    TestUtil.drawResp(g2d, circleRespXNorth, circleRespYNorth, triangleRespXNorth, triangleRespYNorth, 'U', 0, Constants.DOT_SIZE / 2);
    
    // CONDITION North 
    int circleCondXNorth = TestUtil.getLeftX(centerCenter) + Constants.ACTIVITY_WIDTH / 2 + Constants.DOT_SIZE / 2;
    int circleCondYNorth = TestUtil.getUpperY(centerCenter) - Constants.DOT_SIZE / 2;
    int triangleCondXNorth = TestUtil.getLeftX(centerCenter) + Constants.ACTIVITY_WIDTH / 2 + Constants.DOT_SIZE / 2;
    int triangleCondYNorth = TestUtil.getUpperY(centerCenter) - Constants.DOT_SIZE;
    int lineCondStartXNorth = TestUtil.getLeftX(centerNorth) + Constants.ACTIVITY_WIDTH / 2 + Constants.DOT_SIZE / 2;
    int lineCondEndXNorth = TestUtil.getUpperY(centerNorth) + Constants.ACTIVITY_HEIGHT;
    TestUtil.drawCond(g2d, circleCondXNorth, circleCondYNorth, triangleCondXNorth, triangleCondYNorth,
    		lineCondStartXNorth, lineCondEndXNorth, 'D', 0, Constants.DOT_SIZE / 2);
    
    // RESPONSE West
    int circleRespXWest = TestUtil.getLeftX(centerCenter) - Constants.DOT_SIZE / 2;
    int circleRespYWest = TestUtil.getUpperY(centerCenter) + Constants.ACTIVITY_HEIGHT / 2 + Constants.DOT_SIZE / 2;
    int triangleRespXWest = TestUtil.getRightX(centerWest);
    int triangleRespYWest = TestUtil.getUpperY(centerWest) + Constants.ACTIVITY_HEIGHT / 2 + Constants.DOT_SIZE / 2;
    TestUtil.drawResp(g2d, circleRespXWest, circleRespYWest, triangleRespXWest, triangleRespYWest, 'L', Constants.DOT_SIZE / 2, 0);

    // CONDITION West 
    int circleCondXWest = TestUtil.getLeftX(centerCenter) - Constants.DOT_SIZE / 2;
    int circleCondYWest = TestUtil.getUpperY(centerCenter) + Constants.DOT_SIZE / 2;
    int triangleCondXWest = TestUtil.getLeftX(centerCenter) - Constants.DOT_SIZE;
    int triangleCondYWest = TestUtil.getUpperY(centerCenter) + Constants.DOT_SIZE / 2;
    int lineCondStartXWest = TestUtil.getRightX(centerWest);
    int lineCondEndXWest = TestUtil.getUpperY(centerWest) + Constants.DOT_SIZE / 2;
    TestUtil.drawCond(g2d, circleCondXWest, circleCondYWest, triangleCondXWest, triangleCondYWest,
    		lineCondStartXWest, lineCondEndXWest, 'R', Constants.DOT_SIZE / 2, 0);
    
    // RESPONSE East
    int circleRespXEast = TestUtil.getRightX(centerCenter) + Constants.DOT_SIZE / 2;
    int circleRespYEast = TestUtil.getUpperY(centerCenter) + Constants.DOT_SIZE / 2;
    int triangleRespXEast = TestUtil.getLeftX(centerEast);
    int triangleRespYEast = TestUtil.getUpperY(centerEast) + Constants.DOT_SIZE / 2;
    TestUtil.drawResp(g2d, circleRespXEast, circleRespYEast, triangleRespXEast, triangleRespYEast, 'R', -Constants.DOT_SIZE / 2, 0);
    
    // CONDITION East 
    int circleCondXEast = TestUtil.getRightX(centerCenter) + Constants.DOT_SIZE / 2;
    int circleCondYEast = TestUtil.getUpperY(centerCenter)+ Constants.ACTIVITY_HEIGHT / 2 + Constants.DOT_SIZE / 2;
    int triangleCondXEast = TestUtil.getRightX(centerCenter) + Constants.DOT_SIZE;
    int triangleCondYEast = TestUtil.getUpperY(centerCenter)+ Constants.ACTIVITY_HEIGHT / 2 + Constants.DOT_SIZE / 2;
    int lineCondStartXEast = TestUtil.getLeftX(centerEast);
    int lineCondEndXEast = TestUtil.getUpperY(centerEast) + Constants.ACTIVITY_HEIGHT / 2 + Constants.DOT_SIZE / 2;
    TestUtil.drawCond(g2d, circleCondXEast, circleCondYEast, triangleCondXEast, triangleCondYEast,
    		lineCondStartXEast, lineCondEndXEast, 'L', 0, 0);
    
    // RESPONSE South
    int circleRespXSouth = TestUtil.getLeftX(centerCenter) + Constants.DOT_SIZE / 2 + Constants.ACTIVITY_WIDTH / 2;
    int circleRespYSouth = TestUtil.getUpperY(centerCenter) + Constants.ACTIVITY_HEIGHT + Constants.DOT_SIZE / 2;
    int triangleRespXSouth = TestUtil.getLeftX(centerSouth) + Constants.DOT_SIZE / 2 + Constants.ACTIVITY_WIDTH / 2;
    int triangleRespYSouth = TestUtil.getUpperY(centerSouth);
    TestUtil.drawResp(g2d, circleRespXSouth, circleRespYSouth, triangleRespXSouth, triangleRespYSouth, 'D', 0, -Constants.DOT_SIZE / 2);
  
    // CONDITION South 
    int circleCondXSouth = TestUtil.getLeftX(centerCenter) + Constants.DOT_SIZE / 2;
    int circleCondYSouth = TestUtil.getUpperY(centerCenter)+ Constants.ACTIVITY_HEIGHT + Constants.DOT_SIZE / 2;
    int triangleCondXSouth = TestUtil.getLeftX(centerCenter) + Constants.DOT_SIZE / 2;
    int triangleCondYSouth = TestUtil.getUpperY(centerCenter) + Constants.ACTIVITY_HEIGHT + Constants.DOT_SIZE;
    int lineCondStartXSouth = TestUtil.getLeftX(centerSouth) + Constants.DOT_SIZE / 2;
    int lineCondEndXSouth = TestUtil.getUpperY(centerSouth);
    TestUtil.drawCond(g2d, circleCondXSouth, circleCondYSouth, triangleCondXSouth, triangleCondYSouth,
    		lineCondStartXSouth, lineCondEndXSouth, 'U', 0, -Constants.DOT_SIZE / 2);
  }
  
  public static void main(String[] args) {
    String fileName = "images/complex";
    ComplexGraph graphDrawing = new ComplexGraph();
    TestUtil.drawAndSave(graphDrawing, fileName, 650);
  }
}
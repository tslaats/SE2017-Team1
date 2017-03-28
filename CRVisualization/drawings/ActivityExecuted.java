package drawings;

import java.awt.*;
import javax.swing.JPanel;

import utils.TestUtil;

public class ActivityExecuted extends JPanel {

  private static final long serialVersionUID = 1L;

  /*
   * test case: 
   * - act = new ConresActivity(0, new Point(50, 35), "Activity", "ROLE", true, false, false);
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
	Point center = new Point(100, 100);
    TestUtil.drawAct(g2d, center, "ROLE", "Activity", true, false, false);
  }

  public static void main(String[] args) {
    String fileName = "images/exec_act";
    ActivityExecuted graphDrawing = new ActivityExecuted();
    TestUtil.drawAndSave(graphDrawing, fileName);
  }
}
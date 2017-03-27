package drawings;

import java.awt.*;
import javax.swing.JPanel;

import utils.TestUtil;

public class ActivityExecutedPetri extends JPanel {

  private static final long serialVersionUID = 1L;

  /*
   * test case: 
   * - act = new ConresActivity(0, new Point(50, 35), "Activity", "ROLE", true, false, true);
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
	Point center = new Point(100, 100);
    TestUtil.drawAct(g2d, center, "ROLE", "Activity", true, false, true);
  }

  public static void main(String[] args) {
    String fileName = "images/petri_exec_act";
    ActivityExecutedPetri graphDrawing = new ActivityExecutedPetri();
    TestUtil.drawAndSave(graphDrawing, fileName);
  }
}
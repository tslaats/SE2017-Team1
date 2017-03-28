package drawings;

import java.awt.*;
import javax.swing.JPanel;

import utils.TestUtil;

public class ActivityPendingPetri extends JPanel {

  private static final long serialVersionUID = 1L;

  /*
   * test case: 
   * - act = new ConresActivity(0, new Point(50, 35), "Activity", "ROLE", false, true, true);
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
	Point center = new Point(100, 100);
    TestUtil.drawAct(g2d, center, "ROLE", "Activity", false, true, true);
  }

  public static void main(String[] args) {
    String fileName = "images/petri_pend_act";
    ActivityPendingPetri graphDrawing = new ActivityPendingPetri();
    TestUtil.drawAndSave(graphDrawing, fileName);
  }
}
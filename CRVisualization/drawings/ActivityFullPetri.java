package drawings;

import java.awt.*;
import javax.swing.JPanel;

import utils.TestUtil;

public class ActivityFullPetri extends JPanel {

  private static final long serialVersionUID = 1L;

  /*
   * test case: 
   * - act = new ConresActivity(0, new Point(50, 35), "Activity", "ROLE", true, true, true);
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
	Point center = new Point(100, 100);
    TestUtil.drawAct(g2d, center, "ROLE", "Activity", true, true, true);
  }

  public static void main(String[] args) {
    String fileName = "images/petri_full_act";
    ActivityFullPetri graphDrawing = new ActivityFullPetri();
    TestUtil.drawAndSave(graphDrawing, fileName);
  }
}
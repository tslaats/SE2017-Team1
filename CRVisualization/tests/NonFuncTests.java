package tests;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import org.junit.Test;

import structure.ConresActivity;
import structure.ConresGraph;
import structure.ConresRelation;
import utils.CRGVlib;
import utils.TestUtil;

import static org.junit.Assert.assertTrue;

public class NonFuncTests {

	private CRGVlib crv = new CRGVlib();

    @Test
    public void test53Acts() throws Exception {
    	int canvasSize = 2000;

        String fileNameGenerated = "images/generated/complex_53";
        ConresGraph graph = new ConresGraph();

		ConresActivity act1 = new ConresActivity(0, new Point(0, 0), "Act 1", "ROLE", false, false, false);
		ConresActivity act2 = new ConresActivity(1, new Point(180, 0), "Act 2", "ROLE", false, false, false);
		ConresActivity act3 = new ConresActivity(2, new Point(360, 0), "Act 3", "ROLE", false, false, false);
		ConresActivity act4 = new ConresActivity(3, new Point(540, 0), "Act 4", "ROLE", false, false, false);
		ConresActivity act5 = new ConresActivity(4, new Point(720, 0), "Act 5", "ROLE", false, false, false);
		ConresActivity act6 = new ConresActivity(5, new Point(900, 0), "Act 6", "ROLE", false, false, false);
		ConresActivity act7 = new ConresActivity(6, new Point(1080, 0), "Act 7", "ROLE", false, false, false);
		ConresActivity act8 = new ConresActivity(7, new Point(1260, 0), "Act 8", "ROLE", false, false, false);
		
		ConresActivity act9 = new ConresActivity(8, new Point(1260, 180), "Act 9", "ROLE", false, false, false);
		ConresActivity act10 = new ConresActivity(9, new Point(1080, 180), "Act 10", "ROLE", false, false, false);
		ConresActivity act11 = new ConresActivity(10, new Point(900, 180), "Act 11", "ROLE", false, false, false);
		ConresActivity act12 = new ConresActivity(11, new Point(720, 180), "Act 12", "ROLE", false, false, false);
		ConresActivity act13 = new ConresActivity(12, new Point(540, 180), "Act 13", "ROLE", false, false, false);
		ConresActivity act14 = new ConresActivity(13, new Point(360, 180), "Act 14", "ROLE", false, false, false);
		ConresActivity act15 = new ConresActivity(14, new Point(180, 180), "Act 15", "ROLE", false, false, false);
		ConresActivity act16 = new ConresActivity(15, new Point(0, 180), "Act 16", "ROLE", false, false, false);
		
		ConresActivity act17 = new ConresActivity(16, new Point(0, 360), "Act 17", "ROLE", false, false, false);
		ConresActivity act18 = new ConresActivity(17, new Point(180, 360), "Act 18", "ROLE", false, false, false);
		ConresActivity act19 = new ConresActivity(18, new Point(360, 360), "Act 19", "ROLE", false, false, false);
		ConresActivity act20 = new ConresActivity(19, new Point(540, 360), "Act 20", "ROLE", false, false, false);
		ConresActivity act21 = new ConresActivity(20, new Point(720, 360), "Act 21", "ROLE", false, false, false);
		ConresActivity act22 = new ConresActivity(21, new Point(900, 360), "Act 22", "ROLE", false, false, false);
		ConresActivity act23 = new ConresActivity(22, new Point(1080, 360), "Act 23", "ROLE", false, false, false);
		ConresActivity act24 = new ConresActivity(23, new Point(1260, 360), "Act 24", "ROLE", false, false, false);
		
		ConresActivity act25 = new ConresActivity(24, new Point(1260, 540), "Act 25", "ROLE", false, false, false);
		ConresActivity act26 = new ConresActivity(25, new Point(1080, 540), "Act 26", "ROLE", false, false, false);
		ConresActivity act27 = new ConresActivity(26, new Point(900, 540), "Act 27", "ROLE", false, false, false);
		ConresActivity act28 = new ConresActivity(27, new Point(720, 540), "Act 28", "ROLE", false, false, false);
		ConresActivity act29 = new ConresActivity(28, new Point(540, 540), "Act 29", "ROLE", false, false, false);
		ConresActivity act30 = new ConresActivity(29, new Point(360, 540), "Act 30", "ROLE", false, false, false);
		ConresActivity act31 = new ConresActivity(30, new Point(180, 540), "Act 31", "ROLE", false, false, false);
		ConresActivity act32 = new ConresActivity(31, new Point(0, 540), "Act 32", "ROLE", false, false, false);
		
		// IN FRONT OF
		ConresActivity act33 = new ConresActivity(32, new Point(90, 90), "Act 33", "ROLE", false, false, false);
		ConresActivity act34 = new ConresActivity(33, new Point(270, 90), "Act 34", "ROLE", false, false, false);
		ConresActivity act35 = new ConresActivity(34, new Point(450, 90), "Act 35", "ROLE", false, false, false);
		ConresActivity act36 = new ConresActivity(35, new Point(630, 90), "Act 36", "ROLE", false, false, false);
		ConresActivity act37 = new ConresActivity(36, new Point(810, 90), "Act 37", "ROLE", false, false, false);
		ConresActivity act38 = new ConresActivity(37, new Point(990, 90), "Act 38", "ROLE", false, false, false);
		ConresActivity act39 = new ConresActivity(38, new Point(1170, 90), "Act 39", "ROLE", false, false, false);
		
		ConresActivity act40 = new ConresActivity(39, new Point(1170, 270), "Act 40", "ROLE", false, false, false);
		ConresActivity act41 = new ConresActivity(40, new Point(990, 270), "Act 41", "ROLE", false, false, false);
		ConresActivity act42 = new ConresActivity(41, new Point(810, 270), "Act 42", "ROLE", false, false, false);
		ConresActivity act43 = new ConresActivity(42, new Point(630, 270), "Act 43", "ROLE", false, false, false);
		ConresActivity act44 = new ConresActivity(43, new Point(450, 270), "Act 44", "ROLE", false, false, false);
		ConresActivity act45 = new ConresActivity(44, new Point(270, 270), "Act 45", "ROLE", false, false, false);
		ConresActivity act46 = new ConresActivity(45, new Point(90, 270), "Act 46", "ROLE", false, false, false);
		
		ConresActivity act47 = new ConresActivity(46, new Point(90, 450), "Act 47", "ROLE", false, false, false);
		ConresActivity act48 = new ConresActivity(47, new Point(270, 450), "Act 48", "ROLE", false, false, false);
		ConresActivity act49 = new ConresActivity(48, new Point(450, 450), "Act 49", "ROLE", false, false, false);
		ConresActivity act50 = new ConresActivity(49, new Point(630, 450), "Act 50", "ROLE", false, false, false);
		ConresActivity act51 = new ConresActivity(50, new Point(810, 450), "Act 51", "ROLE", false, false, false);
		ConresActivity act52 = new ConresActivity(51, new Point(990, 450), "Act 52", "ROLE", false, false, false);
		ConresActivity act53 = new ConresActivity(52, new Point(1170, 450), "Act 53", "ROLE", false, false, false);
		
		graph.activities = new ArrayList<ConresActivity>(
				Arrays.asList(act1, act2, act3, act4, act5, act6, act7, act8,
						act9, act10, act11, act12, act13, act14, act15, act16,
						act17, act18, act19, act20, act21, act22, act23, act24,
						act25, act26, act27, act28, act29, act30, act31, act32,
						act33, act34, act35, act36, act37, act38, act39,
						act40, act41, act42, act43, act44, act45, act46,
						act47, act48, act49, act50, act51, act52, act53));

		ConresRelation cond1 = new ConresRelation(act1, act2, "cond");
		ConresRelation cond2 = new ConresRelation(act2, act3, "cond");
		ConresRelation cond3 = new ConresRelation(act3, act4, "cond");
		ConresRelation cond4 = new ConresRelation(act4, act5, "cond");
		ConresRelation cond5 = new ConresRelation(act5, act6, "cond");
		ConresRelation cond6 = new ConresRelation(act6, act7, "cond");
		ConresRelation cond7 = new ConresRelation(act7, act8, "cond");
		
		ConresRelation cond8 = new ConresRelation(act8, act9, "cond");
		ConresRelation cond9 = new ConresRelation(act9, act10, "cond");
		ConresRelation cond10 = new ConresRelation(act10, act11, "cond");
		ConresRelation cond11 = new ConresRelation(act11, act12, "cond");
		ConresRelation cond12 = new ConresRelation(act12, act13, "cond");
		ConresRelation cond13 = new ConresRelation(act13, act14, "cond");
		ConresRelation cond14 = new ConresRelation(act14, act15, "cond");
		ConresRelation cond15 = new ConresRelation(act15, act16, "cond");

		ConresRelation cond24 = new ConresRelation(act24, act25, "cond");
		ConresRelation cond25 = new ConresRelation(act25, act26, "cond");
		ConresRelation cond26 = new ConresRelation(act26, act27, "cond");
		ConresRelation cond27 = new ConresRelation(act27, act28, "cond");
		ConresRelation cond28 = new ConresRelation(act28, act29, "cond");
		ConresRelation cond29 = new ConresRelation(act29, act30, "cond");
		ConresRelation cond30 = new ConresRelation(act30, act31, "cond");
		ConresRelation cond31 = new ConresRelation(act31, act32, "cond");
		
		ConresRelation cond39 = new ConresRelation(act39, act40, "cond");
		ConresRelation cond40 = new ConresRelation(act40, act41, "cond");
		ConresRelation cond41 = new ConresRelation(act41, act42, "cond");
		ConresRelation cond42 = new ConresRelation(act42, act43, "cond");
		ConresRelation cond43 = new ConresRelation(act43, act44, "cond");
		ConresRelation cond44 = new ConresRelation(act44, act45, "cond");
		ConresRelation cond45 = new ConresRelation(act45, act46, "cond");
		ConresRelation cond46 = new ConresRelation(act46, act47, "cond");
		
		ConresRelation resp1 = new ConresRelation(act2, act1, "resp");
		ConresRelation resp2 = new ConresRelation(act3, act2, "resp");
		ConresRelation resp3 = new ConresRelation(act4, act3, "resp");
		ConresRelation resp4 = new ConresRelation(act5, act4, "resp");
		ConresRelation resp5 = new ConresRelation(act6, act5, "resp");
		ConresRelation resp6 = new ConresRelation(act7, act6, "resp");
		ConresRelation resp7 = new ConresRelation(act8, act7, "resp");

		ConresRelation resp16 = new ConresRelation(act17, act16, "resp");
		ConresRelation resp17 = new ConresRelation(act18, act17, "resp");
		ConresRelation resp18 = new ConresRelation(act19, act18, "resp");
		ConresRelation resp19 = new ConresRelation(act20, act19, "resp");
		ConresRelation resp20 = new ConresRelation(act21, act20, "resp");
		ConresRelation resp21 = new ConresRelation(act22, act21, "resp");
		ConresRelation resp22 = new ConresRelation(act23, act22, "resp");
		ConresRelation resp23 = new ConresRelation(act24, act23, "resp");
		
		ConresRelation resp33 = new ConresRelation(act34, act33, "resp");
		ConresRelation resp34 = new ConresRelation(act35, act34, "resp");
		ConresRelation resp35 = new ConresRelation(act36, act35, "resp");
		ConresRelation resp36 = new ConresRelation(act37, act36, "resp");
		ConresRelation resp37 = new ConresRelation(act38, act37, "resp");
		ConresRelation resp38 = new ConresRelation(act39, act38, "resp");
		
		ConresRelation resp47 = new ConresRelation(act48, act47, "resp");
		ConresRelation resp48 = new ConresRelation(act49, act48, "resp");
		ConresRelation resp49 = new ConresRelation(act50, act49, "resp");
		ConresRelation resp50 = new ConresRelation(act51, act50, "resp");
		ConresRelation resp51 = new ConresRelation(act52, act51, "resp");
		ConresRelation resp52 = new ConresRelation(act53, act52, "resp");
		
		graph.relations = new ArrayList<ConresRelation>(
				Arrays.asList(cond1, cond2, cond3, cond4, cond5, cond6, cond7,
						cond8, cond9, cond10, cond11, cond12, cond13, cond14, cond15,
						cond24, cond25, cond26, cond27, cond28, cond29, cond30, cond31,
						cond39, cond40, cond41, cond42, cond43, cond44, cond45, cond46,
						resp1, resp2, resp3, resp4, resp5, resp6, resp7,
						resp16, resp17, resp18, resp19, resp20, resp21, resp22, resp23,
						resp33, resp34, resp35, resp36, resp37, resp38,
						resp47, resp48, resp49, resp50, resp51, resp52));
		
		long startTime = System.nanoTime();
		JPanel graphGenerated = crv.draw(graph);
		long endTime = System.nanoTime();
        double duration	= (endTime - startTime) / 1000000000.0;	

        TestUtil.drawAndSave(graphGenerated, fileNameGenerated, canvasSize);

    	assertTrue(duration <= 1);
    }
}

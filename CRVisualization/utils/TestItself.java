package utils;

import java.awt.*;
import javax.swing.JPanel;

import resources.MalformedGraphException;
import structure.ConresActivity;
import structure.ConresGraph;
import structure.ConresRelation;
import java.util.*;

/**
 *  This is main where we draw our stuff
 */
public class TestItself extends JPanel {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		int canvasSize = 650;
        String fileName = "images/itself";
        
        ConresGraph graph = new ConresGraph();
        CRGVlib crv = new CRGVlib();
        
		ConresActivity act = new ConresActivity(0, new Point(250, 235), "Activity", "ROLE", false, false, false);
		ConresActivity actLeft1 = new ConresActivity(1, new Point(50, 135), "Left 1", "ROLE", false, false, false);
		ConresActivity actLeft2 = new ConresActivity(2, new Point(50, 335), "Left 2", "ROLE", false, false, false);
		ConresActivity actRight1 = new ConresActivity(3, new Point(450, 135), "Right 1", "ROLE", false, false, false);
		ConresActivity actRight2 = new ConresActivity(4, new Point(450, 335), "Right 2", "ROLE", false, false, false);
		ConresActivity actUp1 = new ConresActivity(5, new Point(180, 35), "Up 1", "ROLE", false, false, false);
		ConresActivity actUp2 = new ConresActivity(7, new Point(320, 35), "Up 2", "ROLE", false, false, false);
		ConresActivity actDown1 = new ConresActivity(6, new Point(180, 435), "Down 1", "ROLE", false, false, false);
		ConresActivity actDown2 = new ConresActivity(8, new Point(320, 435), "Down 2", "ROLE", false, false, false);
		graph.activities = new ArrayList<ConresActivity>(
				Arrays.asList(act, actLeft1, actLeft2, actRight1, actRight2, actUp1, actUp2, actDown1, actDown2));
		
		ConresRelation resp = new ConresRelation(act, act, "resp");
		ConresRelation condLeft1 = new ConresRelation(act, actLeft1, "cond");
		ConresRelation respLeft1 = new ConresRelation(actLeft1, act, "resp");
		ConresRelation condLeft2 = new ConresRelation(act, actLeft2, "cond");
		ConresRelation respLeft2 = new ConresRelation(actLeft2, act, "resp");
		ConresRelation condRight1 = new ConresRelation(act, actRight1, "cond");
		ConresRelation respRight1 = new ConresRelation(actRight1, act, "resp");
		ConresRelation condRight2 = new ConresRelation(act, actRight2, "cond");
		ConresRelation respRight2 = new ConresRelation(actRight2, act, "resp");
		ConresRelation condUp1 = new ConresRelation(act, actUp1, "cond");
		ConresRelation respUp1 = new ConresRelation(actUp1, act, "resp");
		ConresRelation condUp2 = new ConresRelation(act, actUp2, "cond");
		ConresRelation respUp2 = new ConresRelation(actUp2, act, "resp");
		ConresRelation condDown1 = new ConresRelation(act, actDown1, "cond");
		ConresRelation respDown1 = new ConresRelation(actDown1, act, "resp");
		ConresRelation condDown2 = new ConresRelation(act, actDown2, "cond");
		ConresRelation respDown2 = new ConresRelation(actDown2, act, "resp");
		graph.relations = new ArrayList<ConresRelation>(Arrays.asList(resp, condLeft1, respLeft1,
				condLeft2, respLeft2, condRight1, respRight1, condRight2, respRight2, condUp1, respUp1,
				condUp2, respUp2, condDown1, respDown1, condDown2, respDown2));

		try {
			JPanel graphDrawing = crv.draw(graph);
			TestUtil.drawAndSave(graphDrawing, fileName, canvasSize);
		} catch (MalformedGraphException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
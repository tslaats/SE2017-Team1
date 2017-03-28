package utils;

import java.awt.*;

import javax.swing.JPanel;

import structure.Activity;
import gui.ConresEvent;
import gui.ConresRelation.Type;
import gui.ConresGraph;
import gui.ConresRelation;
import structure.Relation;

import java.util.*;

/**
 *  This is main where we draw our stuff
 */
public class CRPanel extends JPanel {
  private static final long serialVersionUID = 1L;
 
  private ConresGraph graphToDraw;
  private ActivityDrawingFactory activityDrawingFactory = new ActivityDrawingFactory();
  private RelationDrawingFactory relationDrawingFactory = new RelationDrawingFactory();
  
  public CRPanel(ConresGraph graph) {
  	super();
    this.graphToDraw = graph;
  }
  
  protected static Activity convertToActivity(ConresEvent conresevent){ 
  	return new Activity(conresevent.position, conresevent.name, conresevent.role, conresevent.isExecuted, conresevent.isPending, conresevent.hasSubgraph());
  }
  
  protected static Relation convertToRelation(ConresRelation conresRelation){
	  Activity parent = convertToActivity(conresRelation.getParent());
	  Activity child = convertToActivity(conresRelation.getChild());
	  Type type = conresRelation.getType();
	  return new Relation(parent, child, type);
  }
  
  /*
   * this is where we draw stuff
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Set<Activity> acts = new HashSet<Activity>();
	Set<Relation> rels = new HashSet<Relation>();
    Graphics2D g2d = (Graphics2D) g; 
    for (ConresEvent conresevent : graphToDraw.events) {
    	Activity activity = convertToActivity(conresevent); 
		activityDrawingFactory.drawActivity(g2d, activity);
		acts.add(activity);
	}
	for (ConresRelation conresRelation : graphToDraw.relations) {
		Relation relation = convertToRelation(conresRelation);
		rels.add(relation);
	}
    //calculate start and end points for all relations
	 for (Activity act : acts) {
	      rels.addAll(relationDrawingFactory.setInRelations(act, rels));
	      rels.addAll(relationDrawingFactory.setOutRelations(act, rels));
	  }

	 for (Relation rel : rels) {
	     if(rel.getType() == Type.Response) {
	       relationDrawingFactory.drawResponseRelation(g2d, rel);
	     }
	     if(rel.getType() == Type.Condition) {
	       relationDrawingFactory.drawConditionRelation(g2d, rel);
	     }
	 }

  }
}
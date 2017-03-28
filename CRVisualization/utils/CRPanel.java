package utils;

import java.awt.*;
import javax.swing.JPanel;

import structure.Activity;
import structure.ConresActivity;
import structure.ConresGraph;
import structure.ConresRelation;
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
  
  protected static Activity convertToActivity(ConresActivity conresActivity){ 
  	return new Activity(conresActivity.getPosition(), conresActivity.getBody(), conresActivity.getTitle(),
  			conresActivity.getExecuted(), conresActivity.getPending(), conresActivity.containsPetri());
  }
  
  protected static Relation convertToRelation(ConresRelation conresRelation){
	  Activity parent = convertToActivity(conresRelation.getParent());
	  Activity child = convertToActivity(conresRelation.getChild());
	  String type = conresRelation.getType();
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
    for (ConresActivity conresActivity : graphToDraw.activities) {
    	Activity activity = convertToActivity(conresActivity); 
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
	     if(rel.getType() == "resp") {
	       relationDrawingFactory.drawResponseRelation(g2d, rel);
	     }
	     if(rel.getType() == "cond") {
	       relationDrawingFactory.drawConditionRelation(g2d, rel);
	     }
	 }

  }
}
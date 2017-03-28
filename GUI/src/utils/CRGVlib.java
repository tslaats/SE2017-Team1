package utils;

import gui.ConresEvent;
import gui.ConresRelation.Type;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import resources.Constants;
import resources.MalformedGraphException;
import structure.Activity;
import gui.ConresGraph;
import gui.ConresRelation;
import structure.Relation;

public class CRGVlib extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanel draw(ConresGraph graph) throws MalformedGraphException {
		if (!isValidRelations(graph)) {
			throw new MalformedGraphException("Activities to be connected are too close together!");
		}
		
		if (!isWellDefinedRelations(graph)) {
			throw new MalformedGraphException("Relations are not well defined!");
		}
		
		return new CRPanel(graph);
	}
	
	private boolean isValidRelations(ConresGraph graph) {
		Set<Relation> rels = new HashSet<Relation>();
		for (ConresRelation conresRelation : graph.relations) {
			Relation relation = CRPanel.convertToRelation(conresRelation);
			rels.add(relation);
		}
		
		double minDist = Constants.EVENT_WIDTH + 2 * (Constants.EVENT_PADDING + Constants.TRIANGLE_HEIGHT);
		double dist;
		for (Relation rel : rels) {
			if (!rel.getParent().equals(rel.getChild())) {
				dist = RelationDrawingFactory.getDistance(rel.getChild(), rel.getParent());
				if (dist < minDist) {
					return false;	
				}
			}
		}
		
		return true;
	}
	
	private boolean isWellDefinedRelations(ConresGraph graph) {
	    Set<String> acts = new HashSet<>();
		Set<Relation> rels = new HashSet<>();

	    for (ConresEvent conresEvent : graph.events) {
	    	Activity activity = CRPanel.convertToActivity(conresEvent); 
			acts.add(activity.getBody());
		}
	    
		for (ConresRelation conresRelation : graph.relations) {
			Relation relation = CRPanel.convertToRelation(conresRelation);
			rels.add(relation);
		}
		
		for (Relation rel : rels) {
			if (acts.contains(rel.getParent().getBody()) && acts.contains(rel.getChild().getBody())) {
				if (rel.getType() == Type.Condition && rel.getParent().equals(rel.getChild())) {
					return false;
				}
			} else {
				return false;
			}
		}
		
		return true;
	}

}

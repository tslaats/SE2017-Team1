package utils;

import crSemantics.CRSemantics;
import graph.ConresGraph;
import interfaces.Graph;
import interfaces.Semantics;

public class SemanticsFactory {
	
	public CRSemantics crSemantics = null;
	
	// TODO ADD PETRI GRAPH PLUS SEMANTICS.
	public Semantics getSemantics(Graph graph){
		
		if (graph instanceof ConresGraph){
			if (crSemantics == null){
				return new CRSemantics();
			}
			return crSemantics;
		}		
		return null;
				
	}

}

package utils;

import javax.swing.JPanel;

import structure.ConresGraph;

public class CRGVlib extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanel draw(ConresGraph graph){
		return new CRPanel(graph);
	}
	
}

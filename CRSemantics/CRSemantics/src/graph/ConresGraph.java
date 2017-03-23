package graph;

import java.util.ArrayList;

import interfaces.Graph;

public class ConresGraph implements Graph {
    public ArrayList<ConresActivity> activities;
    public ArrayList<ConresRelation> relations;

    public ConresGraph(ArrayList<ConresActivity> activities, ArrayList<ConresRelation> relations){
        this.activities = activities;
        this.relations = relations;

    }
}

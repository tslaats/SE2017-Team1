package graph;

import java.util.List;

import interfaces.Graph;

public class ConresGraph implements Graph {
    public List<ConresActivity> activities;
    public List<ConresRelation> relations;

    public ConresGraph(List<ConresActivity> activities, List<ConresRelation> relations){
        this.activities = activities;
        this.relations = relations;

    }
}

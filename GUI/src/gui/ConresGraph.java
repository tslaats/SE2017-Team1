package gui;


import java.util.ArrayList;
import java.awt.Point;
import java.util.stream.Collectors;

/**
 *  This is the graph derived class, that holds all information for a condition-
 *  response graph object. Unlike the petri class this simply holds two lists of
 *  activities and relations, both through lazy instantiation on instance create
 */
public class ConresGraph extends Graph
{
    public ArrayList<ConresEvent>       events          = new ArrayList<ConresEvent>();
    public ArrayList<ConresRelation>    relations       = new ArrayList<ConresRelation>();

    /*
     *  There's nothing inside the constructor yet. Since we do not add anything
     *  to the graph immediately when we create it. But the constructor is still
     *  defined, to explicit make it clear that it exists, and has no parameters
     */
    public ConresGraph ()
    {

    }

    /*
     *  This is a toString override. It creates a pretty print format of all the
     *  content. It even handles the cases where the start and end points appear
     *  as null values. It creates a nice multi-line formatted structure, whitch
     *  allows the user to visually inspect the data, and see how it appears, as
     *  a list. It does not format to any graph like image though. This is meant
     *  for debugging purposes, and for these reasons stringbuilder was not used
     *  even though it would be obvious. The format looks weird, but look at the
     *  course page, for a post about the format and how it looks after printing
     */
    public String toString ()
    {
        // figure out what shit has subgraphs..
        
        String nodesWithSubgraph = "";
        
        for (ConresEvent ce : events)
        {
            if (ce.hasSubgraph())
            {
                nodesWithSubgraph = nodesWithSubgraph + ce.id + ",";
            }
        }
        
        nodesWithSubgraph = (nodesWithSubgraph.length() > 0 ? nodesWithSubgraph.substring(0, nodesWithSubgraph.length() - 1) : "none");
        
        String   result = "ConresGraph (subgraphs: " + nodesWithSubgraph + ")";

        result = result + "\n- Events:";

        for (ConresEvent e : events)
        {
            result = result + "\n    " + e;
        }

        result = result + "\n- Relations:";

        for (ConresRelation r : relations)
        {
            result = result + "\n    " + r;
        }

        return (result);
    }

    public ConresEvent getEvent (int id) throws IllegalArgumentException
    {
      for (ConresEvent event : events)
      {
        if (event.id == id)
        {
          return event;
        }
      }
      
      throw new IllegalArgumentException();
    }
}

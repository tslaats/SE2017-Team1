package gui;
/**
 *  @project >> Software Engineering 2017
 *  @authors >> Emil S. Bak, Philip Falck, Emil SLot Arakelian Jensen
 *  @contact >> 
 *  @version >> 1.2.1
 *  @updated >> 31/03-2017
 *  @licence >> MIT
 *  @sources >> 
 */

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *  This is the petri graph base data structure. It extends from the super class
 *  Graph. It holds all of the information that a petri graph needs, and all the
 *  constructors that the user interface group needs to create, and populate the
 *  structure. This includes transitions, places and indicator for start and end
 */
public class PetriGraph extends Graph
{
    public PetriPlace                   start           = null;
    public PetriPlace                   end             = null;
    public ArrayList<PetriTransition>   transitions     = new ArrayList<PetriTransition>();
    public ArrayList<PetriPlace>        places          = new ArrayList<PetriPlace>();
    
    /**
     *  This is an empty constructor, that is used to instantiate a new instance
     *  of the PetriGraph class. It takes no parameters and it might appear like
     *  it isn't doing anything. However, the variables are instantiated using a
     *  lazy-instantiation, so they do not need to be created in the constructor
     *  at all. But the constructor still has to be defined, as we might need to
     *  implement more constructors or add additional auto-generated information
     */
    public PetriGraph ()
    {
        
    }
    
    /**
     * Gets the transition based on the given ID, if no matching transition with
     * that ID is found the function throws an IllegalArgumentException.
     */
    public PetriTransition getTransition (int id) throws IllegalArgumentException
    {
      for (PetriTransition transition : transitions)
      {
        if (transition.id == id)
        {
          return transition;
        }
      }
      throw new IllegalArgumentException();
    }
    
    /**
     *  Since a start can be null, this getter allows a caller to check if there
     *  is actually anything assigned to the variable, or if it is actually null
     */
    public boolean hasStart ()
    {
        return (start != null);
    }
    
    /**
     *  Since an end can be null, this getter allows a caller, to check if there
     *  is actually anything assigned to the variable, or if it is actually null
     */
    public boolean hasEnd ()
    {
        return (end != null);
    }
    
    /**
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
        String nodesWithSubgraph = "";
        
        for (PetriTransition pt : transitions)
        {
            if (pt.hasSubgraph())
            {
                nodesWithSubgraph = nodesWithSubgraph + pt.id + ",";
            }
        }
        
		nodesWithSubgraph = (nodesWithSubgraph.length() > 0 ? nodesWithSubgraph.substring(0, nodesWithSubgraph.length() - 1) : "none");
        
        String   result = "PetriGraph (start: " + (start == null ? "none" : "assigned") + ", end: " + (end == null ? "end" : "assigned") + ", subgraphs: " + nodesWithSubgraph + ")";
        
        result = result + "\n- Transitions:";
        
        for (PetriTransition t : transitions)
        {
            result = result + "\n    " + t;
        }
        
        result = result + "\n- Places:";
        
        for (PetriPlace p : places)
        {
            result = result + "\n    " + p;
        }
        
        return (result);
    }
}

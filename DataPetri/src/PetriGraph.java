
/**
 *  @project >> Software Engineering 2017
 *  @authors >> Emil S. Bak, Philip Falck
 *  @contact >> 
 *  @version >> 1.1.0
 *  @updated >> 09/03-2017
 *  @licence >> MIT
 *  @sources >> 
 */

import java.util.ArrayList;
import java.awt.Point;

/**
 *  This is the petri graph base data structure. It extends from the super class
 *  Graph. It holds all of the information that a petri graph needs, and all the
 *  constructors that the user interface group needs to create, and populate the
 *  structure. This  includes transitions, places and indicators for start & end
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
     *  This tries to retrieve a place, and if it has been assigned it will then
     *  return it. However in the case that it hasn't been set and someone tries
     *  to get it, it will throw an exception as that is an illegal graph action
     */
    public PetriPlace getStart ()
    {
        if (start == null)
        {
            throw new NullPointerException();
        }
        else
        {
            return (start);
        }
    }
    
    /**
     *  This tries to retrieve a place, and if it has been assigned it will then
     *  return it. However in the case that it hasn't been set and someone tries
     *  to get it, it will throw an exception as that is an illegal graph action
     */
    public PetriPlace getEnd ()
    {
        if (end == null)
        {
            throw new NullPointerException();
        }
        else
        {
            return (end);
        }
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
        String   result = "PetriGraph (start: " + (start == null ? "none" : "assigned") + ", end: " + (end == null ? "end" : "assigned") + ")";
        
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

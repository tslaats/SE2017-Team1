package gui;

/**
 *  @project >> Software Engineering 2017
 *  @authors >> Philip Falck
 *  @contact >>
 *  @version >> 1.0.1
 *  @updated >> 21/03-2017
 *  @licence >> MIT
 *  @sources >>
 */

import java.util.ArrayList;
import java.awt.Point;

/**
 *  This is one of the types of content inside a condition-response graph object
 *  and it holds everything are needed to both visualize, and simulate the graph
 */
public class ConresEvent
{
    public int                          id              = -1;
    public Point                        position        = null;
    public String                       name            = null;
    public String                       role            = null;
    public boolean                      isExecuted      = false;
    public boolean                      isPending       = false;
    public int                          subgraphID      = -1;

    /*
     *  This is the default constructor, used to create a new activity. It takes
     *  everything that it needs to operate, like the unique integer id, and the
     *  name and role identifiers as entered by the user. Note that it currently
     *  does not set the isExecuted and isPending flags when creating the object
     */
    public ConresEvent (int id, Point position, String name, String role)
    {
        this.id         = id;
        this.position   = position;
        this.name       = name;
        this.role       = role;
    }

    /**
     * This is a debugging method, for printing out a textual representation of
     * the node. It actually doesn't print, it's just a toString, sorry, my bad
     * but yeah, so I wonder, does anyone even reads these comments I guess not
     */
    public String toString()
    {
        return ("Event (id: " + id + ", name: " + name + ", role: " + role + ", isExecuted: " + (isExecuted ? "t" : "f") + ", isPending: " + (isPending ? "t" : "f") + ", Point: " + position.x + "," + position.y + ")");
    }

    /**
     * Returns boolean stating whether or not the event/activity has a subgraph
     */
    public boolean hasSubgraph()
    {
		return (subgraphID != -1);
	}
}

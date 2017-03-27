package utils;
import java.awt.*;

import java.util.*;

import resources.Constants;
import structure.Activity;
import structure.Relation;

/*
 * All methods concerned with the drawing of relations. 
 */
public class RelationDrawingFactory {
	
	/**
     * draw dot centered at center
     * @param center: the center of the dot to be drawn.
     */
    private void drawDot(Graphics2D g2d, Point center) {
      g2d.fillOval(center.x - Constants.DOT_SIZE / 2, center.y - Constants.DOT_SIZE /2, Constants.DOT_SIZE, Constants.DOT_SIZE);
    }
    
    /**
     * draw triangle with point at <point> and direction <dir>.
     * @param point: the point of the triangle.
     * @param dir: the way the triangle should "point" ("R" = right>, "L" = left<, "U" = up^, "D" = down\/)
     */
    private void drawTriangle(Graphics2D g2d, Point point, String dir) {
      Point p1 = point;
      Point p2 = new Point(point.x - Constants.TRIANGLE_HEIGHT, point.y - Constants.TRIANGLE_HEIGHT);
      Point p3 = new Point(point.x - Constants.TRIANGLE_HEIGHT, point.y + Constants.TRIANGLE_HEIGHT);
      //draw differently depending on direction of the arrow.
      if(dir == "R") {
        p1 = point;
        p2 = new Point(point.x - Constants.TRIANGLE_HEIGHT, point.y - Constants.TRIANGLE_HEIGHT/2);
        p3 = new Point(point.x - Constants.TRIANGLE_HEIGHT, point.y + Constants.TRIANGLE_HEIGHT/2);
      }else if(dir == "L") {
        p1 = point;
        p2 = new Point(point.x + Constants.TRIANGLE_HEIGHT, point.y - Constants.TRIANGLE_HEIGHT/2);
        p3 = new Point(point.x + Constants.TRIANGLE_HEIGHT, point.y + Constants.TRIANGLE_HEIGHT/2);
      }else if(dir == "U") {
        p1 = point;
        p2 = new Point(point.x + Constants.TRIANGLE_HEIGHT/2, point.y + Constants.TRIANGLE_HEIGHT);
        p3 = new Point(point.x - Constants.TRIANGLE_HEIGHT/2, point.y + Constants.TRIANGLE_HEIGHT);
      }else if(dir == "D") {
        p1 = point;
        p2 = new Point(point.x + Constants.TRIANGLE_HEIGHT/2, point.y - Constants.TRIANGLE_HEIGHT);
        p3 = new Point(point.x - Constants.TRIANGLE_HEIGHT/2, point.y - Constants.TRIANGLE_HEIGHT);
      }else{
        System.out.println("drawTriangle: INVALID DIR given");
      }
      int[] xs = {p1.x, p2.x, p3.x};
      int[] ys = {p1.y, p2.y, p3.y};
      g2d.fillPolygon(xs, ys, 3);
    }
    
    /**
     * draw condition relation arrow head o<
     * @param point: the point at the end of the head, i.e. the point at the end of the dot, like the dot here:  .o<
     */
    private void drawConditionHead(Graphics2D g2d, Point point, String dir) {
      if(dir == "R") {
        drawDot(g2d, new Point(point.x - Constants.DOT_SIZE/2, point.y));
        drawTriangle(g2d, new Point(point.x - Constants.DOT_SIZE, point.y), dir);
      }else if(dir == "L") {
        drawDot(g2d, new Point(point.x + Constants.DOT_SIZE/2, point.y));
        drawTriangle(g2d, new Point(point.x + Constants.DOT_SIZE, point.y), dir);
      }else if(dir == "U") {
        drawDot(g2d, new Point(point.x, point.y + Constants.DOT_SIZE/2));
        drawTriangle(g2d, new Point(point.x, point.y + Constants.DOT_SIZE), dir);
      }else if(dir == "D") {
        drawDot(g2d, new Point(point.x, point.y - Constants.DOT_SIZE/2));
        drawTriangle(g2d, new Point(point.x, point.y - Constants.DOT_SIZE), dir);
      }else{
        System.out.println("drawConditionHead: INVALID DIR given");
      }
    }
    
    /**
     * draw Response relation tail, i.e. draw the dot that is at the start of response relation
     * @param point: the start point of the relation arrow to which the tail belongs.
     */
    private void drawResponseTail(Graphics2D g2d, Point point, String dir) {
      if(dir == "R") {
        drawDot(g2d, new Point(point.x + Constants.DOT_SIZE/2, point.y));
      }else if(dir == "L") {
        drawDot(g2d, new Point(point.x - Constants.DOT_SIZE/2, point.y));
      }else if(dir == "U") {
        drawDot(g2d, new Point(point.x, point.y - Constants.DOT_SIZE/2));
      }else if(dir == "D") {
        drawDot(g2d, new Point(point.x, point.y + Constants.DOT_SIZE/2));
      }else{
        System.out.println("drawConditionHead: INVALID DIR given");
      }
    }
    
    /**
     * Draw a line between two points.
     * The line goes straight vertically or horizontally coming out of and entering its start and end points
     * but then connects directly from there.
     * @param start, end: the two points to be connected
     * @param dir: which surface of the activity does the line emerge from
     */
    private void drawVaguelyZigZaggyLine(Graphics2D g2d, Point start, Point end, String dir) {
      Point p1 = start;
      Point p2 = new Point(0,0);
      Point p3 = new Point(0,0);
      Point p4 = end;
      if(dir == "R") {
        p2 = new Point(start.x + Constants.ACTIVITY_PADDING, start.y);
        p3 = new Point(end.x - Constants.ACTIVITY_PADDING, end.y);
      }else if(dir == "L") {
        p2 = new Point(start.x - Constants.ACTIVITY_PADDING, start.y);
        p3 = new Point(end.x + Constants.ACTIVITY_PADDING, end.y);
      }else if(dir == "U") {
        p2 = new Point(start.x, start.y - Constants.ACTIVITY_PADDING);
        p3 = new Point(end.x, end.y + Constants.ACTIVITY_PADDING);
      }else if(dir == "D") {
        p2 = new Point(start.x, start.y + Constants.ACTIVITY_PADDING);
        p3 = new Point(end.x, end.y - Constants.ACTIVITY_PADDING);
      }else{
        System.out.println("drawLineBetweenActivities: INVALID DIR given");
      }
      int[] xs = {p1.x, p2.x, p3.x, p4.x};
      int[] ys = {p1.y, p2.y, p3.y, p4.y};
      g2d.drawPolyline(xs, ys, 4);
    }
    /**
     * Draw a line between two points.
     * The line goes straight vertically or horizontally coming out of and entering its start and end points
     * but then connects directly from there.
     * @param start: the starting point of the relation
     * @param dir: which surface of the activity does the line emerge from
     */
    private void drawSelfLine(Graphics2D g2d, Point start, String dir) {
      Point p1 = start;
      Point p2 = new Point(0,0);
      Point p3 = new Point(0,0);
      Point p4 = new Point(0,0);
      if(dir == "R") {
        p2 = new Point(start.x + Constants.ACTIVITY_PADDING, start.y);
        p3 = new Point(start.x + Constants.ACTIVITY_PADDING, start.y + Constants.ACTIVITY_HEIGHT/2);
        p4 = new Point(start.x, start.y + Constants.ACTIVITY_HEIGHT/2);
      }else if(dir == "L") {
        p2 = new Point(start.x - Constants.ACTIVITY_PADDING, start.y);
        p3 = new Point(start.x - Constants.ACTIVITY_PADDING, start.y - Constants.ACTIVITY_HEIGHT/2);
        p4 = new Point(start.x, start.y - Constants.ACTIVITY_HEIGHT/2);
      }else if(dir == "U") {
        p2 = new Point(start.x, start.y - Constants.ACTIVITY_PADDING);
        p3 = new Point(start.x + Constants.ACTIVITY_WIDTH/2, start.y - Constants.ACTIVITY_PADDING);
        p4 = new Point(start.x + Constants.ACTIVITY_WIDTH/2, start.y);
      }else if(dir == "D") {
        p2 = new Point(start.x, start.y + Constants.ACTIVITY_PADDING);
        p3 = new Point(start.x - Constants.ACTIVITY_WIDTH/2, start.y + Constants.ACTIVITY_PADDING);
        p4 = new Point(start.x - Constants.ACTIVITY_WIDTH/2, start.y);
      }else{
        System.out.println("drawLineBetweenActivities: INVALID DIR given");
      }
      int[] xs = {p1.x, p2.x, p3.x, p4.x};
      int[] ys = {p1.y, p2.y, p3.y, p4.y};
      g2d.drawPolyline(xs, ys, 4);
    }
    /**
     * Get the orientation of the relation arrow head of a relation that has the same activity as both child and parent
     * @param rel, the relation in  q u e s t i o n 
     * @return: the direction of the arrow head, i.e. the way it should point, ("R" = right, "L" = left, "U" = up, "D" = down)
     */
    private String getSelfRelationDirection(Relation rel) {
      Activity act = rel.getChild();
      String dir = "";

      if(rel.getOut().x > act.getCenter().x && rel.getOut().y < act.getCenter().y) {
        dir = "R";
      }else if(rel.getOut().x < act.getCenter().x && rel.getOut().y > act.getCenter().y){ 
        dir = "L";
      }else if(rel.getOut().x < act.getCenter().x && rel.getOut().y < act.getCenter().y){ 
        dir = "U";
      }else if(rel.getOut().x >= act.getCenter().x && rel.getOut().y > act.getCenter().y){ 
        dir = "D";
      }
      return dir;
    }
    /**
     * Get the orientation of the relation arrow head of a relation connecting 2 activities
     * @param act1, act2 the two activities to be connected.
     * @return: the direction of the arrow head, i.e. the way it should point, ("R" = right, "L" = left, "U" = up, "D" = down)
     */
    private String getRelationDirection(Activity act1, Activity act2) {
      Point p1 = act1.getCenter();
      Point p2 = act2.getCenter();
      String dir = "";

      int xDiff = Math.abs(p2.x - p1.x);
      int yDiff = Math.abs(p2.y - p1.y);

      if(xDiff > yDiff) {
        if(p1.x < p2.x) {
          dir = "R";
        }else{
          dir = "L";
        }
      }else{ 
        if(p1.y < p2.y) {
          dir = "D";
        }else{
          dir = "U";
        }
      }
      return dir;
    }
    
    /**
     * Get distance between two activities
     * @param act1, act2: the two relations whose distance should be measured
     */
    protected static double getDistance(Activity act1, Activity act2) {
    	int dx = (act1.getCenter().x-act2.getCenter().x);
    	int dy = (act1.getCenter().y-act2.getCenter().y);
    	double distance = Math.sqrt((dx*dx + dy*dy));
    	
    	return distance;
    }
    
    /**
     * Draw condition relation arrow
     * @param rel: the relation to be drawn.
     */
    public void drawConditionRelation(Graphics2D g2d, Relation rel) {
	  Point p1 = rel.getOut();
	  Point p2 = rel.getIn();
	  String dir = getRelationDirection(rel.getParent(), rel.getChild());
	
	  g2d.setColor(Constants.CONDITION_RELATION_COLOR);
	  drawVaguelyZigZaggyLine(g2d, p1, p2, dir);
	  drawConditionHead(g2d, p2, dir);
    }
    
    /**
     * Draw response relation arrow.
     * @param rel: the relation to be drawn.
     */
    public void drawResponseRelation(Graphics2D g2d, Relation rel) {
      Point p1 = rel.getOut();
      Point p2 = rel.getIn();
      String dir = getRelationDirection(rel.getParent(), rel.getChild());

      g2d.setColor(Constants.RESPONSE_RELATION_COLOR);
      
      if(rel.getChild().equals(rel.getParent())) {
        dir = getSelfRelationDirection(rel);
        drawResponseTail(g2d, p1, dir);
        drawSelfLine(g2d, p1, dir);
        Point selfEnd = new Point();
        if(dir == "L") {
          dir = "R";
          selfEnd = new Point(p1.x, p1.y - Constants.ACTIVITY_HEIGHT/2);
        }else if(dir == "R") {
          dir = "L";
          selfEnd = new Point(p1.x, p1.y + Constants.ACTIVITY_HEIGHT/2);
        }else if(dir == "D") {
          dir = "U";
          selfEnd = new Point(p1.x - Constants.ACTIVITY_WIDTH/2, p1.y);
        }else if(dir == "U") {
          dir = "D";
          selfEnd = new Point(p1.x + Constants.ACTIVITY_WIDTH/2, p1.y);
        }
        drawTriangle(g2d, selfEnd, dir);
      }else{
        drawResponseTail(g2d, p1, dir);
        drawVaguelyZigZaggyLine(g2d, p1, p2, dir);
        drawTriangle(g2d, p2, dir);
      }
      
    }
    
   /**
   * Get the "best"/most logical surface to emerge from when connecting two relations.
   * If the horizontal distance b/t 2 activities is greater than the vertical, a right("R")/left("L")
   * surface pair is chosen, if the vertical is greater, a top("U")/bottom("U") surface pair is chosen.
   * @param act1, act2: the activities to be connected
   * @return: the surface of the first activity (the other surface of the pair can be deduced from this) 
   */
  private String getOutSurface(Activity act1, Activity act2) {
    Point p1 = act1.getCenter();
    Point p2 = act2.getCenter();
    String outSurface = "null";

    int xDiff = Math.abs(p2.x - p1.x);
    int yDiff = Math.abs(p2.y - p1.y);

    if(xDiff > yDiff) { // we draw between the vertical surfaces of the activities
      if(p1.x < p2.x) {//act1 is LEFT of act2
        outSurface = "R";
      }else{
        outSurface = "L";
      }
    }else{              // we draw between the horizontal surfaces of the activities
      if(p1.y < p2.y) {//act1 is ABOVE of act2
        outSurface = "D";
      }else{
        outSurface = "U";
      }
    }
    return outSurface;
  }
  
  /**
   * arrange and set the start coordinates of all outgoing relations of an activity.
   * @param act: the activity whose outgoing relations should be arranged
   * @param allRelations: the set of all relations in the graph
   * @return: the set of all the relations that were changed, i.e. all relations going out from the activity
   */
  public Set<Relation> setOutRelations(Activity act, Set<Relation> allRelations) {
    Set<Relation> returnRelations = new HashSet<Relation>();
    ArrayList<Relation> topRels = new ArrayList<Relation>();
    ArrayList<Relation> bottomRels = new ArrayList<Relation>();
    ArrayList<Relation> leftRels = new ArrayList<Relation>();
    ArrayList<Relation> rightRels = new ArrayList<Relation>();
    Relation selfRel = new Relation(act, act, "resp");
    boolean selfRelation = false;
    //divide the outgoing relations into 4 different surfaces
    for(Relation rel : allRelations) {
      if(act.equals(rel.getParent())) {
        //the relation has end point at the current relation also
        if(act.equals(rel.getChild())) {
          selfRelation = true;
          selfRel = rel;
        }else{
          //the current relation is outgoing from our activity
          if(getOutSurface(rel.getParent(), rel.getChild()) == "R") {
            rightRels.add(rel);
          }else if(getOutSurface(rel.getParent(), rel.getChild()) == "L") {
            leftRels.add(rel);
          }else if(getOutSurface(rel.getParent(), rel.getChild()) == "U") {
            topRels.add(rel);
          }else if(getOutSurface(rel.getParent(), rel.getChild()) == "D") {
            bottomRels.add(rel);
          }
        } 
      }
    }

    String leastBusySurface = "Q";
    if(selfRelation) {
      int minSurface = Math.min(Math.min(Math.min(rightRels.size(), leftRels.size()), topRels.size()), bottomRels.size());
      if(minSurface == rightRels.size()) {
        leastBusySurface = "R";
        selfRel.setOut(new Point(act.getCenter().x + Constants.ACTIVITY_WIDTH/2, act.getCenter().y - Constants.TRIANGLE_HEIGHT/2));
        System.out.println("hej" + selfRel.getOut());
      }else if(minSurface == leftRels.size()) {
        leastBusySurface = "L";
        selfRel.setOut(new Point(act.getCenter().x - Constants.ACTIVITY_WIDTH/2, act.getCenter().y + Constants.ACTIVITY_HEIGHT/2 - Constants.TRIANGLE_HEIGHT/2));
      }else if(minSurface == topRels.size()) {
        leastBusySurface = "T";
        selfRel.setOut(new Point(act.getCenter().x - Constants.TRIANGLE_HEIGHT/2, act.getCenter().y - Constants.ACTIVITY_HEIGHT/2));
      }else if(minSurface == bottomRels.size()) {
        leastBusySurface = "B";
        selfRel.setOut(new Point(act.getCenter().x + Constants.ACTIVITY_WIDTH/2 - Constants.TRIANGLE_HEIGHT/2, act.getCenter().y + Constants.ACTIVITY_HEIGHT/2));
      }
      returnRelations.add(selfRel);
    }

    int i,numberOutgoing,surfaceLength,spacing;
    int offset = 0;
    //relations emerging from the right surface
    if(rightRels.size() > 0) {
      i = 0;
      numberOutgoing = rightRels.size();
      surfaceLength = Constants.ACTIVITY_HEIGHT / 2;
      spacing = surfaceLength / numberOutgoing;
      if(leastBusySurface == "R") {
      
      }
      rightRels = sortByChildY(rightRels);
      for(Relation rel : rightRels) {
        Point start = new Point(act.getCenter().x + Constants.ACTIVITY_WIDTH/2, act.getCenter().y - Constants.ACTIVITY_HEIGHT/2 + Constants.TRIANGLE_HEIGHT/2 + i*spacing + offset);
        rel.setOut(start);
        returnRelations.add(rel);
        i++;
      }
    }
    //relations emerging from the left surface
    if(leftRels.size() > 0) {
      i = 0;
      offset = 0;
      numberOutgoing = leftRels.size();
      surfaceLength = Constants.ACTIVITY_HEIGHT / 2;
      spacing = surfaceLength / numberOutgoing;
      if(leastBusySurface == "L") {
        //offset = Constants.ACTIVITY_PADDING + spacing;
      }
      leftRels = sortByChildY(leftRels);
      for(Relation rel : leftRels) {
        Point start = new Point(act.getCenter().x - Constants.ACTIVITY_WIDTH/2, act.getCenter().y + Constants.TRIANGLE_HEIGHT/2 + i*spacing);
        rel.setOut(start);
        returnRelations.add(rel);
        i++;
      }
    }
    //relations emerging from the top surface
    if(topRels.size() > 0) {
      i = 0;
      offset = 0;
      numberOutgoing = topRels.size();
      surfaceLength = Constants.ACTIVITY_WIDTH / 2;
      spacing = surfaceLength / numberOutgoing;
      if(leastBusySurface == "T") {
        //offset = Constants.ACTIVITY_PADDING + spacing;
      }
      topRels = sortByChildX(topRels);
      for(Relation rel : topRels) {
        Point start = new Point(act.getCenter().x - Constants.ACTIVITY_WIDTH/2 + Constants.TRIANGLE_HEIGHT/2 + i*spacing + offset, act.getCenter().y - Constants.ACTIVITY_HEIGHT/2);
        rel.setOut(start);
        returnRelations.add(rel);
        i++;
      }
    }
    //relations emerging from the bottom surface
    if(bottomRels.size() > 0) {
      i = 0;
      offset = 0;
      numberOutgoing = bottomRels.size();
      surfaceLength = Constants.ACTIVITY_WIDTH / 2;
      spacing = surfaceLength / numberOutgoing;
      if(leastBusySurface == "B") {
        //offset = Constants.ACTIVITY_PADDING + spacing;
      }
      bottomRels = sortByChildX(bottomRels);
      for(Relation rel : bottomRels) {
        Point start = new Point(act.getCenter().x + Constants.TRIANGLE_HEIGHT/2 + i*spacing + offset, act.getCenter().y + Constants.ACTIVITY_HEIGHT/2);
        rel.setOut(start);
        returnRelations.add(rel);
        i++;
      }
    }
    return returnRelations;
  }
  
  /**
   * arrange and set the end coordinates of all incoming relations of an activity.
   * @param act: the activity whose incoming relations should be arranged
   * @param allRelations: the set of all relations in the graph
   * @return: the set of all the relations that were changed, i.e. all relations going in to the activity
   */
  public Set<Relation> setInRelations(Activity act, Set<Relation> allRelations) {
    Set<Relation> returnRelations = new HashSet<Relation>();
    ArrayList<Relation> topRels = new ArrayList<Relation>();
    ArrayList<Relation> bottomRels = new ArrayList<Relation>();
    ArrayList<Relation> leftRels = new ArrayList<Relation>();
    ArrayList<Relation> rightRels = new ArrayList<Relation>();
    //divide the outgoing relations into 4 different surfaces
    for(Relation rel : allRelations) {
      if(act.equals(rel.getChild())) {
        //the current relation is outgoing from our activity
        if(getOutSurface(rel.getParent(), rel.getChild()) == "R") {
          leftRels.add(rel);
        }else if(getOutSurface(rel.getParent(), rel.getChild()) == "L") {
          rightRels.add(rel);
        }else if(getOutSurface(rel.getParent(), rel.getChild()) == "U") {
          bottomRels.add(rel);
        }else if(getOutSurface(rel.getParent(), rel.getChild()) == "D") {
          topRels.add(rel);
        } 
      }
    }
    int i,numberOutgoing,surfaceLength,spacing;
    //relations ending in the right surface
    if(rightRels.size() > 0) {
      i = 0;
      numberOutgoing = rightRels.size();
      surfaceLength = Constants.ACTIVITY_HEIGHT / 2;
      spacing = surfaceLength / numberOutgoing;

      rightRels = sortByChildY(rightRels);
      for(Relation rel : rightRels) {
        Point end = new Point(act.getCenter().x + Constants.ACTIVITY_WIDTH/2, act.getCenter().y + Constants.TRIANGLE_HEIGHT/2 + i*spacing);
        rel.setIn(end);
        returnRelations.add(rel);
        i++;
      }
    }
    //relations ending in the left surface
    if(leftRels.size() > 0) {
      i = 0;
      numberOutgoing = leftRels.size();
      surfaceLength = Constants.ACTIVITY_HEIGHT / 2;
      spacing = surfaceLength / numberOutgoing;

      leftRels = sortByChildY(leftRels);
      for(Relation rel : leftRels) {
        Point end = new Point(act.getCenter().x - Constants.ACTIVITY_WIDTH/2, act.getCenter().y - Constants.ACTIVITY_HEIGHT/2 + Constants.TRIANGLE_HEIGHT/2 + i*spacing);
        rel.setIn(end);
        returnRelations.add(rel);
        i++;
      }
    }
    //relations ending in the top surface
    if(topRels.size() > 0) {
      i = 0;
      numberOutgoing = topRels.size();
      surfaceLength = Constants.ACTIVITY_WIDTH / 2;
      spacing = surfaceLength / numberOutgoing;

      topRels = sortByChildX(topRels);
      for(Relation rel : topRels) {
        Point end = new Point(act.getCenter().x + Constants.TRIANGLE_HEIGHT/2 + i*spacing, act.getCenter().y - Constants.ACTIVITY_HEIGHT/2);
        rel.setIn(end);
        returnRelations.add(rel);
        i++;
      }
    }
    //relations ending in the bottom surface
    if(bottomRels.size() > 0) {
      i = 0;
      numberOutgoing = bottomRels.size();
      surfaceLength = Constants.ACTIVITY_WIDTH / 2;
      spacing = surfaceLength / numberOutgoing;

      bottomRels = sortByChildX(bottomRels);
      for(Relation rel : bottomRels) {
        Point end = new Point(act.getCenter().x - Constants.ACTIVITY_WIDTH/2 + Constants.TRIANGLE_HEIGHT/2 + i*spacing, act.getCenter().y + Constants.ACTIVITY_HEIGHT/2);
        rel.setIn(end);
        returnRelations.add(rel);
        i++;
      }
    }

    return returnRelations;
  }
  
  /**
   * sort arrayList of relations by its child activity's y coordinate
   * @param relations: The list of relations to be sorted
   * @return: the list of relations, sorted by the child activity y coord.
   */
  private static ArrayList<Relation> sortByChildY(ArrayList<Relation> numbers) {
      boolean swapped = true;
      for(int i = numbers.size() - 1; i > 0 && swapped; i--) {
          swapped = false;
          for (int j = 0; j < i; j++) {
              if (numbers.get(j).getChild().getCenter().y > numbers.get(j+1).getChild().getCenter().y) {
                  Relation temp = numbers.get(j);
                  numbers.set(j, numbers.get(j+1));
                  numbers.set(j+1, temp);
                  swapped = true;
              }
          }
      }
      return numbers;
  }
  
  /**
   * sort arrayList of relations by its child activity's x coordinate
   * @param relations: The list of relations to be sorted
   * @return: the list of relations, sorted by the child activity x coord.
   */
  private static ArrayList<Relation> sortByChildX(ArrayList<Relation> numbers) {
      boolean swapped = true;
      for(int i = numbers.size() - 1; i > 0 && swapped; i--) {
          swapped = false;
          for (int j = 0; j < i; j++) {
              if (numbers.get(j).getChild().getCenter().x > numbers.get(j+1).getChild().getCenter().x) {
                  Relation temp = numbers.get(j);
                  numbers.set(j, numbers.get(j+1));
                  numbers.set(j+1, temp);
                  swapped = true;
              }
          }
      }
      return numbers;
  }
}
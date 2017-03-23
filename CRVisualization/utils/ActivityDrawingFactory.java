package utils;
import java.awt.*;

import resources.Constants;
import structure.Activity;

/*
 * All methods concerned with the drawing of activities.
 */
public class ActivityDrawingFactory {
	
    /**
     * Draw check mark in activity
     * @param g2d - the graphics object to draw
     * @param x - the x coordinate as integer of the lower left corner of the check mark.
     * @param y - the y coordinate as integer of the lower left corner of the check mark.
     **/
    private void drawCheckMark(Graphics2D g2d, int x, int y){
      g2d.setFont(Constants.CHECKMARK_FONT);
      g2d.setColor(Constants.CHECKMARK_COLOR);
      g2d.drawString(Constants.CHECKMARK_SYMB, x, y);
      g2d.setFont(Constants.BASIC_FONT);
      g2d.setColor(Color.BLACK);
    }
    
    /**
     * Draw exclamation in activity
     * @param g2d - the graphics object to draw
     * @param x - the x coordinate as integer of the lower left corner of the exclamation.
     * @param y - the y coordinate as integer of the lower left corner of the exclamation.
     **/
    private void drawExclamation(Graphics2D g2d, int x, int y){
      g2d.setColor(Constants.EXCLAMATION_COLOR);
      g2d.setFont(Constants.EXCLAMATION_FONT);
      g2d.drawString(Constants.EXCLAMATION_SYMB, x, y);
      g2d.setFont(Constants.BASIC_FONT);
      g2d.setColor(Color.BLACK);
    }
    
    /**
     * Draw activity header bar
     * @param g2d - the graphics object to draw
     * @param text - the text to write in the header as String
     * @param x - the x coordinate as integer of the lower left corner of the text.
     * @param y - the y coordinate as integer of the lower left corner of the text.
     **/
    private void drawHeader(Graphics2D g2d, String text, int x , int y){
      // center header
      FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
      x = x + (Constants.ACTIVITY_WIDTH - metrics.stringWidth(text)) / 2;
      y = y + ((Constants.HEADER_HEIGHT - metrics.getHeight()) / 2) + metrics.getAscent();
      //draw header
      g2d.drawString(text, x, y);
    }
    
    /**
     * Draw activity body
     * @param g2d - the graphics object to draw.
     * @param text - the text to write in the body as String.
     * @param x - the x coordinate as integer of the top left corner of the activity.
     * @param y - the y coordinate as integer of the top left corner of the activity.
     **/
    private void drawBody(Graphics2D g2d, String text, int x, int y){
      String toDraw = "";
      while(text.length() > Constants.LINE_LENGTH){
        toDraw = toDraw.concat(text.substring(0, Constants.LINE_LENGTH) + "\n");
        text = text.substring(Constants.LINE_LENGTH);
      }
      toDraw = toDraw.concat(text);
      // positioning
      FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
      y = y + Constants.LINE_HEIGHT + Constants.HEADER_HEIGHT + 9;
      for (String line : toDraw.split("\n")){
          int tempX = x + (Constants.ACTIVITY_WIDTH - metrics.stringWidth(line)) / 2;
          //draw each line
          g2d.drawString(line, tempX, y += g2d.getFontMetrics().getHeight());
      }
    }
    
    /**
     * Draw activity body
     * @param g2d - the graphics object to draw.
     * @param x - the x coordinate as integer of the top left corner of the box.
     * @param y - the y coordinate as integer of the top left corner of the box.
     * @param width - the width of the box as integer.
     * @param height - the height of the box as integer.
     **/
    private void addPetri(Graphics g2d, int x, int y, int width, int height){
      g2d.drawRect(x, y, width, height);
    }
    
    /**
     * DrawActivity helper function. Draws outline which is included in any type of activity.
     * @param g2d - the graphics object to draw.
     * @param upperLeftX - the x coordinate as integer of the top left corner of the activity.
     * @param upperLeftY - the y coordinate as integer of the top left corner of the activity.
     * @param lowerRigthX -  the x coordinate as integer of the lower left corner of the activity
     **/
    private void drawActivityOutline(Graphics2D g2d, int upperLeftX, int upperLeftY, int lowerRightX){
      g2d.setColor(Constants.ACTIVITY_BACKGROUND_COLOR);
      g2d.fillRect(upperLeftX, upperLeftY, Constants.ACTIVITY_WIDTH, Constants.ACTIVITY_HEIGHT);
      g2d.setColor(Color.BLACK);
      g2d.drawRect(upperLeftX, upperLeftY, Constants.ACTIVITY_WIDTH, Constants.ACTIVITY_HEIGHT);
      g2d.drawLine(upperLeftX, upperLeftY + Constants.HEADER_HEIGHT, lowerRightX, upperLeftY + Constants.HEADER_HEIGHT);
      g2d.setFont(Constants.BASIC_FONT);
    }

    /**
     * Draw an activity with center at <center>
     * @param g2d - the graphics object to draw.
     * @param activity - the activity object to draw**/
    public void drawActivity(Graphics2D g2d, Activity activity) {
        Point center = activity.getCenter();
        int upperLeftX = center.x - Constants.ACTIVITY_WIDTH / 2;
        int upperLeftY = center.y - Constants.ACTIVITY_HEIGHT / 2;
        int lowerRightX = center.x + Constants.ACTIVITY_WIDTH /2;

        drawActivityOutline(g2d, upperLeftX, upperLeftY, lowerRightX);
        drawHeader(g2d, activity.getTitle(), upperLeftX, upperLeftY);
        drawBody(g2d, activity.getBody(), upperLeftX, upperLeftY);

        if(activity.getExecuted()){
            drawCheckMark(g2d, upperLeftX + Constants.PETRI_MARGIN, upperLeftY + Constants.HEADER_HEIGHT + 20);
        }

        if(activity.getPending()){
            drawExclamation(g2d, lowerRightX - Constants.PETRI_MARGIN - 10, upperLeftY + Constants.HEADER_HEIGHT + 20);
        }

        if(activity.containsPetri()){
            addPetri(g2d, upperLeftX + Constants.PETRI_MARGIN, upperLeftY + Constants.PETRI_MARGIN + Constants.HEADER_HEIGHT,
            Constants.ACTIVITY_WIDTH - 2*Constants.PETRI_MARGIN, Constants.ACTIVITY_HEIGHT - Constants.HEADER_HEIGHT - 2*Constants.PETRI_MARGIN);  
        }
    }

}
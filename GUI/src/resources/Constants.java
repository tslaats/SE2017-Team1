package resources;
import java.awt.Color;
import java.awt.Font;

public final class Constants {
  public static final int DOT_SIZE = 8;
  public static final int TRIANGLE_HEIGHT = 8;
  public static final int EVENT_WIDTH = 100;
  public static final int EVENT_HEIGHT = 130;
  public static final int HEADER_HEIGHT = 30;
  public static final int EVENT_PADDING = 32;
  public static final int LINE_LENGTH = 14;
  public static final int LINE_HEIGHT = 12;
  public static final int PETRI_MARGIN = 2;
  public static final Color CHECKMARK_COLOR = new Color(0,128,0);
  public static final Color EXCLAMATION_COLOR = new Color(255,0,0);
  public static final Color CONDITION_RELATION_COLOR = new Color(255,69,0);
  public static final Color RESPONSE_RELATION_COLOR = new Color(0,0,255);
  public static final Color EVENT_BACKGROUND_COLOR = Color.white;
  public static final String CHECKMARK_SYMB = "\u2714";
  public static final String EXCLAMATION_SYMB = "\u2757";
  public static final Font BASIC_FONT = new Font("Verdana", Font.PLAIN, Constants.LINE_HEIGHT);
  public static final Font CHECKMARK_FONT = new Font("LucidaSans", Font.PLAIN, Constants.LINE_HEIGHT + 12);
  public static final Font EXCLAMATION_FONT = new Font("ComicSans", Font.PLAIN, Constants.LINE_HEIGHT + 12);
}
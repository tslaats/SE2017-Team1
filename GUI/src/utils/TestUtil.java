package utils;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import resources.Constants;

public class TestUtil {
	
	public static int getLeftX(Point p) {
		return p.x - Constants.EVENT_WIDTH / 2;
	}
	  
	public static int getRightX(Point p) {
		return p.x + Constants.EVENT_WIDTH / 2;
	}
	  
	public static int getUpperY(Point p) {
		return p.y - Constants.EVENT_HEIGHT / 2;
	}
	  
	public static void drawAct(Graphics2D g2d, Point center, String title, String bodyText,
			boolean isExec, boolean isPend, boolean isPetri) {
		
		int leftX = center.x - Constants.EVENT_WIDTH / 2;
		int rightX = center.x + Constants.EVENT_WIDTH /2;
		int upperY = center.y - Constants.EVENT_HEIGHT / 2;
		int lineY = upperY + Constants.HEADER_HEIGHT;
		
	    // border
		g2d.setColor(Constants.EVENT_BACKGROUND_COLOR);
		g2d.fillRect(leftX, upperY, Constants.EVENT_WIDTH, Constants.EVENT_HEIGHT);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(leftX, upperY, Constants.EVENT_WIDTH, Constants.EVENT_HEIGHT);
		g2d.drawLine(leftX, lineY, rightX, lineY);
		
		// font
		g2d.setFont(Constants.BASIC_FONT);
		FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
		
		// title
	    int xTitle = leftX + (Constants.EVENT_WIDTH - metrics.stringWidth(title)) / 2;
	    int yTitle = upperY + ((Constants.HEADER_HEIGHT - metrics.getHeight()) / 2) + metrics.getAscent();
	    g2d.drawString(title, xTitle, yTitle);
		  
	    // body text
	    int xBody = leftX + (Constants.EVENT_WIDTH - metrics.stringWidth(bodyText)) / 2;
	    int yBody = upperY + Constants.LINE_HEIGHT + Constants.HEADER_HEIGHT + 9 + g2d.getFontMetrics().getHeight();
	    g2d.drawString(bodyText, xBody, yBody);
	    
	    // checkmark
	    if (isExec) {
	    	g2d.setFont(Constants.CHECKMARK_FONT);
		    g2d.setColor(Constants.CHECKMARK_COLOR);
		    int xCheck = leftX + Constants.PETRI_MARGIN;
		    int yCheck = upperY + Constants.HEADER_HEIGHT + 20;
		    g2d.drawString(Constants.CHECKMARK_SYMB, xCheck, yCheck);
	    }
	    
	    // exclamation mark
	    if (isPend) {
	    	g2d.setFont(Constants.EXCLAMATION_FONT);
		    g2d.setColor(Constants.EXCLAMATION_COLOR);
		    int xExclam = rightX - Constants.PETRI_MARGIN - 10;
		    int yExclam = upperY + Constants.HEADER_HEIGHT + 20;
		    g2d.drawString(Constants.EXCLAMATION_SYMB, xExclam, yExclam);
	    }
	    
	    // Petri
	    if (isPetri) {
	    	g2d.setColor(Color.BLACK);
		    g2d.setFont(Constants.BASIC_FONT);
		    g2d.drawRect(leftX + Constants.PETRI_MARGIN, lineY + Constants.PETRI_MARGIN,
				Constants.EVENT_WIDTH - 2 * Constants.PETRI_MARGIN, Constants.EVENT_HEIGHT - Constants.HEADER_HEIGHT - 2 * Constants.PETRI_MARGIN);
	    } 
	}
		  
	public static void drawResp(
			Graphics2D g2d,
			int circleRespX, int circleRespY,
			int triangleRespX, int triangleRespY,
			char trianglePos, int addToLineX, int addToLineY) {
			  
		g2d.setColor(Constants.RESPONSE_RELATION_COLOR);
			  
		// circle
		g2d.fillOval(circleRespX - Constants.DOT_SIZE / 2, circleRespY - Constants.DOT_SIZE /2, Constants.DOT_SIZE, Constants.DOT_SIZE);
		
		// triangle
		Point pResp1 = new Point(triangleRespX, triangleRespY);
		int pResp2X = 0;
		int pResp3X = 0;
		int pResp2Y = 0;
		int pResp3Y = 0;
		  
		switch(trianglePos) {
		  	case 'U':
		  		pResp2X = pResp1.x - Constants.TRIANGLE_HEIGHT / 2;
		  		pResp3X = pResp1.x + Constants.TRIANGLE_HEIGHT / 2;
		  		pResp2Y = pResp1.y + Constants.TRIANGLE_HEIGHT;
		  		pResp3Y = pResp1.y + Constants.TRIANGLE_HEIGHT;
		  		break;
		  	case 'D':
		  		pResp2X = pResp1.x - Constants.TRIANGLE_HEIGHT / 2;
		  		pResp3X = pResp1.x + Constants.TRIANGLE_HEIGHT / 2;
		  		pResp2Y = pResp1.y - Constants.TRIANGLE_HEIGHT;
		  		pResp3Y = pResp1.y - Constants.TRIANGLE_HEIGHT;
		  		break;
		  	case 'L':
		  		pResp2X = pResp1.x + Constants.TRIANGLE_HEIGHT;
		  		pResp3X = pResp1.x + Constants.TRIANGLE_HEIGHT;
		  		pResp2Y = pResp1.y - Constants.TRIANGLE_HEIGHT / 2;
		  		pResp3Y = pResp1.y + Constants.TRIANGLE_HEIGHT / 2;
		  		break;
		  	case 'R':
		  		pResp2X = pResp1.x - Constants.TRIANGLE_HEIGHT;
		  		pResp3X = pResp1.x - Constants.TRIANGLE_HEIGHT;
		  		pResp2Y = pResp1.y - Constants.TRIANGLE_HEIGHT / 2;
		  		pResp3Y = pResp1.y + Constants.TRIANGLE_HEIGHT / 2;
		  		break;
		}
		
		Point pResp2 = new Point(pResp2X, pResp2Y);
		Point pResp3 = new Point(pResp3X, pResp3Y);
		int[] xsResp = {pResp1.x, pResp2.x, pResp3.x};
		int[] ysResp = {pResp1.y, pResp2.y, pResp3.y};
		g2d.fillPolygon(xsResp, ysResp, 3);
		  
		// line
		g2d.drawLine(circleRespX + addToLineX, circleRespY + addToLineY, triangleRespX, triangleRespY);
	}
		
	public static void drawCond(
			Graphics2D g2d,
			int circleCondX, int circleCondY,
			int triangleCondX, int triangleCondY,
			int lineCondStartX, int lineCondEndX,
			char trianglePos, int addToLineX, int addToLineY) {
			
		g2d.setColor(Constants.CONDITION_RELATION_COLOR);
		
		// circle
		g2d.fillOval(circleCondX - Constants.DOT_SIZE / 2, circleCondY - Constants.DOT_SIZE /2, Constants.DOT_SIZE, Constants.DOT_SIZE);
		
		// triangle
		Point pCond1 = new Point(triangleCondX, triangleCondY);
		int pResp2X = 0;
		int pResp3X = 0;
		int pResp2Y = 0;
		int pResp3Y = 0;
		
		switch(trianglePos) {
		  	case 'U':
				pResp2X = pCond1.x - Constants.TRIANGLE_HEIGHT / 2;
				pResp3X = pCond1.x + Constants.TRIANGLE_HEIGHT / 2;
				pResp2Y = pCond1.y + Constants.TRIANGLE_HEIGHT;
				pResp3Y = pCond1.y + Constants.TRIANGLE_HEIGHT;
				break;
		  	case 'D':
				pResp2X = pCond1.x - Constants.TRIANGLE_HEIGHT / 2;
				pResp3X = pCond1.x + Constants.TRIANGLE_HEIGHT / 2;
				pResp2Y = pCond1.y - Constants.TRIANGLE_HEIGHT;
				pResp3Y = pCond1.y - Constants.TRIANGLE_HEIGHT;
				break;
			case 'L':
				pResp2X = pCond1.x + Constants.TRIANGLE_HEIGHT;
				pResp3X = pCond1.x + Constants.TRIANGLE_HEIGHT;
				pResp2Y = pCond1.y - Constants.TRIANGLE_HEIGHT / 2;
				pResp3Y = pCond1.y + Constants.TRIANGLE_HEIGHT / 2;
				break;
			case 'R':
		  		pResp2X = pCond1.x - Constants.TRIANGLE_HEIGHT;
		  		pResp3X = pCond1.x - Constants.TRIANGLE_HEIGHT;
		  		pResp2Y = pCond1.y - Constants.TRIANGLE_HEIGHT / 2;
		  		pResp3Y = pCond1.y + Constants.TRIANGLE_HEIGHT / 2;
		  		break;
		}
		  
		Point pCond2 = new Point(pResp2X, pResp2Y);
		Point pCond3 = new Point(pResp3X, pResp3Y);
		int[] xsCond = {pCond1.x, pCond2.x, pCond3.x};
		int[] ysCond = {pCond1.y, pCond2.y, pCond3.y};
		g2d.fillPolygon(xsCond, ysCond, 3);
		
		// line
	    g2d.drawLine(circleCondX + addToLineX, circleCondY + addToLineY, lineCondStartX, lineCondEndX);
	}
	
	public static String getChecksum(String filePath) throws Exception  {
		String datafile = filePath;
	
	    MessageDigest md = MessageDigest.getInstance("SHA1");
	    FileInputStream fis = new FileInputStream(datafile);
	    byte[] dataBytes = new byte[1024];
	
	    int nread = 0;
	
	    while ((nread = fis.read(dataBytes)) != -1) {
	      md.update(dataBytes, 0, nread);
	    }
	    fis.close();
	    
	    byte[] mdbytes = md.digest();
	
	    //convert the byte to hex format
	    StringBuffer sb = new StringBuffer("");
	    for (int i = 0; i < mdbytes.length; i++) {
	    	sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
	    }
	
	    return sb.toString();
	}
	
	  /*
	   * Export to image of <format>
	   */
	  public static void exportToImage(String format, JPanel dPanel, String fileName) {
	    BufferedImage bImg = new BufferedImage(dPanel.getWidth(), dPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
	    Graphics2D cg = bImg.createGraphics();
	    dPanel.paintAll(cg);
	    try {
	            if (ImageIO.write(bImg, "jpg", new File("./" + fileName + "." + format)))
	            {
	                System.out.println("image saved succesfully");
	            }
	    } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	    }
	  }
	  
	public static void drawAndSave(JPanel graphDrawing, String fileName) {
	    JFrame frame = new JFrame("Drawing");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.add(graphDrawing);
	    frame.setSize(500, 500);
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    exportToImage("jpg", graphDrawing, fileName);
	    frame.dispose();
	}
	  
	public static void drawAndSave(JPanel graphDrawing, String fileName, int canvasSize) {
		JFrame frame = new JFrame("Drawing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(graphDrawing);
		frame.setSize(canvasSize, canvasSize);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		exportToImage("jpg", graphDrawing, fileName);
		frame.dispose();
	}
}

package ImageEditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * A Panel for displaying the BufferedImage.
 * @author Quinn Luck
 * CS 1410
 *
 */
public class Image extends JPanel implements MouseListener, MouseMotionListener {

	private BufferedImage image;
	private int minX;
	private int maxX;
	private int minY;
	private int maxY;
	private ImageProcessor processor;
	
	public Image(BufferedImage img, ImageProcessor _processor){
		image = img;
		processor = _processor;
		System.out.println("Width of Image: " + image.getWidth());
		System.out.println("Height of Image: " + image.getHeight());
		processor.setNewSize(image.getHeight(), image.getWidth());
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	/**
	 * paints a gray rectangular box if the user wants to highlight an area of the image
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
		g.setColor(new Color(105, 105, 105, 125));
		if(minX - maxX > 0 && minY - maxY > 0)
			g.fillRect(maxX, maxY, minX - maxX, minY - maxY);
		else if(minY > maxY)
			g.fillRect(minX, maxY, maxX - minX, minY - maxY);
		else if(minX > maxX)
			g.fillRect(maxX, minY, minX - maxX, maxY - minY);
		else
			g.fillRect(minX, minY, maxX - minX, maxY - minY);
	}
	
	/**
	 * gets the selected area of an Image
	 * @return -- the selected area of an Image
	 */
	public RegionBox getSelectedBox(){
		if(minX > maxX){
			int minTemp = minX;
			minX = maxX;
			maxX = minTemp;
		}
		if(minY > maxY){
			int minTemp = minY;
			minY = maxY;
			maxY = minTemp;
		}
		if(maxX == 0 && maxY == 0){
			return new RegionBox(0, image.getWidth(), 0, image.getHeight());
		}
		else{
			return new RegionBox(minX, maxX, minY, maxY);
		}
	}

	/**
	 * when mouse is dragged, this method gets the maxX and maxY of the box
	 * (where the box ends)
	 */
	public void mouseDragged(MouseEvent e) {
		maxX = e.getX();
		maxY = e.getY();
		repaint();
		processor.setRotate(false);
	}
	
	/**
	 * when mouse is pressed, this method gets the minX and minY of the box
	 * (where the box starts)
	 */
	public void mousePressed(MouseEvent e) {
		minX = e.getX();
		minY = e.getY();
	}

	public void mouseReleased(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {}

	public void mouseClicked(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}
	
	public void mouseExited(MouseEvent e) {}
}

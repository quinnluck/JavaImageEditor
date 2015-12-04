package ImageEditor;

import java.awt.image.BufferedImage;

/**
 * Filter that takes all the color out of the image.
 * @author Quinn Luck
 * CS 1410
 *
 */
public class BlkWhtFilter extends RegionFilter{

	public BufferedImage filter(BufferedImage i) {
		BufferedImage result = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		for(int y = 0; y < i.getHeight(); y++){
			for(int x = 0; x < i.getWidth(); x++){
				if(y >= getMinY() && y <= getMaxY() && x >= getMinX() && x <= getMaxX()){
					int pixel = i.getRGB(x, y);
					
					int redAmount = (pixel >> 16) & 0xff;
					int greenAmount = (pixel >> 8) & 0xff;
					int blueAmount = (pixel >> 0) & 0xff;
				
					int sum = redAmount + greenAmount + blueAmount;
					sum = sum / 3;
				
					redAmount = sum;
					greenAmount = sum;
					blueAmount = sum;
			
					int newPixel = (redAmount << 16) | (greenAmount << 8) | blueAmount;
					result.setRGB(x, y, newPixel);
				}
				else
					result.setRGB(x, y, i.getRGB(x, y));
			}
		}
		return result;
	}
}

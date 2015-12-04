package ImageEditor;

import java.awt.image.BufferedImage;

/**
 * Filter that rotates the image clockwise.
 * @author Quinn Luck
 * CS 1410
 *
 */
public class ClockwiseRotateFilter extends RegionFilter{

	public BufferedImage filter(BufferedImage i) {
		BufferedImage result = new BufferedImage(i.getHeight(), i.getWidth(), BufferedImage.TYPE_INT_RGB);
		
		for(int y = 0; y < i.getHeight(); y++){
			for(int x = 0; x < i.getWidth(); x++){
				result.setRGB((i.getHeight() - 1 - y), x, i.getRGB(x, y));
			}
		}
		return result;
	}
}

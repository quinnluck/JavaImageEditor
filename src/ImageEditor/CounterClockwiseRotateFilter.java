package ImageEditor;

import java.awt.image.BufferedImage;

/**
 * Filter that rotates the image counter-clockwise.
 * @author Quinn Luck
 * CS 1410
 *
 */
public class CounterClockwiseRotateFilter extends RegionFilter{

	public BufferedImage filter(BufferedImage i) {
		BufferedImage result = new BufferedImage(i.getHeight(), i.getWidth(), BufferedImage.TYPE_INT_RGB);
		
		for(int y = i.getHeight() - 1; y > 0; y--){
			for(int x = i.getWidth() - 1; x > 0; x--){
				result.setRGB(y, (i.getWidth() - 1 - x), i.getRGB(x, y));
			}
		}
		return result;
	}
}

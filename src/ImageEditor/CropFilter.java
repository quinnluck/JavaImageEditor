package ImageEditor;

import java.awt.image.BufferedImage;

/**
 * Filter that crops a region selected from an image
 * 
 * @author Quinn Luck
 * CS 1410
 *
 */
public class CropFilter extends RegionFilter {

	public BufferedImage filter(BufferedImage i) {
		BufferedImage result = new BufferedImage(getMaxX() - getMinX(), getMaxY() - getMinY(), BufferedImage.TYPE_INT_RGB);

		for (int y = getMinY(); y < getMaxY(); y++) {
			for (int x = getMinX(); x < getMaxX(); x++) {
				if (y >= getMinY() && y <= getMaxY() && x >= getMinX() && x <= getMaxX()) {
					result.setRGB(x - getMinX(), y - getMinY(), i.getRGB(x, y));
				}
			}
		}
		return result;
	}
}

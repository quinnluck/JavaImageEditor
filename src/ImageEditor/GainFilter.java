package ImageEditor;

import java.awt.image.BufferedImage;

/**
 * Filter that modifies the contrast in the image.
 * 
 * @author Quinn Luck 
 * CS 1410
 * 
 */
public class GainFilter extends RegionFilter {

	private double gain;

	public GainFilter() {
		this.gain = 1.5;
	}

	public BufferedImage filter(BufferedImage i) {
		BufferedImage result = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_RGB);

		for (int y = 0; y < i.getHeight(); y++) {
			for (int x = 0; x < i.getWidth(); x++) {
				if (y >= getMinY() && y <= getMaxY() && x >= getMinX() && x <= getMaxX()) {
					int pixel = i.getRGB(x, y);

					int redAmount = (pixel >> 16) & 0xff;
					int greenAmount = (pixel >> 8) & 0xff;
					int blueAmount = (pixel >> 0) & 0xff;

					redAmount *= gain;
					if (redAmount > 255)
						redAmount = 255;
					greenAmount *= gain;
					if (greenAmount > 255)
						greenAmount = 255;
					blueAmount *= gain;
					if (blueAmount > 255)
						blueAmount = 255;
					int newPixel = (redAmount << 16) | (greenAmount << 8) | blueAmount;
					result.setRGB(x, y, newPixel);
				} 
				else
					result.setRGB(x, y, i.getRGB(x, y));
			}
		}
		return result;
	}

	/**
	 * setter for the Gain slider in ImageProcessor
	 * @param factor -- to be used to multiply each pixel
	 */
	public void setGainFactor(double factor) {
		gain = factor;
	}
}

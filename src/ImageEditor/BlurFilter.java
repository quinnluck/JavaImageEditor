package ImageEditor;

import java.awt.image.BufferedImage;

/**
 * Filter that blurs every pixel in the image.
 * 
 * @author Quinn Luck 
 * CS 1410
 * 
 */
public class BlurFilter extends RegionFilter {

	public BufferedImage filter(BufferedImage i) {
		BufferedImage result = new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_RGB);

		int rUp = 0;
		int rDown = 0;
		int rLeft = 0;
		int rRight = 0;
		int rNE = 0;
		int rNW = 0;
		int rSE = 0;
		int rSW = 0;

		int gUp = 0;
		int gDown = 0;
		int gLeft = 0;
		int gRight = 0;
		int gNE = 0;
		int gNW = 0;
		int gSE = 0;
		int gSW = 0;

		int bUp = 0;
		int bDown = 0;
		int bLeft = 0;
		int bRight = 0;
		int bNE = 0;
		int bNW = 0;
		int bSE = 0;
		int bSW = 0;
		for (int y = 0; y < i.getHeight(); y++) {
			for (int x = 0; x < i.getWidth(); x++) {
				if (y >= getMinY() && y <= getMaxY() && x >= getMinX() && x <= getMaxX()) {
					int pixel = i.getRGB(x, y);
					int rCenter = (pixel >> 16) & 0xff;
					int gCenter = (pixel >> 8) & 0xff;
					int bCenter = (pixel >> 0) & 0xff;

					if (y - 1 != -1) {
						int pixelUp = i.getRGB(x, y - 1);
						rUp = (pixelUp >> 16) & 0xff;
						gUp = (pixelUp >> 8) & 0xff;
						bUp = (pixelUp >> 0) & 0xff;
					}
					if (y + 1 != i.getHeight()) {
						int pixelDown = i.getRGB(x, y + 1);
						rDown = (pixelDown >> 16) & 0xff;
						gDown = (pixelDown >> 8) & 0xff;
						bDown = (pixelDown >> 0) & 0xff;
					}
					if (x - 1 != -1) {
						int pixelLeft = i.getRGB(x - 1, y);
						rLeft = (pixelLeft >> 16) & 0xff;
						gLeft = (pixelLeft >> 8) & 0xff;
						bLeft = (pixelLeft >> 0) & 0xff;
					}

					if (x - 1 != -1 && y - 1 != -1) {
						int pixelNW = i.getRGB(x - 1, y - 1);
						rNW = (pixelNW >> 16) & 0xff;
						gNW = (pixelNW >> 8) & 0xff;
						bNW = (pixelNW >> 0) & 0xff;
					}
					if (x - 1 != -1 && y + 1 != i.getHeight()) {
						int pixelSW = i.getRGB(x - 1, y + 1);
						rSW = (pixelSW >> 16) & 0xff;
						gSW = (pixelSW >> 8) & 0xff;
						bSW = (pixelSW >> 0) & 0xff;
					}

					if (x + 1 != i.getWidth()) {
						int pixelRight = i.getRGB(x + 1, y);
						rRight = (pixelRight >> 16) & 0xff;
						gRight = (pixelRight >> 8) & 0xff;
						bRight = (pixelRight >> 0) & 0xff;
					}

					if (x + 1 != i.getWidth() && y - 1 != -1) {
						int pixelNE = i.getRGB(x + 1, y - 1);
						rNE = (pixelNE >> 16) & 0xff;
						gNE = (pixelNE >> 8) & 0xff;
						bNE = (pixelNE >> 0) & 0xff;
					}

					if (x + 1 != i.getWidth() && y + 1 != i.getHeight()) {
						int pixelSE = i.getRGB(x + 1, y + 1);
						rSE = (pixelSE >> 16) & 0xff;
						gSE = (pixelSE >> 8) & 0xff;
						bSE = (pixelSE >> 0) & 0xff;
					}
					int redSum = rCenter + rUp + rDown + rLeft + rRight + rNW
							+ rNE + rSW + rSE;
					redSum = redSum / 9;
					int greenSum = gCenter + gUp + gDown + gLeft + gRight + gNW
							+ gNE + gSW + gSE;
					greenSum = greenSum / 9;
					int blueSum = bCenter + bUp + bDown + bLeft + bRight + bNW
							+ bNE + bSW + bSE;
					blueSum = blueSum / 9;
					int redAmount = redSum;
					int greenAmount = greenSum;
					int blueAmount = blueSum;

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

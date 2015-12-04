package ImageEditor;

import java.awt.image.BufferedImage;

/**
 * An interface that ensures the filters are implemented in the correct way.
 * @author Erin Parker  used by: Quinn Luck
 * CS 1410
 *
 */
public interface ImageFilter {

	public BufferedImage filter(BufferedImage i);
}

package ImageEditor;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Menu set up for the Image Filtering GUI
 * @author Quinn Luck
 * CS 1410
 *
 */
public class ImageGUI extends JMenuBar{

	private JMenu allfilters;
	private JMenu saveload;
	private JMenuItem RGSwap;
	private JMenuItem RBSwap;
	private JMenuItem GBSwap;
	private JMenuItem blkwht;
	private JMenuItem clock;
	private JMenuItem counterclock;
	private JMenuItem gain;
	private JMenuItem bias;
	private JMenuItem blur;
	private JMenuItem aged;
	private JMenuItem save;
	private JMenuItem load;
	private JMenuItem crop;
	
	/**
	 * sets up the menu of the ImageProcessor GUI
	 */
	public ImageGUI(){
		allfilters = new JMenu("Filters");
		allfilters.setToolTipText("Choose a filter to filter the image selected");
		saveload = new JMenu("File");
		saveload.setToolTipText("Load or Save a filtered Image");
		RGSwap = new JMenuItem("Red-Green Swap");
		RGSwap.setToolTipText("Switches the Red and Green components of the pixel");
		RBSwap = new JMenuItem("Red-Blue Swap");
		RBSwap.setToolTipText("Switches the Red and Blue components of the pixel");
		GBSwap = new JMenuItem("Green-Blue Swap");
		GBSwap.setToolTipText("Switches the Green and Blue components of the pixel");
		blkwht = new JMenuItem("Black and White");
		blkwht.setToolTipText("Renders the image black and white");
		clock = new JMenuItem("Clockwise Rotation");
		clock.setToolTipText("Rotates the image clockwise");
		counterclock = new JMenuItem("Counter-Clockwise Rotation");
		counterclock.setToolTipText("Rotates the image counter-clockwise");
		gain = new JMenuItem("Gain");
		gain.setToolTipText("Modifies the contrast of the image");
		bias = new JMenuItem("Bias");
		bias.setToolTipText("Modifies the brightness of the image");
		blur = new JMenuItem("Blur");
		blur.setToolTipText("Blurs the image");
		aged = new JMenuItem("Aged");
		aged.setToolTipText("Makes the image look aged (like an old poloroid picture)");
		crop = new JMenuItem("Crop");
		crop.setToolTipText("Crops the original Image");
		allfilters.add(RGSwap);
		allfilters.add(RBSwap);
		allfilters.add(GBSwap);
		allfilters.add(blkwht);
		allfilters.add(clock);
		allfilters.add(counterclock);
		allfilters.add(gain);
		allfilters.add(bias);
		allfilters.add(blur);
		allfilters.add(aged);
		allfilters.add(crop);
		save = new JMenuItem("Save Image");
		save.setToolTipText("Saves the filtered image");
		save.setEnabled(false);
		load = new JMenuItem("Load Image");
		load.setToolTipText("Loads an image from the computer");
		saveload.add(load);
		saveload.add(save);
		add(saveload);
		add(allfilters);
		allfilters.setEnabled(false);
	}
	
	/**
	 * adds ActionListeners to all filters and JMenuItems.
	 * @param al - action listener to be added
	 */
	public void setActionListener(ActionListener al){
		load.addActionListener(al);
		save.addActionListener(al);
		crop.addActionListener(al);
		aged.addActionListener(al);
		blur.addActionListener(al);
		bias.addActionListener(al);
		gain.addActionListener(al);
		counterclock.addActionListener(al);
		clock.addActionListener(al);
		blkwht.addActionListener(al);
		GBSwap.addActionListener(al);
		RBSwap.addActionListener(al);
		RGSwap.addActionListener(al);
	}

	public JMenu getAllfilters() {
		return allfilters;
	}
	public JMenu getSaveload() {
		return saveload;
	}
	public JMenuItem getRGSwap() {
		return RGSwap;
	}
	public JMenuItem getRBSwap() {
		return RBSwap;
	}
	public JMenuItem getGBSwap() {
		return GBSwap;
	}
	public JMenuItem getBlkwht() {
		return blkwht;
	}
	public JMenuItem getClock() {
		return clock;
	}
	public JMenuItem getCounterclock() {
		return counterclock;
	}
	public JMenuItem getGain() {
		return gain;
	}
	public JMenuItem getBias() {
		return bias;
	}
	public JMenuItem getBlur() {
		return blur;
	}
	public JMenuItem getAged() {
		return aged;
	}
	public JMenuItem getSave() {
		return save;
	}
	public JMenuItem getLoad() {
		return load;
	}
	public JMenuItem getCrop() {
		return crop;
	}
}

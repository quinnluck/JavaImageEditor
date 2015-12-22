package ImageEditor;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Menu set up for the Image Filtering GUI
 * @author Quinn Luck
 *
 */
public class ImageGUI extends JMenuBar{

	private JMenu allFilters;
	private JMenu saveLoad;
	private JMenuItem RGSwap;
	private JMenuItem RBSwap;
	private JMenuItem GBSwap;
	private JMenuItem blkWht;
	private JMenuItem clock;
	private JMenuItem counterClock;
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
		allFilters = new JMenu("Filters");
		allFilters.setToolTipText("Select a filter to filter the image with");
		saveLoad = new JMenu("File");
		saveLoad.setToolTipText("Load or Save a filtered Image");
		RGSwap = new JMenuItem("Red-Green Swap");
		RGSwap.setToolTipText("Switches the Red and Green components of the pixel");
		RBSwap = new JMenuItem("Red-Blue Swap");
		RBSwap.setToolTipText("Switches the Red and Blue components of the pixel");
		GBSwap = new JMenuItem("Green-Blue Swap");
		GBSwap.setToolTipText("Switches the Green and Blue components of the pixel");
		blkWht = new JMenuItem("Black and White");
		blkWht.setToolTipText("Renders the image black and white");
		clock = new JMenuItem("Clockwise Rotation");
		clock.setToolTipText("Rotates the image clockwise");
		counterClock = new JMenuItem("Counter-Clockwise Rotation");
		counterClock.setToolTipText("Rotates the image counter-clockwise");
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
		allFilters.add(RGSwap);
		allFilters.add(RBSwap);
		allFilters.add(GBSwap);
		allFilters.add(blkWht);
		allFilters.add(clock);
		allFilters.add(counterClock);
		allFilters.add(gain);
		allFilters.add(bias);
		allFilters.add(blur);
		allFilters.add(aged);
		allFilters.add(crop);
		save = new JMenuItem("Save Image");
		save.setToolTipText("Saves the filtered image");
		save.setEnabled(false);
		load = new JMenuItem("Load Image");
		load.setToolTipText("Loads an image from the computer");
		saveLoad.add(load);
		saveLoad.add(save);
		add(saveLoad);
		add(allFilters);
		allFilters.setEnabled(false);
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
		counterClock.addActionListener(al);
		clock.addActionListener(al);
		blkWht.addActionListener(al);
		GBSwap.addActionListener(al);
		RBSwap.addActionListener(al);
		RGSwap.addActionListener(al);
	}

	public JMenu getAllfilters() {
		return allFilters;
	}
	public JMenu getSaveload() { return saveLoad; }
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
		return blkWht;
	}
	public JMenuItem getClock() {
		return clock;
	}
	public JMenuItem getCounterclock() {
		return counterClock;
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

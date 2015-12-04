package ImageEditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Final Project Image Filters Part 3
 * 
 * @author Quinn Luck 
 * CS 1410
 * 
 */
public class ImageProcessor extends JFrame implements ActionListener, ChangeListener {

	public static File file;
	private JTabbedPane panel;
	private Image originalPanel;
	private ImageGUI GUI;
	private JSlider gainSlider;
	private JSlider biasSlider;
	private JPanel sliderHolder;
	private JButton cume;
	private BufferedImage originalImage;
	private BufferedImage filteredImage;
	private RegionFilter f;
	private boolean cumulative = false;
	
	public static void main(String[] args) {
		ImageProcessor awesome = new ImageProcessor();
		awesome.setVisible(true);
	}

	/**
	 * Creates a Panel for all of the Filters used.
	 */
	public ImageProcessor() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel holder = new JPanel();
		holder.setLayout(new BorderLayout());
		sliderHolder = new JPanel();
		sliderHolder.setLayout(new GridLayout(1,2));
		panel = new JTabbedPane();
		cume = new JButton("Cumulative Filters On");
		cume.addActionListener(this);
		cume.setEnabled(false);
		gainSlider = new JSlider(2, 12);
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();	
		labelTable.put(2, new JLabel("0.5"));
		labelTable.put(4, new JLabel("0.75"));
		labelTable.put(6, new JLabel("1.25"));	
		labelTable.put(8, new JLabel("1.5"));
		labelTable.put(10, new JLabel("1.75"));
		labelTable.put(12, new JLabel("2.0"));
		gainSlider.setLabelTable(labelTable);
		gainSlider.setToolTipText("Values < 0 lessens the contrast of the image, values > 0 greaten the contrast of the image");
		gainSlider.setPaintLabels(true);
		gainSlider.addChangeListener(this);
		gainSlider.setEnabled(false);
		biasSlider = new JSlider(SwingConstants.HORIZONTAL, -200, 200, 25);
		biasSlider.setMajorTickSpacing(50);
		biasSlider.setMinorTickSpacing(10);
		biasSlider.setPaintLabels(true);
		biasSlider.setPaintTicks(true);
		biasSlider.setToolTipText("Values < 0 darken the image, values > 0 brighten the image");
		biasSlider.addChangeListener(this);
		biasSlider.setEnabled(false);
		sliderHolder.add(gainSlider);
		sliderHolder.add(biasSlider);
		sliderHolder.setVisible(false);
		holder.add(sliderHolder, BorderLayout.SOUTH);
		holder.add(panel, BorderLayout.CENTER);
		holder.add(cume, BorderLayout.NORTH);
		setTitle("Image Filtering");
		setContentPane(holder);
		setPreferredSize(new Dimension(900, 900));
		pack();
		GUI = new ImageGUI();
		setJMenuBar(GUI);
		GUI.setActionListener(this);
	}

	/**
	 * performs actions depending on which button is clicked.
	 **/
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenu){
			if(!originalPanel.getSelectedBox().equals(new RegionBox(0, originalImage.getWidth(), 0, originalImage.getHeight()))){
				GUI.getClock().setEnabled(false);
				GUI.getCounterclock().setEnabled(false);
			}
			else{
				GUI.getClock().setEnabled(true);
				GUI.getCounterclock().setEnabled(true);
			}	
			return;
		}
		if(e.getSource() instanceof JButton){
			JButton button = (JButton) e.getSource();
			if(cumulative){
				cumulative = false;
				button.setText("Cumulative Filters On");
			}
			else {
				cumulative = true;
				button.setText("Cumulative Filters Off");
			}
		}		
		if(filteredImage != null && cumulative)
				originalImage = filteredImage;
		
		if(e.getSource() instanceof JMenuItem){
		JMenuItem item = (JMenuItem) e.getSource();
		if (item == GUI.getLoad()) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"JPG, JPEG, PNG, BMP, GIF Images", "jpg", 
					"jpeg", "png","bmp", "gif");
			chooser.setFileFilter(filter);
			int outcome = chooser.showOpenDialog(chooser);
			if (outcome == JFileChooser.APPROVE_OPTION) {
				file = chooser.getSelectedFile();
			try {
				originalImage = ImageIO.read(file);
			} 
			catch (IOException exception) {
				JOptionPane.showMessageDialog(null,"File cannot be opened or read");
				System.exit(0);
			}
		}
			originalPanel = new Image(originalImage, this);
			if(panel.getTabCount() >= 1)
				panel.setComponentAt(0, originalPanel);
			else
				panel.add("Original Image", originalPanel);
			GUI.getAllfilters().setEnabled(true);
			cume.setEnabled(true);
			return;
		} 
		else if(item == GUI.getSave()){
			JFileChooser chooser = new JFileChooser();
			int outcome = chooser.showSaveDialog(chooser);
			if (outcome == JFileChooser.APPROVE_OPTION) {
				try {
					File outputImage = chooser.getSelectedFile();
					ImageIO.write(filteredImage, "jpg", outputImage);
				} 
				catch (IOException io) {
					JOptionPane.showMessageDialog(null,"Error! File could not save.");
				}
				return;
			}
		}
		else if (item == GUI.getRGSwap()) {
			f = new RGSwapFilter();			
		} 
		else if (item == GUI.getRBSwap()) {			
			f = new RBSwapFilter();			
		} 
		else if (item == GUI.getGBSwap()) {			
			f = new GBSwapFilter();			
		} 
		else if (item == GUI.getBlkwht()) {			
			f = new BlkWhtFilter();			
		} 
		else if (item == GUI.getClock()) {			
			f = new ClockwiseRotateFilter();			
		} 
		else if (item == GUI.getCounterclock()) {			
			f = new CounterClockwiseRotateFilter();			
		} 
		else if (item == GUI.getGain()) {
			biasSlider.setEnabled(false);
			sliderHolder.setVisible(true);
			gainSlider.setEnabled(true);
			f = new GainFilter();			
		} 
		else if (item == GUI.getBias()) {
			gainSlider.setEnabled(false);
			sliderHolder.setVisible(true);
			biasSlider.setEnabled(true);
			f = new BiasFilter();		
		} 
		else if (item == GUI.getBlur()) {			
			f = new BlurFilter();			
		} 
		else if (item == GUI.getAged()) {			
			f = new AgedFilter();
		}
		else {
			f = new CropFilter();
		}
		GUI.getSave().setEnabled(true);
		f.setRegion(originalPanel.getSelectedBox());
		filteredImage = f.filter(originalImage);
		if(panel.getTabCount() != 2)
			panel.add("Filtered Image", new Image(filteredImage, this));
		else
			panel.setComponentAt(1, new Image(filteredImage, this));
		}
	}

	/**
	 * Method for Bians and Gain sliders
	 */
	public void stateChanged(ChangeEvent e) {
		JSlider src = (JSlider)e.getSource();
		if(src.equals(gainSlider)){
			if(!src.getValueIsAdjusting()) {
				int val = (int)src.getValue();
				GainFilter g = (GainFilter) f;
				g.setGainFactor(val * 0.25);
				filteredImage = g.filter(originalImage);
				if(panel.getTabCount() != 2)
					panel.add("Filtered Image", new Image(filteredImage, this));
				else
					panel.setComponentAt(1, new Image(filteredImage, this));
			}
		}
		if(src.equals(biasSlider)){
			if(!src.getValueIsAdjusting()){
				int val = (int) src.getValue();
				BiasFilter g = (BiasFilter) f;
				g.setBiasFactor(val * 2);
				filteredImage = g.filter(originalImage);
				if(panel.getTabCount() != 2)
					panel.add("Filtered Image", new Image(filteredImage, this));
				else
					panel.setComponentAt(1, new Image(filteredImage, this));
			}
		}
	}
	/**
	 * toggles the enabling of the Clockwise rotation and Counterclockwise rotation
	 * filters.
	 * @param enabled - true or false 
	 */
	public void setRotate(boolean enabled){
		GUI.getClock().setEnabled(enabled);
		GUI.getCounterclock().setEnabled(enabled);
	}
}

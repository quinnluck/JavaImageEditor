package ImageEditor;

/**
 * Represents a rectangular region
 * @author Quinn Luck
 * CS 1410
 * 
 */

public class RegionBox {

	private int maxX;
	private int maxY;
	private int minX;
	private int minY;
	
	public RegionBox(int _minX, int _maxX, int _minY, int _maxY){
		minX = _minX;
		maxX = _maxX;
		minY = _minY;
		maxY = _maxY;
	}
	
	public RegionBox(){
		minX = 0;
		maxX = 0;
		minY = 0;
		maxY = 0;
	}
	
	public int getMinX(){
		return minX;
	}
	
	public int getMaxX(){
		return maxX;
	}
	
	public int getMinY(){
		return minY;
	}
	
	public int getMaxY(){
		return maxY;
	}
	
	/**
	 * sets the maxX, minX, maxY, and minY of the RegionBox
	 * @param _minX - starting x coordinate
	 * @param _maxX - ending x coordinate
	 * @param _minY - starting y coordinate
	 * @param _maxY - ending y coordinate
	 */
	public void setPoints(int _minX, int _maxX, int _minY, int _maxY){
		minX = _minX;
		maxX = _maxX;
		minY = _minY;
		maxY = _maxY;
	}
	
	/**
	 * method which returns whether the Image has a selected area
	 * @param _box - RegionBox to be compared
	 * @return - true or false depeding on whether the Image has a selected area or not 
	 */
	public boolean equals(RegionBox _box){
		if(minX == _box.minX && maxX == _box.maxX && minY == _box.minY && maxY == _box.maxY ){
			return true;
		}
		return false;
	}
}

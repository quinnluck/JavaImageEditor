package ImageEditor;

/**
 * Filters a specific selected region of an Image
 * @author Quinn Luck
 *CS 1410
 *
 */
public abstract class RegionFilter implements ImageFilter{

	private RegionBox box;
	
	public RegionFilter(){
		box = new RegionBox();
	}
	
	public void setRegion(RegionBox _box){
		box = _box;
	}
	
	public int getMinX(){
		return box.getMinX();
	}
	
	public int getMaxX(){
		return box.getMaxX();
	}
	
	public int getMinY(){
		return box.getMinY();
	}
	
	public int getMaxY(){
		return box.getMaxY();
	}
}

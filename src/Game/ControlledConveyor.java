//*************************************************************************
//
// 	ControlledConveyor.java		Author: Juan Callejas		ID:216 631 905
//
//*************************************************************************

package Game;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.*;

import java.util.*;

public class ControlledConveyor extends GridTileBase {
	
	private static ArrayList<ControlledConveyor> instances = new ArrayList<ControlledConveyor>();
	
	private ArrayList<Dir> allowedDirs;
	private Dir currentDir;
	private int currentDirIndex;
	
	private TreeMap<Dir, Image> dirViews = new TreeMap<Dir, Image>();
	
	public ControlledConveyor () {
		
		this (Dir.values());
		
	}
	
	public ControlledConveyor (Dir[] allowedDirs) {
		
		if (allowedDirs.length < 2)
			throw new RuntimeException("Controlled Conveyor only allows " + allowedDirs.length + " dir(s). At least 2 should be allowed.");
		
		instances.add(this);
		
		//All conveyor animations have the same frame duration (FAST)
		setAnimSpeed(NORMAL);
		//All conveyor animations also have the same amount of columns
		setSpriteSheetColumns(COLUMNS_CONV);
		
		//Define our list of allowed dirs by casting the passed array to an ArrayList
		this.allowedDirs = new ArrayList<Dir>(Arrays.asList(allowedDirs));
		
		//Pre-fabricate image views for all allowed dirs, to avoid too much garbage collection
		//Move them into a TreeMap to assign an ImageView to each Dir
		for (Dir dir:allowedDirs) {
			dirViews.put(dir, new Image(getClass().getResource ("../Res/Directional." + dir.name() + ".png").toString()));
		}
		
		//Set any arbitrary anim path just to avoid nullRefExc
		setAnimPath(imgPath_C_FW);
		
		//Set the intial value of the conveyor
		if (this.allowedDirs.contains(Dir.FW))
			setDir(Dir.FW);    //Preferably if forward is allowed, then start forwards
		else
			setDir(allowedDirs[0]); //Otherwise just pick whichever was listed first
		
	}
	
	public void setDir (Dir dir) {
		
		if (!allowedDirs.contains(dir))
			throw new InvalidConveyorDirException(dir, (Dir[]) allowedDirs.toArray());
		
		currentDir = dir;
		currentDirIndex = allowedDirs.indexOf(dir);
		
		//Make sure everything has been correctly initialized
		GetView();
		
		//Set the image view to the one corresponding to this dir
		getAnim().GetView().setImage(dirViews.get(dir));
		
	}
	
	//Set the current dir to the 'next' one (mostly for testing due to obscurity)
	public void cycleDir () {
		if (currentDirIndex < allowedDirs.size() - 1)
			currentDirIndex++;
		else
			currentDirIndex = 0;
		setDir(allowedDirs.get(currentDirIndex));
	}
	
	//Cycle dirs for all instances
	public static void cycleAllDir () {
		
		for (ControlledConveyor conv:instances)
			conv.cycleDir();
	
	}
	
}

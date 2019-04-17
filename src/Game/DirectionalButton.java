//*************************************************************************
//
// 	DirectionalButton.java			Author: Juan Callejas       ID:216 631 905
//
//	[[[ ENTER DESCRIPTION HERE ]]]
//
//*************************************************************************
package Game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class DirectionalButton extends Button {
	
	private static final String imgPath_Dir = "../Res/Buttons/";
	//Controls
	private static final String imgPath_DirL	= imgPath_Dir +
			"Button.Dir.L_Normal.png";
	private static final String imgPath_DirR	= imgPath_Dir +
			"Button.Dir.R_Normal.png";
	private static final String imgPath_DirFW	= imgPath_Dir +
			"Button.Dir.FW_Normal.png";
	
	private TreeMap <Dir, ImageView> dirViews = new TreeMap<>();
	private ControlledConveyor[] conveyors;
	private List<Dir> allowedDirs;
	private Dir currentDir;
	private int currentDirIndex;
	
	private ImageView L;
	private ImageView R;
	private ImageView FW;
	
	public DirectionalButton (ControlledConveyor[] conveyors) {
		this (conveyors, Dir.values());
	}
	
	public DirectionalButton (ControlledConveyor[] conveyors, Dir[] allowedDirs) {
	
		super();
		
		if (allowedDirs.length < 2)
			throw new RuntimeException("Controlled Conveyor only allows " + allowedDirs.length + " dir(s). At least 2 should be allowed.");
		
		this.conveyors = conveyors;
		this.allowedDirs = Arrays.asList(allowedDirs);
		
		//Initialize a new set of ImageViews per sprite for this instance.
		//ImageView instances cannot be shared by multiple buttons, so we
		//must create a new set of instances for each DirectionalButton.
		L = new ImageView(new Image(
				getClass().getResource(imgPath_DirL).toString(),
				true
		));
		R = new ImageView(new Image(
				getClass().getResource(imgPath_DirR).toString(),
				true
		));
		FW = new ImageView(new Image(
				getClass().getResource(imgPath_DirFW).toString(),
				true
		));
		
		//Map ImageViews to Dirs
		dirViews.put(Dir.L, L);
		dirViews.put(Dir.R, R);
		dirViews.put(Dir.FW, FW);
		
		//Set the starting state depending on what directions are allowed
		if (this.allowedDirs.contains(Dir.FW)) {
			setDir(Dir.FW);
		} else {
			setDir(allowedDirs[0]);
		}
		
		//Disable padding so none of the default button sprite is visible
		setPadding(Insets.EMPTY);
		
		//Set event handler to cycle dirs
		addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				Cycle();
			}
		});
		
	}
	
	public void setDir (Dir dir) {
		
		if (!allowedDirs.contains(dir))
			throw new InvalidConveyorDirException(dir, (Dir[]) allowedDirs.toArray());
		
		currentDir = dir;
		currentDirIndex = allowedDirs.indexOf(dir);
		
		setGraphic(dirViews.get(dir));
		
	}
	
	public void Cycle () {
		
		//Call the CycleDir method of all conveyors this button should control
		for (ControlledConveyor conv : conveyors) {
		
			conv.cycleDir();
		
		}
		
		
		if (currentDirIndex < allowedDirs.size() - 1)
			currentDirIndex++;
		else
			currentDirIndex = 0;
		
		currentDir = allowedDirs.get(currentDirIndex);
		
		setGraphic(dirViews.get(currentDir));
	
	}
	
}

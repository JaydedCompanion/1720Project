//*************************************************************************
//
// 	StaticConveyor.java			Author: Juan Callejas       ID:216 631 905
//
//	[[[ ENTER DESCRIPTION HERE ]]]
//
//*************************************************************************
package Game;

enum Dir {
	
	Left,
	Right,
	Forward
	
}

public class StaticConveyor extends GridTileBase {
	
	private Dir direction;
	
	public StaticConveyor(Dir dir) {
		
		//All static conveyor animations have the same frame duration (FAST)
		setAnimSpeed(FAST);
		//All static conveyor animations also have the same amount of columns
		setSpriteSheetColumns(6);
		direction = dir;
		
		switch (dir) {
			
			case Left:
				setAnimPath(imgPath_L);
				break;
			
			case Right:
				setAnimPath(imgPath_R);
				break;
			
			case Forward:
				setAnimPath(imgPath_FW);
				break;
			
		}
	
	}

}

//This exception is thrown when the user attempts to set the conveyor direction to one that is not actively enabled
//if this is the case, then the GUI should only show the directions that are valid
class InvalidConveyorDirException extends RuntimeException {
	
	private Dir invalidDir;
	
	public InvalidConveyorDirException(Dir dir) {
		
		super ("Attempted to set Conveyor direction to " + dir.name() + " which has been disabled for this conveyor.");
		
		invalidDir = dir;
		
	}
	
	public Dir getInvalidDir() {return invalidDir;}
	
}
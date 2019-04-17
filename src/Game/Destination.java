//*************************************************************************
//
// 	StaticConveyor.java			Author: Juan Callejas       ID:216 631 905
//
//	[[[ ENTER DESCRIPTION HERE ]]]
//
//*************************************************************************
package Game;

public class Destination extends GridTileBase {
	
	private ShapeTypes shape;
	
	public Destination (ShapeTypes shape) {
		
		setAnimSpeed(SLOW);
		//All destination tiles have a single sprite per spritesheet
		setSpriteSheetColumns(1);
		this.shape = shape;
		
		switch (shape) {
			
			case circle:
				setAnimPath(imgPath_End_Circle);
				break;
			
			case square:
				setAnimPath(imgPath_End_Square);
				break;
			
			case triangle:
				setAnimPath(imgPath_End_Triangle);
				break;
			
			case trash:
				setAnimPath(imgPath_End_Trash);
				setSpriteSheetColumns(COLUMNS_TRASH);
				break;
			
		}
	
	}
	
	public ShapeTypes getShape () {
		return shape;
	}
	
}
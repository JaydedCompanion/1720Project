//*************************************************************************
//
// 	BlankTile.java			Author: Juan Callejas       ID:216 631 905
//
//	[[[ ENTER DESCRIPTION HERE ]]]
//
//*************************************************************************
package Game;

enum BlankVariants {
	
	Grill,
	Machinery,
	Padding,
	Pipes,
	Quarters,
	Shiny

}

public class BlankTile extends GridTileBase {

	private BlankVariants variant;
	
	public BlankTile (BlankVariants variant) {
	
		this.variant = variant;
		
		//As long as the spritesheet maintains naming conventions, this
		//snippet of code will automatically find the spritesheet cor-
		//responding to this variant.
		setAnimPath("../Res/Empty." + variant.name() + ".png");
		setAnimSpeed(NORMAL);
		setSpriteSheetColumns(1);
		
		//Some spritesheets have a varying number of columns; override them here
		switch (variant) {
			
			case Machinery:
				setSpriteSheetColumns(8);
				break;
			
		}
	
	}
	
}

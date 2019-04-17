//*************************************************************************
//
// 	GridTileBase.java	Author: Juan Callejas		ID:216 631 905
//
//*************************************************************************

package Game;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

public class GridTileBase {
	
	//Static Vars
	protected static final String imgPath_L  = "../Res/Conv.L.png";
	protected static final String imgPath_R  = "../Res/Conv.R.png";
	protected static final String imgPath_FW = "../Res/Conv.FW.png";
	protected static final String imgPath_C_L  = "../Res/Directional.L.png";
	protected static final String imgPath_C_R  = "../Res/Directional.R.png";
	protected static final String imgPath_C_FW = "../Res/Directional.FW.png";
	protected static final String imgPath_End_Circle  	= "../Res/End.Circle.png";
	protected static final String imgPath_End_Square  	= "../Res/End.Square.png";
	protected static final String imgPath_End_Triangle  = "../Res/End.Triangle.png";
	
	protected static final int COLUMNS_CONV		= 8;
	protected static final int SIZE				= 64;
	
	protected static final int SLOW	= 500;
	protected static final int NORMAL	= 250;
	protected static final int FAST	= 150;
	
	//Instance Vars
	private SpriteAnimation anim;
	private String animPath;
	private int animSpeed;
	private int spriteSheetColumns;
	
	public ImageView GetView () {
		
		//If there's already an animation and it already has an ImageView, then just return the existing instance
		if (anim != null && anim.GetView () != null)
			return anim.GetView();
		
		System.out.println(animPath);
		
		try {
			
			//If there wasn't an ImageView to return, then create one
			final ImageView imageView = new ImageView(new Image(getClass().getResource(animPath).toString(), true));
			
			imageView.setViewport(new Rectangle2D(0, 0, SIZE, SIZE));
			
			anim = new SpriteAnimation(
					imageView,
					Duration.millis(animSpeed),
					spriteSheetColumns, spriteSheetColumns,
					SIZE, SIZE
			);
			
			anim.setCycleCount(Animation.INDEFINITE);
			anim.play();
			
			return imageView;
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	//Setters for child classes
	protected void setAnimPath (String val) {animPath = val;}
	protected void setAnimSpeed (int val) {animSpeed = val;}
	protected void setSpriteSheetColumns (int val) {spriteSheetColumns = val;}
	//Getters for child classes
	protected SpriteAnimation getAnim () {return anim;}
	
}

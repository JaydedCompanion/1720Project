package Game;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/*

 * The code in this class is from https://netopyr.com/2012/03/09/creating-a-sprite-animation-with-javafx/
 *
 * This code is "vital" to the functionality of the game (so that the game has animations), but since it is not
 * used to fulfill any of the assignment requirements we request it be ignored for academic purposes as we take
 * no credit for it and we will simply use it as a pre-written library by a 3rd party.

 */

public class SpriteAnimation extends Transition {
	
	private ImageView imageView;
	private final int count;
	private final int columns;
	private final int width;
	private final int height;
	
	private int lastIndex;
	
	public SpriteAnimation(
			ImageView imageView,
			Duration duration,
			int count,   int columns,
			int width,   int height) {
		
		this.imageView = imageView;
		this.count     = count;
		this.columns   = columns;
		this.width     = width;
		this.height    = height;
		setCycleDuration(duration);
		setInterpolator(Interpolator.LINEAR);
		
	}
	
	public ImageView GetView () {
		return imageView;
	}
	
	protected void interpolate(double k) {
		
		final int index = Math.min((int) Math.floor(k * count), count - 1);
		if (index != lastIndex) {
			final int x = (index % columns) * width;
			final int y = (index / columns) * height;
			imageView.setViewport(new Rectangle2D(x, y, width, height));
			lastIndex = index;
		}
		
	}
	
	public void setImageView (ImageView view) {imageView = view;}
	
}
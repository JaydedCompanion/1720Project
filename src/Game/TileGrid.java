//*************************************************************************
//
// 	TileGrid.java		Author: Juan Callejas		ID:216 631 905
//
//*************************************************************************

package Game;

import javafx.scene.layout.GridPane;

import java.util.Random;

public class TileGrid extends GridPane {
	
	private GridTileBase[][] grid;
	private Random random = new Random();
	
	public TileGrid (int cols, int rows) {
		
		grid = new GridTileBase[cols][rows];
	
	}
	
	public void add (GridTileBase child, int colIndex, int rowIndex) {
		
		//Snippet of code to add functionality for negative index values
		if (colIndex < 0)
			colIndex = grid.length + colIndex;
		if (rowIndex < 0)
			rowIndex = grid[colIndex].length + rowIndex;
					
		grid[colIndex][rowIndex] = child;
		
		super.add(child.GetView(), colIndex, rowIndex);
		
	}
	
	public GridTileBase getConveyor (int colIndex, int rowIndex) {
		
		if (colIndex < 0)
			colIndex = grid.length + colIndex;
		if (rowIndex < 0)
			rowIndex = grid[colIndex].length + rowIndex;
		
		return grid[colIndex][rowIndex];
	
	}
	
	public void fillEmptyTiles () {
		
		BlankVariants[] variants = BlankVariants.values();
		
		fillEmptyTiles(variants);
		
	}
	
	public void fillEmptyTiles (BlankVariants[] variants) {
		
		if (variants.length == 0)
			return;
		
		//If the sole variant passed is ALL, then convert the variant array
		//to all available variants
		
		for (int i = 0; i < grid.length; i++) {
			
			for (int j = 0; j < grid[i].length; j++) {
				
				System.out.println(getConveyor(i,j));
			
				//If there's already a conveyor on this tile, then move on
				if (getConveyor(i, j) != null)
					continue;
				
				int in = 0;
				
				if (variants.length > 1)
					in = Math.round(random.nextFloat()*(variants.length - 1));
				
				add(new BlankTile(variants[in]), i, j);
			
			}
			
		}
	
	}
	
	public int getRows () {return grid[0].length;}
	public int getCols () {return grid.length;}
	
}

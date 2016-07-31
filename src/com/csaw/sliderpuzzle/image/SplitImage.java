package com.csaw.sliderpuzzle.image;

import java.util.ArrayList;

import com.csaw.sliderpuzzle.tiles.Tile;

import android.graphics.Bitmap;
import android.util.Log;


public class SplitImage {
	
	/**
	 * Split image into to tiles
	 * @param original_image - original bitmap to be split into tiles
	 * @param matrix_size - size of slider puzzle
	 * @param tileboard_width - width of screen in pixels
	 */
	public Bitmap splitImage(Bitmap original_image, int tileboard_width, int matrix_size)
	{
		//convert image into a square image
		Bitmap square_bitmap = makeSquareImage(original_image, tileboard_width);
		
		Bitmap scaled_image = scaleImageScreenWidth(square_bitmap, tileboard_width);
		
		ArrayList<Tile> tiles = splitIntoTiles(scaled_image, matrix_size);
		for (Tile p : tiles)
		{
			 System.out.println("point x: " + p.x + ", point y: " + p.y);
		}
		   
		
		//make image fit to device screen
//		Log.w("Slider puzzle tiles", " "+tiles);
		

		
		return scaled_image;
		
	}
	
	/**
	 * Make slider puzzle image square to use
	 * @param orig_bitmap - original bitmap before resizing
	 * @return square bitmap
	 */
	private Bitmap makeSquareImage(Bitmap orig_bitmap, int tileboard_width)
	{
		Bitmap newBmp = null;

		//if height is greater than width - use width size
		if(orig_bitmap.getHeight() >= orig_bitmap.getWidth()) {
			 newBmp = Bitmap.createBitmap(orig_bitmap, 
					 0, 
				     orig_bitmap.getHeight()/2 - orig_bitmap.getWidth()/2,
				     orig_bitmap.getWidth(),
				     orig_bitmap.getWidth() 
				     );
		} else {
			//if width is greater than height - use length size
			  newBmp = Bitmap.createBitmap(
					  orig_bitmap, 
					  orig_bitmap.getWidth()/2 - orig_bitmap.getHeight()/2,
					  0,
					  orig_bitmap.getHeight(), 
					  orig_bitmap.getHeight()
					  );
		}
				
		return newBmp;
	}
	
	/**
	 * Scale image to screen width
	 * @param orig_bitmap
	 * @param board_size
	 * @return
	 */
	private Bitmap scaleImageScreenWidth(Bitmap orig_bitmap, int board_size)
	{
		Bitmap newBmp = null;	
		newBmp =  Bitmap.createScaledBitmap(orig_bitmap, board_size, board_size, true);
		return newBmp;
		
	}

	/**
	 * Split the original image into multiple tiles
	 * @param orig_bitmap - original image
	 * @param matrix_size - matrix size selected by user
	 */
	public ArrayList<Tile> splitIntoTiles(Bitmap orig_bitmap, int matrix_size){
		
		//get tile width
		int tile_width = orig_bitmap.getWidth() / matrix_size; 
		int x_coord, y_coord = 0;
		int multiple = 1;
		
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		
		//loop through the cols
		for(int i = 0; i < matrix_size; i++)
		{
			//loop through the rows
			for(int j = 0; j < matrix_size; j++){
			
				//need to multiply the tile_width for each column tile
				x_coord = tile_width * j;
				
				Bitmap sliced_tile = Bitmap.createBitmap(orig_bitmap, x_coord, y_coord, tile_width, tile_width);
				Tile tile = new Tile(i, sliced_tile ,i, x_coord, y_coord);
				tiles.add(tile);
			}

			y_coord = tile_width * multiple;		
			multiple++;		
		}
		
		return tiles;
		
	}

}

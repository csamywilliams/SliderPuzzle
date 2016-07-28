package com.csaw.sliderpuzzle.image;

import android.graphics.Bitmap;
import android.util.Log;


public class SplitImage {
	
	/**
	 * Split image into to tiles
	 * @param original_image - original bitmap to be split into tiles
	 * @param matrix_size - size of slider puzzle
	 */
	public Bitmap splitImage(Bitmap original_image, int matrix_size, int tileboard_width)
	{
		//convert image into a square image
		Bitmap square_bitmap = makeSquareImage(original_image);
		
		Bitmap scaled_image = scaleImageScreenWidth(square_bitmap, tileboard_width);
		
		//make image fit to device screen
		Log.w("Slider puzzle tile board width ", " "+tileboard_width);
		
		return scaled_image;
		
	}
	
	/**
	 * Make slider puzzle image square to use
	 * @param orig_bitmap - original bitmap before resizing
	 * @return square bitmap
	 */
	private Bitmap makeSquareImage(Bitmap orig_bitmap)
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

}

package com.csaw.sliderpuzzle.image;

import android.graphics.Bitmap;
import android.util.Log;


public class SplitImage {
	
	public void splitImage(Bitmap original_image, int matrix_size)
	{
		//convert image into a square image
		
		makeSquareImage(original_image);
		
	}
	
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

}

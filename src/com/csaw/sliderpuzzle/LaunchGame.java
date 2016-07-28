package com.csaw.sliderpuzzle;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;
/**
 * Launch game activity, will need to split the picture into tiles and display
 * on screen. User will be able to slide the tiles left, right, up and down.
 * Once image is complete will notify user of success.
 * @author Amy Williams 2016
 * @version 1.0
 */
public class LaunchGame extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);    
        setContentView(R.layout.launch_game);
		Toast.makeText(this, "Clicked on Button", Toast.LENGTH_LONG).show();
		
		startGame();
	}
	
	/**
	 * First point of call to start the game
	 */
	public void startGame()
	{
		//todo get with of screen including padding
		//todo check size of image, if rectangle convert to square
		//todo get bitmap of new cropped image
		
		Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.doggy);
			
		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int width = displaymetrics.widthPixels;
		int height = displaymetrics.heightPixels;
		
		Log.w("sliderpuzzle", "width "+width);
		
		Bitmap squareImage = createSquaredBitmap(largeIcon, width);
		
		ImageView testimage = (ImageView)findViewById(R.id.test_image);
		testimage.setImageBitmap(squareImage);
		
	}
	
	private static Bitmap createSquaredBitmap(Bitmap srcBmp, int height) {
        Bitmap dstBmp = Bitmap.createBitmap(height, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(dstBmp);
       
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(srcBmp, (height - srcBmp.getWidth()) / 2, (height - srcBmp.getHeight()) / 2, null);

        return dstBmp;
    }

}

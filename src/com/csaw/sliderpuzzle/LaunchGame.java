package com.csaw.sliderpuzzle;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
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
		
		Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.doggy);
		Bitmap squareImage = createSquaredBitmap(largeIcon);
		
		ImageView testimage = (ImageView)findViewById(R.id.test_image);
		testimage.setImageBitmap(squareImage);
		
	}
	
	private static Bitmap createSquaredBitmap(Bitmap srcBmp) {
        int dim = Math.max(srcBmp.getWidth(), srcBmp.getHeight());
        Bitmap dstBmp = Bitmap.createBitmap(dim, dim, Config.ARGB_8888);

        Canvas canvas = new Canvas(dstBmp);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(srcBmp, (dim - srcBmp.getWidth()) / 2, (dim - srcBmp.getHeight()) / 2, null);

        return dstBmp;
    }

}

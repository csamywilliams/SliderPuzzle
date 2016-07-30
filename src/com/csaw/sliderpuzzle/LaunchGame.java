package com.csaw.sliderpuzzle;

import com.csaw.sliderpuzzle.image.SplitImage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
        Intent intent = getIntent();
        int matrix_size = intent.getIntExtra("matrix_size", 3);
        
		Toast.makeText(this, "Clicked on Button "+matrix_size, Toast.LENGTH_LONG).show();
		
		startGame(matrix_size);
	}
	
	/**
	 * First point of call to start the game
	 */
	public void startGame(int matrix_size)
	{

		Bitmap original_image = BitmapFactory.decodeResource(getResources(), R.drawable.doggy);
			
		DisplayMetrics displayMetrics = getResources().getDisplayMetrics();    
		int tileboard_width = displayMetrics.widthPixels;

		SplitImage imageHelper = new SplitImage();
		Bitmap i =imageHelper.splitImage(original_image, tileboard_width, matrix_size);
		
//			
//		DisplayMetrics displaymetrics = new DisplayMetrics();
//		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
//		int width = displaymetrics.widthPixels;
//		int height = displaymetrics.heightPixels;
//		
//		Log.w("sliderpuzzle", "width "+width);
//		
//		Bitmap squareImage = createSquaredBitmap(largeIcon, width);
//		
		ImageView testimage = (ImageView)findViewById(R.id.test_image);
		testimage.setImageBitmap(i);
		
	}
	
	private static Bitmap createSquaredBitmap(Bitmap srcBmp, int height) {
        Bitmap dstBmp = Bitmap.createBitmap(height, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(dstBmp);
       
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(srcBmp, (height - srcBmp.getWidth()) / 2, (height - srcBmp.getHeight()) / 2, null);

        return dstBmp;
    }

}

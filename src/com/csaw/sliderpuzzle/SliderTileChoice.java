package com.csaw.sliderpuzzle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Activity to allow user to select matrix size currently only allows 3x3 and 4x4 matrix
 * @author Amy Williams
 */
public class SliderTileChoice extends Activity {
	
	protected int MATRIX3 = 3;
	protected int MATRIX4 = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);    
        setContentView(R.layout.slider_tile_choice);
        
        Button matrix3button = (Button) findViewById(R.id.tile_size_3);
        matrix3button.setOnClickListener(new OnClickListener() {

		    public void onClick(View v) {
		    	Intent myIntent = new Intent(SliderTileChoice.this, LaunchGame.class);
		    	myIntent.putExtra("matrix_size", MATRIX3);
		    	SliderTileChoice.this.startActivity(myIntent);
		    }
		});
		
		Button matrix4button = (Button) findViewById(R.id.tile_size_4);
		matrix4button.setOnClickListener(new OnClickListener() {

		    public void onClick(View v) {
		    	Intent myIntent = new Intent(SliderTileChoice.this, LaunchGame.class);
		    	myIntent.putExtra("matrix_size", MATRIX4);
		    	SliderTileChoice.this.startActivity(myIntent);
		    }
		});
		
		
	}
}

package com.csaw.sliderpuzzle;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class LaunchGame extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);    
        setContentView(R.layout.launch_game);
		Toast.makeText(this, "Clicked on Button", Toast.LENGTH_LONG).show();
	}

}

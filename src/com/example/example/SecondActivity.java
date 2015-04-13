/**
 * 
 */
package com.example.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author {Mohammad Abbas Khan}
 * @since 08-Apr-2015
 * @version 1.0
 * 
 */
public class SecondActivity extends Activity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity);
		
		
		Intent intent = getIntent();
		String action = intent.getAction();
		String urlHitByUser = intent.getDataString();
		if (Intent.ACTION_VIEW.equals(action) && urlHitByUser != null) {
		
			//based on urlHitByUser implement your activity specific code here
			//click on link below from your android device/emulator to test app
			//com.example.com/path-seperator1/path-seperator2/aaa
		}
	}

}

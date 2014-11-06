package com.example.snowshreder;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;


public class menu extends Activity{
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }
	
	public void onClickProfile(View view){
		Intent i = new Intent("com.example.snowshreder.users");
		startActivity(i);
	}
	
	public void onClickTracker(View view){
		Intent i = new Intent("com.example.snowshreder.tracker");
		startActivity(i);
	}
	
	public void onClickWall(View view){
		//Intent i = new Intent("com.example.snowshreder.wall");
		//startActivity(i);
	}
	
	public void onClickSetting(View view){
		//Intent i = new Intent("com.example.snowshreder.wall");
		//startActivity(i);
	}
}

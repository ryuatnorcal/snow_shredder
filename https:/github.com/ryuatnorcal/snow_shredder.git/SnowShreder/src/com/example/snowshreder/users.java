package com.example.snowshreder;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.content.Intent;

public class users extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users);
    }
	
	public void onClickBack(View view){
		Intent i = new Intent("com.example.snowshreder.menu");
		startActivity(i);
	}
	
}

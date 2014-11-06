package com.example.snowshreder;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
// more information about mapView 
// https://developers.google.com/maps/documentation/android/v1/hello-mapview
// import com.google.maps.*; // you may need to import google api from version 17 of ADT

public class tracker extends Activity {
	//private static ArrayList<Activity> activities=new ArrayList<Activity>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracker);
    }
	
	public void onClickBack(View view){
		 super.onDestroy();
	//     activities.remove(this);
		Intent i = new Intent("com.example.snowshreder.menu");
		startActivity(i);
	}
	
	// show the map 
	public void onClickMap(View view){
//		String lon = "37.827500";
//		String lat = "-122.481670";
//		String uriStr = "geo:"+lon+","+lat;
		// this intent lunch new map app 
		 Intent i = new Intent("com.example.snowshreder.map");
		 
		 startActivity(i);
	}
}

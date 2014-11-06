package com.example.snowshreder;

//import com.example.dialog.R;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.GoogleMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.location.*;
import android.widget.Toast;

public class map extends FragmentActivity{
	// dialog 
	ProgressDialog progressDialog;
	// class vars 
	boolean isGPSEnable = false;
	boolean isNetworkEnable = false;
	boolean canGetLoaction = false;
	private final Context context = null;
	
	double lon = -122.407496;
	double lat = 37.787941;
	
	// The minimum distance between updates in meters 
	private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters 
	// The minimum time between updates in milliseconds
	private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute
	double cur_sp = 0;
	double cur_alt = 0;
	LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
	Location location;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		location = getLocation();
		// create location instance 
		//LocationManager LocMan = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		//Location location = LocMan.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		
		
		
//		double lat = location.getLatitude();
//		double lng = location.getLatitude();
//		
//		if(location.hasAltitude())
//			cur_alt = location.getAltitude();
//		if(location.hasSpeed())
//			cur_sp = location.getSpeed();
//		
		// here is tips for tracking device
		// there is a stack overflow at http://stackoverflow.com/questions/15641640/how-to-display-a-moving-track-on-android-device
		// method 1 
//		PolylineOptions track = new PolylineOptions();
//		Polyline poly;
//		
//		while (isMoving(lat,lng)) {
//		    LatLng coord = new LatLng(lat,lng);    // from LocationListener
//		    track.add(coord);
//		    if (poly != null) {
//		        poly.remove();
//		    }
//		    poly = this.addPolyline(track);
//		}
	}
	// check if device is moving 
	public boolean isMoving(double lat, double lon){
		// here is GPS tracker class example 
		//http://stackoverflow.com/questions/17519198/how-to-get-the-current-location-latitude-and-longitude-in-android
		
		return true;
	}
	// getLatitude 
	public double getLat(Location location){
		if(location != null)
			return location.getLatitude();
		else 
			return -686;
	}
	
	public double getLon(Location location){
		if(location != null)
			return location.getLongitude();
		else
			return -686;
	}
	
	public double getAltitude(Location location){
		if(location.hasAltitude())
			return location.getAltitude();
		else 
			return -686;
	}
	
	public double getSpeed(Location location){
		if(location.hasSpeed())
			return location.getSpeed();
		else 
			return -686;
	}
	
	public Location getLocation(){
		try{
			locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
			isGPSEnable = locationManager.isProviderEnabled(locationManager.GPS_PROVIDER);
			isNetworkEnable = locationManager.isProviderEnabled(locationManager.NETWORK_PROVIDER);
			if(!isGPSEnable && !isNetworkEnable){
				// no location services are enable 
				showDialog(0);
			}
			else{ // location service is alive !  
				this.canGetLoaction = true;
				if(isNetworkEnable){ // using network to get location information 
					if(locationManager != null){
						location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
						if(location != null){
							lat = location.getLatitude();
							lon = location.getLongitude();
						}
					}
				}
				else if(isGPSEnable){ // GPS service is alive ! 
					location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
					if(location != null){
						lat = location.getLatitude();
						lon = location.getLongitude();
					}					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return location;
	}
	
	public boolean canGetLoaction(){	return this.canGetLoaction;	}
	// show setting dialog 
	public void settingAlert(){
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
		alertDialog.setTitle("GPS setting");
		alertDialog.setMessage("GPS is not enable. Would you like to change setting ? ");
		// if you want to put icon, comment out and put correct path 
		//alertDialog.setIcon(R.drawable.delete);
		
		// when user hit setting 
		alertDialog.setPositiveButton("Setting",
				new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
						context.startActivity(intent);
						
					}
				});
		
		// when user hit cancel 
		alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {	dialog.cancel();	}
		});
	} // end of dialog 
	
	
	// this is dialog setting 
//	 @Override
//	    protected Dialog onCreateDialog(int id){
//	    	switch(id){
//	    	case 0:
//	    		Builder builder = new AlertDialog.Builder(this);
//	    		builder.setIcon(R.drawable.ic_launcher);
//	    		builder.setTitle("Location Service is Disable ....\n Would you like to change the setting ? ");
//	    		builder.setPositiveButton("OK", 
//	    			new DialogInterface.OnClickListener() {
//						public void onClick(DialogInterface dialog, int whichButton) {
//							// launch location setting
//							getLocation();
//						//	Toast.makeText(getBaseContext(), "OK clicked!", Toast.LENGTH_SHORT).show();
//						}
//	    		});
//	    		
//	    		builder.setNegativeButton("Cancel", 
//	    			new DialogInterface.OnClickListener() {
//						public void onClick(DialogInterface dialog, int whichButton) {
//							// do nothing 
//							//Toast.makeText(getBaseContext(), "Cancel clicked!", Toast.LENGTH_SHORT).show();
//						}
//				});
//	    		builder.setMultiChoiceItems(items, itemsChecked,
//	    				new DialogInterface.OnMultiChoiceClickListener() {
//							public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//								Toast.makeText(getBaseContext(), items[which] + (isChecked ? " checked":" unchecked!") , Toast.LENGTH_SHORT).show();	
//							}
//				});
//				return builder.create();
				// end of case 0
//	    	case 1:
//	    		progressDialog = new ProgressDialog(this);
//	    		progressDialog.setIcon(R.drawable.ic_launcher);
//	    		progressDialog.setTitle("Downloading cookies...yum yum! ");
//	    		progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//	    		progressDialog.setButton(DialogInterface.BUTTON_POSITIVE,"OK",
//	    				new DialogInterface.OnClickListener() {
//							
//							@Override
//							public void onClick(DialogInterface dialog, int whichButton) {
//								// TODO Auto-generated method stub
//								Toast.makeText(getBaseContext(), "OK clicked", Toast.LENGTH_SHORT).show();
//							}
//						});
//	    		progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"Cancel",
//	    				new DialogInterface.OnClickListener() {
//							
//							@Override
//							public void onClick(DialogInterface dialog, int whichButton) {
//								// TODO Auto-generated method stub
//								Toast.makeText(getBaseContext(), "Cancel Clicked", Toast.LENGTH_SHORT).show();
//							}
//						});
//	    		return progressDialog;
//	    			
//	    	}
//	    	return null;
//	    }
	
}

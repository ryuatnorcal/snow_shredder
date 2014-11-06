package com.example.snowshreder;

import android.app.Activity;
import io.oauth.*;
public class Auth extends Activity {
	// GLOBAL 
	final OAuth oauth = new OAuth(getBaseContext());
	//oauth.initialize('MLu1O2oTJyoBoTb6-kL5lLhuFXM');
	public static String OAUTH_URL = "https://github.com/login/oauth/authorize";
    public static String OAUTH_ACCESS_TOKEN_URL = "https://github.com/login/oauth/access_token";
	// Facebook 
    public static String FACEBOOK_CLIENT_ID = "YOUR_CLIENT_ID";
    public static String FACEBOOK_CLIENT_SECRET = "YOUR_CLIENT_SECRET";
    public static String FACEBOOK_CALLBACK_URL = "http://localhost";
    
    //Twitter  
 	public static String TWITTER_CLIENT_ID = "YOUR_CLIENT_ID";
 	public static String TWITTER_CLIENT_SECRET = "YOUR_CLIENT_SECRET";
 	public static String TWITTER_CALLBACK_URL = "http://localhost";
 	
 	// GOOGLE 
 	public static String GOOGLE_CLIENT_ID = "YOUR_CLIENT_ID";
 	public static String GOOGLE_CLIENT_SECRET = "YOUR_CLIENT_SECRET";
 	public static String GOOGLE_CALLBACK_URL = "http://localhost";
 	
 	public void facebookAuth(){
 		//oauth.popup("facebook",callback);
 	}
 	
}

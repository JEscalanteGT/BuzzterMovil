package com.buzzter.buzzter.utils;

import java.lang.reflect.Field;

import android.content.Context;
import android.view.ViewConfiguration;

public class ConstantsUtils {
	
	public static final String URL_ROOT_TWITTER_API = "https://api.twitter.com";
	public static final String URL_SEARCH = URL_ROOT_TWITTER_API + "/1.1/search/tweets.json?q=";
	public static final String URL_AUTHENTICATION = URL_ROOT_TWITTER_API + "/oauth2/token";

	public static final String URL_ROOT_API = "http://192.241.160.246/v1";
	public static final String URL_LOGIN = URL_ROOT_API + "/login/";
	
	public static final String TOKEN= "Your Consumer Key";
	
	public static final String MEJORANDROID_TERM = "mejorandroid";
	
	public static final void showOverflowMenu(Context context){
		try {
			ViewConfiguration config = ViewConfiguration.get(context);
			Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
			if (menuKeyField != null) {
				menuKeyField.setAccessible(true);
				menuKeyField.setBoolean(config, false);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

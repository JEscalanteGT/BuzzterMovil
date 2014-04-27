package com.buzzter.buzzter.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManager {
	SharedPreferences pref;
	Editor editor;
	Context context;
	
	private static final String PREF_NAME = "SessionPref";
	public static final String KEY_USERNAME = "username";
	public static final String KEY_NAME = "name";
	public static final String KEY_IMGURL = "imgURL";
	public static final String KEY_ISLOGIN = "isLogin";
	
	public SessionManager(Context _context){
        this.context = _context;
        pref = _context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }
	
	public void createLoginSession(String username, String name, String imgURL){
        editor.putBoolean(KEY_ISLOGIN, true);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_IMGURL, imgURL);
        editor.commit();
    }
	
	public Boolean checkLogin(){
		  return pref.getBoolean(KEY_ISLOGIN, false);
    }
	
	public String getUser(){
		  return pref.getString(KEY_NAME, "NAN");
	}
	
	public void logoutUser(){
        editor.clear();
        editor.commit();
    }
     
}

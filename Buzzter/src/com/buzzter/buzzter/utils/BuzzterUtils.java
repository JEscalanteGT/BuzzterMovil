package com.buzzter.buzzter.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.buzzter.buzzter.models.Usuario;
public class BuzzterUtils {

	public static Usuario appAuthentication(String username, String password, String jsonString){
		JSONObject jsonResponse;
		Usuario usuario = null;
		try {
			jsonResponse = new JSONObject(jsonString);
			JSONObject jsonObject = jsonResponse.getJSONObject("objects");
			usuario = new Usuario();
			usuario.setUsuario_username(jsonObject.getString("username"));
			usuario.setUsuario_nombre(jsonObject.getString("first_name")+ " " + jsonObject.getString("last_name"));
			usuario.setUsuario_imgUrl(jsonObject.getString("fotografia"));
			usuario.setUsuario_isStaff(jsonObject.getBoolean("is_staff"));
			
		} 
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}
	
	public static String readFile(Context context, String file) throws IOException{
		InputStream is = context.getResources().getAssets().open(file);
		char[] buffer = new char[2048];
		Writer writer = new StringWriter();
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
            is.close();
        }
        String text = writer.toString();
        return text;
	}

}

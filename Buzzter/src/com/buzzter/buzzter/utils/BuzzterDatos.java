package com.buzzter.buzzter.utils;

import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;
import com.buzzter.buzzter.models.*;


public class BuzzterDatos {
	
	public BuzzterDatos() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo que obtiene los datos de publicaciones en un archivo JSON
	 * @param JSONData cadena JSON
	 * @return Lista de objetos del tipo publicacion
	 */
	public static ArrayList<Publicacion> getPublicaciones(String JSONData){
		JSONObject objetoJSON;
		ArrayList<Publicacion> publicaciones = new ArrayList();
		JSONObject publicacionTmp=null;
		try {
			objetoJSON = new JSONObject(JSONData.toString());
			JSONObject datos = objetoJSON.getJSONObject("meta");
	    	JSONArray datosPublicaciones =objetoJSON.getJSONArray("objects");
	    	for(int i=0; i<datosPublicaciones.length();i++){
	    		publicacionTmp=datosPublicaciones.getJSONObject(i);
	    		publicaciones.add(new Publicacion(i,null,publicacionTmp.getString("fecha"),
	    				publicacionTmp.getString("tag"),publicacionTmp.getString("titulo"),
	    				publicacionTmp.getString("descripcion"),publicacionTmp.getString("linkImagen"),
	    				publicacionTmp.getString("linkImagen"),Double.parseDouble(publicacionTmp.getString("rating"))));
	    	}
		} catch (JSONException e) {
			e.printStackTrace();
		}
    	return publicaciones;
	}
	
	/**
	 * Metodo que obtiene los datos de comentarios en una cadena JSON
	 * @param JSONData cadena JSON
	 * @return lista de objetos del tipo comentario
	 */
	public static ArrayList<Comentario> getComentarios(String JSONData){
		JSONObject objetoJSON;
		ArrayList<Comentario> comentarios = new ArrayList();
		JSONObject comentarioTmp=null;
		try {
			objetoJSON = new JSONObject(JSONData.toString());
			JSONObject datos = objetoJSON.getJSONObject("meta");
	    	JSONArray datosComentarios =objetoJSON.getJSONArray("objects");
	    	for(int i=0; i<datosComentarios.length();i++){
	    		comentarioTmp=datosComentarios.getJSONObject(i);
	    		comentarios.add(new Comentario(i,comentarioTmp.getString("fecha"),
	    				comentarioTmp.getString("tag"),null));
	    	}
		} catch (JSONException e) {
			e.printStackTrace();
		}
    	return comentarios;
	}
	
	/**
	 * Metodo que determina si hay conexion a internet
	 * @param actividad contexto de la aplicacion
	 * @return true|false
	 */
	public boolean conInternet(Activity actividad){
		ConnectivityManager manager= (ConnectivityManager) actividad.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo estado = manager.getActiveNetworkInfo();
		if(estado!=null && estado.isConnected())
			return true;
		return false;
	}

	/**
	 * Metodo que determina si esta conectado el dispositivo por wifi
	 * @param actividad contexto de la aplicacion
	 * @return true|false
	 */
	public boolean isWifiConnection(Activity actividad) {
		ConnectivityManager cm = (ConnectivityManager) actividad.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		boolean isWifi = networkInfo.isConnected();
		return isWifi;
	}

	public boolean isMobileConnection(Activity actividad) {
		ConnectivityManager cm = (ConnectivityManager) actividad.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		boolean isWifi = networkInfo.isConnected();
		return isWifi;
	}

	/**
	 * 
	 * @param archivo
	 * @param actividad
	 * @return
	 */
	public String leer(String archivo,Activity actividad){  
	  AssetManager assetManager = actividad.getAssets();
	  InputStream inputStream = null;
	  String text="";
	  try {
	   inputStream = assetManager.open( archivo );
	   text = btoString( inputStream );
	  } catch (IOException ex) {
		  Context context = actividad.getApplicationContext();
		  CharSequence texto = ex.getMessage();
		  int duration = Toast.LENGTH_SHORT;
		  Toast toast = Toast.makeText(context, texto, duration);
		  toast.show();
	  }
	  finally{
	   if( inputStream != null )
	   {
	    try{
	     inputStream.close();
	    }
	    catch( IOException ex )
	    {
	    	Context context = actividad.getApplicationContext();
	    	CharSequence texto = ex.getMessage();
	    	int duration = Toast.LENGTH_SHORT;
	    	Toast toast = Toast.makeText(context, texto, duration);
	    	toast.show();
	    }
	   }
	  }
	  return text;
	 }

	 /** Convierte bytes en texto
	 * @param inputStream de tipo InputStream
	 * */
	 public String btoString( InputStream inputStream ) throws IOException
	 {  
	  ByteArrayOutputStream b = new ByteArrayOutputStream();
	  byte[] bytes = new byte[4096];
	  int len=0;  
	  while ( (len=inputStream.read(bytes))>0 )
	  {
	   b.write(bytes,0,len);   
	  }
	  return new String( b.toByteArray(),"UTF8");
	 } 
	
}

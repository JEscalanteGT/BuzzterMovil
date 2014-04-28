package com.buzzter.buzzter.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.buzzter.buzzter.models.Comentario;
import com.buzzter.buzzter.models.Publicacion;
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
	
	public static ArrayList<Publicacion> getTimeline(String username, String jsonString, Boolean opcion){
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		JSONObject jsonResponse;
		try {
			jsonResponse = new JSONObject(jsonString);
			JSONArray jsonArray = jsonResponse.getJSONArray("objects");
			JSONObject jsonObject;

			for (int i = 0; i < jsonArray.length(); i++) {
				jsonObject = (JSONObject) jsonArray.get(i);
				Publicacion publicacion = new Publicacion();
				publicacion.setId(jsonObject.getInt("id"));
				publicacion.setPublicacion_titulo(jsonObject.getString("titulo"));
				publicacion.setPublicacion_descripcion(jsonObject.getString("descripcion"));
				publicacion.setPublicacion_tipo(jsonObject.getString("tags"));
				publicacion.setPublicacion_fecha(jsonObject.getString("fecha"));
				Usuario usuario = new Usuario();
				usuario.setUsuario_username(jsonObject.getString("user"));
				publicacion.setUsuario(usuario);
				publicacion.setPublicacion_numero_comentarios(jsonObject.getInt("comments"));
				publicacion.setPublicacion_rating(jsonObject.getDouble("rating"));
				publicacion.setPublicacion_img_link(jsonObject.getString("linkImagen"));
				publicacion.setPublicacion_link(jsonObject.getString("link"));
				
				publicaciones.add(publicacion);
			}
			
		} 
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return publicaciones;
	}
	
	public static Publicacion getPublicacion(String id, String jsonString, String jsonComentarios){
		Publicacion publicacion = new Publicacion();
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			publicacion.setId(jsonObject.getInt("id"));
			publicacion.setPublicacion_titulo(jsonObject.getString("titulo"));
			publicacion.setPublicacion_descripcion(jsonObject.getString("descripcion"));
			publicacion.setPublicacion_tipo(jsonObject.getString("tags"));
			publicacion.setPublicacion_fecha(jsonObject.getString("fecha"));
			Usuario usuario = new Usuario();
			usuario.setUsuario_username(jsonObject.getString("user"));
			publicacion.setUsuario(usuario);
			publicacion.setPublicacion_numero_comentarios(jsonObject.getInt("comments"));
			publicacion.setPublicacion_rating(jsonObject.getDouble("rating"));
			publicacion.setPublicacion_img_link(jsonObject.getString("linkImagen"));
			publicacion.setPublicacion_link(jsonObject.getString("link"));
			
			publicacion.setPublicacion_comentarios(getComentarios(id, jsonComentarios));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return publicacion;
	}
	
	public static ArrayList<Comentario> getComentarios(String id, String jsonString){
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		JSONObject jsonResponse;
		try {
			jsonResponse = new JSONObject(jsonString);
			Log.d("DEBUG", jsonString+"");
			JSONArray jsonArray = jsonResponse.getJSONArray("objects");
			JSONObject jsonObject;
			
			for (int i = 0; i < jsonArray.length(); i++) {
				jsonObject = (JSONObject) jsonArray.get(i);
				Comentario comentario = new Comentario();
				comentario.setComentario_comentario(jsonObject.getString("comentario"));
				comentario.setComentario_fecha(jsonObject.getString("fecha"));
				Usuario usuario = new Usuario();
				usuario.setUsuario_username(jsonObject.getString("user"));
				comentario.setComentario_usuario(usuario);
				comentarios.add(comentario);
			}
			
		} 
		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comentarios;
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

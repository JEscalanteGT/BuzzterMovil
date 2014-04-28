package com.buzzter.buzzter.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.buzzter.buzzter.models.Publicacion;
import com.buzzter.buzzter.utils.BitmapManager;
import com.buzzter.movil.R;

public class PublicacionesAdapter extends ArrayAdapter<Publicacion> {
	ArrayList<Publicacion> data;
	LayoutInflater inflater;
	
	public PublicacionesAdapter(Context context, ArrayList<Publicacion> objects) {
		super(context, -1, objects);
		this.data = objects;
		this.inflater = LayoutInflater.from(context);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		Publicacion publicacion_actual = data.get(position);
		if(convertView == null){
			convertView = inflater.inflate(R.layout.fragment_publicacion, null);
			
			holder = new ViewHolder();
			holder.img = (ImageView) convertView.findViewById(R.id.img_publicacion_imagen);
			holder.username = (TextView) convertView.findViewById(R.id.txt_publicacion_username);
			holder.tipo = (TextView) convertView.findViewById(R.id.txt_publicacion_tipo);
			holder.tiempo = (TextView) convertView.findViewById(R.id.txt_publicacion_tiempo);
			holder.titulo = (TextView) convertView.findViewById(R.id.txt_publicacion_titulo);
			holder.votos = (TextView) convertView.findViewById(R.id.txt_publicacion_votos);
			holder.comentarios = (TextView) convertView.findViewById(R.id.txt_publicacion_numero_comentarios);
			
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}	
		
		BitmapManager.getInstance().loadBitmap(publicacion_actual.getPublicacion_img_link(), holder.img);
		holder.username.setText(publicacion_actual.getUsuario().getUsuario_username());
		holder.tipo.setText(publicacion_actual.getPublicacion_tag());
		holder.tipo.setBackgroundResource(getTipoBackground(publicacion_actual.getPublicacion_tag()));
		
		holder.tiempo.setText(publicacion_actual.getPublicacion_fecha());
		holder.titulo.setText(publicacion_actual.getPublicacion_titulo());
		holder.comentarios.setText(Integer.toString(publicacion_actual.getPublicacion_numero_comentarios()));
		holder.votos.setText(publicacion_actual.getPublicacion_rating().toString());
		return convertView;
	}

	private int getTipoBackground(String cadena){
		int background = R.drawable.shape;
		if(cadena.equals("musica"))
			background = R.drawable.shape_musica;
		if(cadena.equals("pelicula"))
			background = R.drawable.shape_pelicula;
		if(cadena.equals("art-book"))
			background = R.drawable.shape_artbook;
		if(cadena.equals("poster"))
			background = R.drawable.shape_poster;
		if(cadena.equals("serie"))
			background = R.drawable.shape_serie;
		
		return background;
		
	}
	private static class ViewHolder{
		public ImageView img;
		public TextView username;
		public TextView tipo;
		public TextView tiempo;
		public TextView titulo;
		public TextView votos;
		public TextView comentarios;
	}

}

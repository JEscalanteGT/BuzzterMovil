package com.buzzter.buzzter.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.buzzter.buzzter.models.Comentario;
import com.buzzter.movil.R;

public class ComentariosAdapter extends ArrayAdapter<Comentario> {
	ArrayList<Comentario> data;
	LayoutInflater inflater;
	
	public ComentariosAdapter(Context context, ArrayList<Comentario> objects) {
		super(context, -1, objects);
		this.data = objects;
		this.inflater = LayoutInflater.from(context);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		Comentario comentario_actual = data.get(position);
		if(convertView == null){
			convertView = inflater.inflate(R.layout.fragment_comentario, null);
			
			holder = new ViewHolder();
			holder.img_usuario = (ImageView) convertView.findViewById(R.id.img_comentario_usuario);
			holder.usuario = (TextView) convertView.findViewById(R.id.txt_comentario_usuario);
			holder.fecha = (TextView) convertView.findViewById(R.id.txt_comentario_tiempo);
			holder.comentario = (TextView) convertView.findViewById(R.id.txt_comentario_comentario);
			
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.img_usuario.setImageResource(R.drawable.ic_launcher);
		holder.usuario.setText(comentario_actual.getComentario_usuario().getUsuario_username());
		holder.comentario.setText(comentario_actual.getComentario_comentario());
		holder.fecha.setText(comentario_actual.getComentario_fecha());
		return convertView;
	}

	private static class ViewHolder{
		public ImageView img_usuario;
		public TextView usuario;
		public TextView fecha;
		public TextView comentario;
	}

}

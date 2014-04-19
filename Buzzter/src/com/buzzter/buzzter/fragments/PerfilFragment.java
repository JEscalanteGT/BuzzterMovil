package com.buzzter.buzzter.fragments;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.buzzter.buzzter.PublicacionActivity;
import com.buzzter.buzzter.adapters.PublicacionesAdapter;
import com.buzzter.buzzter.models.Publicacion;
import com.buzzter.buzzter.models.Usuario;
import com.buzzter.movil.R;

public class PerfilFragment extends ListFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_perfil, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		Usuario user = new Usuario("JEscalante","jescalantegt@correo.com", "Jorge Escalante", "", false);
		ViewHolder holder = new ViewHolder();
		holder.username = (TextView) getView().findViewById(R.id.txt_perfil_username);
		holder.nombre = (TextView) getView().findViewById(R.id.txt_perfil_name);
		holder.followers = (TextView) getView().findViewById(R.id.txt_perfil_numero_seguidores);
		holder.following = (TextView) getView().findViewById(R.id.txt_perfil_numero_siguiendo);
		holder.buzzies = (TextView) getView().findViewById(R.id.txt_perfil_numero_buzzies);
		
		holder.username.setText(user.getUsuario_username());
		holder.nombre.setText(user.getUsuario_nombre());
		holder.followers.setText(Integer.toString(user.getUsuario_followers().size()));
		holder.following.setText(Integer.toString(user.getUsuario_following().size()));
		holder.buzzies.setText(Integer.toString(user.getUsuario_publicaciones().size()));
		
		
		int i = 0;
		for(String titulo : getResources().getStringArray(R.array.array_publicaciones)){
			Publicacion publicacion = new Publicacion(i++, user, "28/02/2014", "Pelicula", titulo, "Pequeña Descripcion", "", "http://www.facebook.com", 3.5); 
			publicaciones.add(publicacion);
		}
		
		PublicacionesAdapter adapter = new PublicacionesAdapter(getActivity(), publicaciones);
		setListAdapter(adapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Publicacion publicacion = (Publicacion) l.getItemAtPosition(position);
		Intent intent = new Intent(getActivity(), PublicacionActivity.class);
		intent.putExtra(PublicacionActivity.USERNAME, publicacion.getUsuario().getUsuario_nombre());
		intent.putExtra(PublicacionActivity.TIPO, publicacion.getPublicacion_tag());
		intent.putExtra(PublicacionActivity.TIEMPO, publicacion.getPublicacion_fecha());
		intent.putExtra(PublicacionActivity.TITULO, publicacion.getPublicacion_titulo());
		intent.putExtra(PublicacionActivity.DESCRIPCION, publicacion.getPublicacion_descripcion());
		
		startActivity(intent);
	}
	private static class ViewHolder{
		public ImageView img;
		public TextView username;
		public TextView nombre;
		public TextView followers;
		public TextView following;
		public TextView buzzies;
	}
}

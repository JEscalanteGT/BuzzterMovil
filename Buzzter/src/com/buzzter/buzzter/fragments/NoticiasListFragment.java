package com.buzzter.buzzter.fragments;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.buzzter.buzzter.PublicacionActivity;
import com.buzzter.buzzter.adapters.PublicacionesAdapter;
import com.buzzter.buzzter.models.Publicacion;
import com.buzzter.buzzter.models.Usuario;
import com.buzzter.movil.R;

public class NoticiasListFragment extends ListFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_noticias_list, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		Usuario user = new Usuario("JEscalante","jescalantegt@correo.com", "Jorge Escalante", "", false);
		int i = 0;
		for(String titulo : getResources().getStringArray(R.array.array_publicaciones)){
			Publicacion publicacion = new Publicacion(i++, user, "28/02/2014", "Pelicula", titulo, "Peque�a Descripcion", "", "http://www.facebook.com", 3.5); 
			publicaciones.add(publicacion);
		}
		
		PublicacionesAdapter adapter = new PublicacionesAdapter(getActivity(), publicaciones);
		setListAdapter(adapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Publicacion publicacion = (Publicacion) l.getItemAtPosition(position);
		Intent intent = new Intent(getActivity(), PublicacionActivity.class);
		intent.putExtra(PublicacionActivity.USERNAME, publicacion.getUsuario().getUsuario_username());
		intent.putExtra(PublicacionActivity.TIPO, publicacion.getPublicacion_tag());
		intent.putExtra(PublicacionActivity.TIEMPO, publicacion.getPublicacion_fecha());
		intent.putExtra(PublicacionActivity.TITULO, publicacion.getPublicacion_titulo());
		intent.putExtra(PublicacionActivity.DESCRIPCION, publicacion.getPublicacion_descripcion());
		
		startActivity(intent);
	}
	

}

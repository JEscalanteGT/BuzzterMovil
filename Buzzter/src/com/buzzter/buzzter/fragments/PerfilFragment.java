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
		for(String room : getResources().getStringArray(R.array.array_publicaciones)){
			Publicacion publicacion = new Publicacion("JEscalante","Hace x min", room, "Introduccion a la publicacion" ); 
			publicaciones.add(publicacion);
		}
		
		PublicacionesAdapter adapter = new PublicacionesAdapter(getActivity(), publicaciones);
		setListAdapter(adapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Publicacion publicacion = (Publicacion) l.getItemAtPosition(position);
		Intent intent = new Intent(getActivity(), PublicacionActivity.class);
		intent.putExtra(PublicacionActivity.USERNAME, publicacion.getUsername());
		intent.putExtra(PublicacionActivity.TIPO, publicacion.getPublicacion_tipo());
		intent.putExtra(PublicacionActivity.TIEMPO, publicacion.getPublicacion_fecha());
		intent.putExtra(PublicacionActivity.TITULO, publicacion.getPublicacion_titulo());
		intent.putExtra(PublicacionActivity.DESCRIPCION, publicacion.getPublicacion_titulo());
		
		startActivity(intent);
	}
}

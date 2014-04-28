package com.buzzter.buzzter.fragments;

import java.io.IOException;
import java.util.ArrayList;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.buzzter.buzzter.PublicacionActivity;
import com.buzzter.buzzter.adapters.PublicacionesAdapter;
import com.buzzter.buzzter.database.SessionManager;
import com.buzzter.buzzter.models.Publicacion;
import com.buzzter.buzzter.models.Usuario;
import com.buzzter.buzzter.utils.BuzzterUtils;
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
		Usuario user = new Usuario("JEscalante","jescalantegt@correo.com", "Jorge Escalante", "", false);
		ViewHolder holder = new ViewHolder();
		holder.username = (TextView) getView().findViewById(R.id.txt_perfil_username);
		holder.nombre = (TextView) getView().findViewById(R.id.txt_perfil_name);
		holder.followers = (TextView) getView().findViewById(R.id.txt_perfil_numero_seguidores);
		holder.following = (TextView) getView().findViewById(R.id.txt_perfil_numero_siguiendo);
		holder.buzzies = (TextView) getView().findViewById(R.id.txt_perfil_numero_buzzies);
		
		holder.username.setText(user.getUsuario_username());
		holder.nombre.setText(user.getUsuario_nombre());
		holder.followers.setText(Integer.toString(0));
		holder.following.setText(Integer.toString(0));
		holder.buzzies.setText(Integer.toString(user.getUsuario_publicaciones().size()));
		
		String json = "";
		try {
			json = BuzzterUtils.readFile(getActivity(), "timeline.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SessionManager session = new SessionManager(getActivity().getApplicationContext());
		new TimelineSearchTask().execute(session.getUser(), json);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Publicacion publicacion = (Publicacion) l.getItemAtPosition(position);
		Intent intent = new Intent(getActivity(), PublicacionActivity.class);
		intent.putExtra(PublicacionActivity.IDPUBLICACION, publicacion.getId());
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
	
	private void updateListView(ArrayList<Publicacion> publicaciones){
		if(publicaciones != null){
			setListAdapter(new PublicacionesAdapter(getActivity(), publicaciones));
		}
		
	}
	
	class TimelineSearchTask extends AsyncTask<String, Void, ArrayList<Publicacion>>{
    	
		String username, password, jsonString;
		private ProgressDialog progressDialog;
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progressDialog = new ProgressDialog(getActivity());
			progressDialog.setMessage(getResources().getString(R.string.timeline_cargando_posts));
			progressDialog.show();
		}

		@Override
		protected ArrayList<Publicacion> doInBackground(String... params) {
			// TODO Auto-generated method stub
			username = params[0];
			jsonString = params[1];
			ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
			publicaciones = BuzzterUtils.getTimeline(username, jsonString, false);
			
			return publicaciones;
		}
		
		@Override
		protected void onPostExecute(ArrayList<Publicacion> publicaciones) {
			// TODO Auto-generated method stub
			progressDialog.dismiss();

			if (publicaciones.isEmpty()) {
				Toast.makeText(getActivity(), getResources().getString(R.string.timeline_cargando_posts),
						Toast.LENGTH_SHORT).show();
			} else {
				updateListView(publicaciones);
			}
				
		}
		
	}
}

package com.buzzter.buzzter;

import java.io.IOException;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.buzzter.buzzter.fragments.CommentFragment;
import com.buzzter.buzzter.models.Comentario;
import com.buzzter.buzzter.models.Publicacion;
import com.buzzter.buzzter.utils.BitmapManager;
import com.buzzter.buzzter.utils.BuzzterUtils;
import com.buzzter.movil.R;

public class PublicacionActivity extends ActionBarActivity {

	public static final String USERNAME = "USERNAME";
	public static final String IDPUBLICACION = "IDPUBLICACION";
	private TextView txtUsername, txtTipo, txtTiempo, txtTitulo, txtDescripcion, txtVotos;
	private ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_publicacion);

		txtUsername = (TextView) this.findViewById(R.id.txt_publicacion_detail_username);
		txtTipo = (TextView) this.findViewById(R.id.txt_publicacion_detail_tipo);
		txtTiempo = (TextView) this.findViewById(R.id.txt_publicacion_detail_tiempo);
		txtTitulo = (TextView) this.findViewById(R.id.txt_publicacion_detail_titulo);
		txtDescripcion = (TextView) this.findViewById(R.id.txt_publicacion_detail_descripcion);
		txtVotos = (TextView) this.findViewById(R.id.txt_publicacion_detail_votos);
		img = (ImageView) this.findViewById(R.id.img_publicacion_detail_imagen);
		
		Intent intent = getIntent();
		String json = "";
		String json2 = "";
		try {
			json = BuzzterUtils.readFile(getApplicationContext(), "publicacion.json");
			json2 = BuzzterUtils.readFile(getApplicationContext(), "comentarios.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		new PublicacionTask().execute(intent.getStringExtra(IDPUBLICACION), json, json2);
	}
	
	public void setContent(Publicacion publicacion){
		BitmapManager.getInstance().loadBitmap(publicacion.getPublicacion_img_link(), img);
		txtTitulo.setText(publicacion.getPublicacion_titulo());
		txtTipo.setText(publicacion.getPublicacion_tag());
		txtTipo.setBackgroundResource(getTipoBackground(publicacion.getPublicacion_tag()));
		txtTiempo.setText(publicacion.getPublicacion_fecha());
		txtUsername.setText(publicacion.getUsuario().getUsuario_username());
		txtDescripcion.setText(publicacion.getPublicacion_descripcion());
		txtVotos.setText(Double.toString(publicacion.getPublicacion_rating()));
		
		for(int i=0; i < publicacion.getPublicacion_comentarios().size(); i++){
			Comentario comentario = publicacion.getPublicacion_comentarios().get(i);
			
			FragmentManager fragmentManager = getSupportFragmentManager();
	        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
	        CommentFragment nuevo = new CommentFragment(comentario);
	        fragmentTransaction.add(R.id.list_comentarios, nuevo);
	        fragmentTransaction.commit();
			
		}
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
		if(cadena.equals("series"))
			background = R.drawable.shape_serie;
		
		return background;
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
class PublicacionTask extends AsyncTask<String, Void, Publicacion>{
    	
		String idpublicacion, jsonString, jsonComentarios;
		private ProgressDialog progressDialog;
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progressDialog = new ProgressDialog(PublicacionActivity.this);
			progressDialog.setMessage(getResources().getString(R.string.timeline_cargando_posts));
			progressDialog.show();
		}

		@Override
		protected Publicacion doInBackground(String... params) {
			// TODO Auto-generated method stub
			idpublicacion = params[0];
			jsonString = params[1];	
			jsonComentarios = params[2];
			Publicacion publicacion = BuzzterUtils.getPublicacion(idpublicacion, jsonString, jsonComentarios);
			return publicacion;
		}
		
		@Override
		protected void onPostExecute(Publicacion publicacion) {
			// TODO Auto-generated method stub
			progressDialog.dismiss();

			if (publicacion == null) {
				Toast.makeText(getApplicationContext(), getResources().getString(R.string.timeline_cargando_posts),
						Toast.LENGTH_SHORT).show();
			} else {
				setContent(publicacion);
			}
				
		}
		
	}
}

package com.buzzter.buzzter;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

import com.buzzter.buzzter.adapters.ComentariosAdapter;
import com.buzzter.buzzter.models.Comentario;
import com.buzzter.buzzter.models.Usuario;
import com.buzzter.movil.R;

public class PublicacionActivity extends ActionBarActivity {

	public static final String USERNAME = "USERNAME";
	public static final String TIPO = "TIPO";
	public static final String TIEMPO = "TIEMPO";
	public static final String TITULO = "TITULO";
	public static final String DESCRIPCION = "DESCRIPCION";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_publicacion);
		
		TextView txtUsername = (TextView) this.findViewById(R.id.txt_publicacion_detail_username);
		TextView txtTipo = (TextView) this.findViewById(R.id.txt_publicacion_detail_tipo);
		TextView txtTiempo = (TextView) this.findViewById(R.id.txt_publicacion_detail_tiempo);
		TextView txtTitulo = (TextView) this.findViewById(R.id.txt_publicacion_detail_titulo);
		TextView txtDescripcion = (TextView) this.findViewById(R.id.txt_publicacion_detail_descripcion);
		
		Intent intent = getIntent();
		txtUsername.setText(intent.getStringExtra(USERNAME));
		txtTipo.setText(intent.getStringExtra(TIPO));
		txtTiempo.setText(intent.getStringExtra(TIEMPO));
		txtTitulo.setText(intent.getStringExtra(TITULO));
		txtDescripcion.setText(intent.getStringExtra(DESCRIPCION));
		
		Usuario user = new Usuario("JEscalante","jescalantegt@correo.com", "Jorge Escalante", "", false);
		
		ListView list = (ListView) this.findViewById(R.id.list_publicacion_detail_comentarios);
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		for(int i=0; i<10; i++)
			comentarios.add(new Comentario(i,"12/03/2014", "Comentario peque�o", user));
		ComentariosAdapter adapter = new ComentariosAdapter(this, comentarios);
		list.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

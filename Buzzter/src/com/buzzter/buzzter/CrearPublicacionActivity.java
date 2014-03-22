package com.buzzter.buzzter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.buzzter.movil.R;

public class CrearPublicacionActivity extends Activity{
		private Button Publicar;
	    private EditText Titulo;
	    private EditText Descripcion_primaria;
	    private EditText Descripcion_secundaria;
	    private Spinner Tipo;
	    private TextView Error;
	    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_crear_publicacion);	        
	        
	        Titulo = (EditText) findViewById(R.id.Publicacion_Titulos);
	         Descripcion_primaria = (EditText) findViewById(R.id.Publicacion_descripcion_principal);
	        Descripcion_secundaria = (EditText) findViewById(R.id.Publicacion_Descripcion_secundaria);
	       Tipo = (Spinner) findViewById(R.id.Publicacion_Tipo);
	        
	        Publicar = (Button) findViewById(R.id.Publicacion_Publicar);
	        Error = (TextView) findViewById(R.id.Publicacion_Error);
	        
	        Publicar.setOnClickListener(new View.OnClickListener() {
	        	@Override
	        	public void onClick(View view) {
	               String titulo = Titulo.getText().toString();
	                String desc1 = Descripcion_primaria.getText().toString();
	                String desc2 = Descripcion_secundaria.getText().toString();
	                String tipo = Tipo.getSelectedItem().toString();
	                
	                if( titulo==null && desc1== null && desc2==null && tipo==null)
						Error.setText("Todos los campos son requeridos");
	                else{
	                	Error.setText("publicacion exitoso!");
	                	Intent itemintent = new Intent(CrearPublicacionActivity .this, MainActivity.class);
	                	CrearPublicacionActivity.this.startActivity(itemintent);
	                	}
	               
	                
	             }
	        });
	        
	 }


}

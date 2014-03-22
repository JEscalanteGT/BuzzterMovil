package com.buzzter.buzzter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.buzzter.movil.R;

public class RegistroActivity extends Activity{
	

	    private Button Registrarse;
	    private EditText Nombre;
	    private EditText Email;
	    private EditText Password;
	    private EditText ConfPassword;
	    private TextView Error;
	    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_registro);
	        
	        Nombre = (EditText) findViewById(R.id.textView1);
	        Email = (EditText) findViewById(R.id.Publicacion_descripcion_principal);
	        Password = (EditText) findViewById(R.id.Publicacion_Descripcion_secundaria);
	        ConfPassword = (EditText) findViewById(R.id.Crear_Repetir_Password);
	        
	        Registrarse = (Button) findViewById(R.id.Registrarse);
	        Error = (TextView) findViewById(R.id.Registro_Error);
	        
	        Registrarse.setOnClickListener(new View.OnClickListener() {
	        	@Override
	        	public void onClick(View view) {
	                String nombre = Nombre.getText().toString();
	                String email = Email.getText().toString();
	                String pass = Password.getText().toString();
	                String confpass = ConfPassword.getText().toString();
	                if(nombre==null && email== null && pass==null && confpass=="")
						Error.setText("Todos los campos son requeridos");
	                if(pass.equals(confpass)){
	                	Error.setText("Registro exitoso!");
	                	Intent itemintent = new Intent(RegistroActivity.this, LoginActivity.class);
	                	RegistroActivity.this.startActivity(itemintent);
	                	}
	                else{
	                	Error.setText("Las contraseñas no conciden");
	                }
	                
	             }
	        });   
	        
	 }



}

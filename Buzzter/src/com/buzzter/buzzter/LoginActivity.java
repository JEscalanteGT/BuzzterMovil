package com.buzzter.buzzter;



import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.buzzter.buzzter.models.Usuario;
import com.buzzter.buzzter.utils.BuzzterUtils;
import com.buzzter.movil.R;

public class LoginActivity extends Activity {

	    private Button Iniciarsesion;
	    private EditText Usuario;
	    private EditText Password;
	    private CheckedTextView Registro;
	    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_login);
	        
	        Usuario = (EditText) findViewById(R.id.Usuario);
	        Password = (EditText) findViewById(R.id.Password);
	        Iniciarsesion = (Button) findViewById(R.id.Iniciarsesion);
	        Registro = (CheckedTextView) findViewById(R.id.Registro);
	       
	        
	        Linkify.addLinks(Registro, Linkify.ALL);
	        
	        Iniciarsesion.setOnClickListener(new View.OnClickListener() {
	        	@Override
	        	public void onClick(View view) {
	                String usuario = Usuario.getText().toString();
	                String password = Password.getText().toString();
	                String mensaje = "";
					try {
						mensaje = BuzzterUtils.readFile(getApplicationContext(), "login.json");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}          
					new AsyncLogin().execute(usuario,password,mensaje);
	                
	                if(usuario.equals("root")&& password.equals("1234")){
	                	Intent itemintent = new Intent(LoginActivity.this, MainActivity.class);
	                	LoginActivity.this.startActivity(itemintent);
	                	}
	                }
	        });   
	        
	        Registro.setOnClickListener(new View.OnClickListener() {
	        	   @Override
	        	   public void onClick(View v) {
	        		   Intent itemintent = new Intent(LoginActivity.this, RegistroActivity.class);
	        		   LoginActivity.this.startActivity(itemintent);
	        	  }
	       });
	 }
	    
	 public void mensaje(String mensaje){
		 Toast toast1 = Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG);
         toast1.show();
	 }
	 
	 
	 class AsyncLogin extends AsyncTask<String, Void, Usuario>{

			String username, password, jsonString;
			@Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
				super.onPreExecute();
			}

			@Override
			protected Usuario doInBackground(String... params) {
				// TODO Auto-generated method stub
				username = params[0];
				password = params[1];
				jsonString = params[2];
				Usuario usuario = BuzzterUtils.appAuthentication(username, password, jsonString);
				return usuario;
			}
			
			@Override
			protected void onPostExecute(Usuario usuario) {
				// TODO Auto-generated method stub
				if(usuario == null){
					mensaje("Login Fail!");
				}
				else{
					mensaje("Login correcto!");
				}
					
			}
			
		}
}
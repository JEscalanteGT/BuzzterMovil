package com.buzzter.buzzter;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
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
}

package com.buzzter.buzzter.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.buzzter.buzzter.models.Comentario;
import com.buzzter.movil.R;

public class CommentFragment extends Fragment {
	Comentario comentario;
    public CommentFragment(Comentario comentario) {
        this.comentario = comentario;
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_comentario, null);
		TextView usuario = (TextView) v.findViewById(R.id.txt_comentario_usuario);
		TextView fecha = (TextView) v.findViewById(R.id.txt_comentario_tiempo);
		TextView comentario = (TextView) v.findViewById(R.id.txt_comentario_comentario);
		
		usuario.setText(this.comentario.getComentario_usuario().getUsuario_username());
		fecha.setText(this.comentario.getComentario_fecha());
		comentario.setText(this.comentario.getComentario_comentario());
        return v;
		
	}
}

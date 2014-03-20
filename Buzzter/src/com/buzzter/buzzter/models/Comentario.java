package com.buzzter.buzzter.models;

public class Comentario {
	private int id;
	private String comentario_fecha;
	private String comentario_comentario;
	private Usuario comentario_usuario;
	public Comentario(int id, String fecha, String comentario, Usuario usuario){
		this.setId(id);
		this.comentario_fecha = fecha;
		this.comentario_comentario = comentario;
		this.comentario_usuario = usuario;
	}
	public String getComentario_fecha() {
		return comentario_fecha;
	}
	public void setComentario_fecha(String comentario_fecha) {
		this.comentario_fecha = comentario_fecha;
	}
	public String getComentario_comentario() {
		return comentario_comentario;
	}
	public void setComentario_comentario(String comentario_comentario) {
		this.comentario_comentario = comentario_comentario;
	}
	public Usuario getComentario_usuario() {
		return comentario_usuario;
	}
	public void setComentario_usuario(Usuario comentario_usuario) {
		this.comentario_usuario = comentario_usuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}

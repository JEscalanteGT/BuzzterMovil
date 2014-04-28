package com.buzzter.buzzter.models;

import java.util.ArrayList;

public class Publicacion {
	private int id;
	private Usuario usuario;
	private String publicacion_titulo;
	private String publicacion_descripcion;
	private String publicacion_fecha;
	private String publicacion_tag;
	private String publicacion_img_link;
	private String publicacion_link;
	private Double publicacion_rating;
	private int publicacion_numero_comentarios;
	private ArrayList<Comentario> publicacion_comentarios;
	public Publicacion(){
		
		this.publicacion_comentarios = new ArrayList<Comentario>();
	}
	public Publicacion(int id, Usuario usuario, String fecha, String tag,String titulo, String descripcion, String img_link, String link, Double rating){
		this.id = id;
		this.usuario = usuario;
		this.publicacion_fecha = fecha;
		this.publicacion_titulo = titulo;
		this.publicacion_descripcion = descripcion;
		this.publicacion_tag = tag;
		this.setPublicacion_img_link(img_link);
		this.publicacion_link = link;
		this.publicacion_rating = rating;
		this.publicacion_comentarios = new ArrayList<Comentario>();
	}
	public String getPublicacion_titulo() {
		return publicacion_titulo;
	}
	public void setPublicacion_titulo(String publicacion_titulo) {
		this.publicacion_titulo = publicacion_titulo;
	}
	public String getPublicacion_descripcion() {
		return publicacion_descripcion;
	}
	public void setPublicacion_descripcion(String publicacion_descripcion) {
		this.publicacion_descripcion = publicacion_descripcion;
	}
	public String getPublicacion_fecha() {
		return publicacion_fecha;
	}
	public void setPublicacion_fecha(String publicacion_fecha) {
		this.publicacion_fecha = publicacion_fecha;
	}
	public String getPublicacion_tag() {
		return publicacion_tag;
	}
	public void setPublicacion_tipo(String publicacion_tipo) {
		this.publicacion_tag = publicacion_tipo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario username) {
		this.usuario = username;
	}
	public String getPublicacion_link() {
		return publicacion_link;
	}
	public void setPublicacion_link(String publicacion_link) {
		this.publicacion_link = publicacion_link;
	}
	public Double getPublicacion_rating() {
		return publicacion_rating;
	}
	public void setPublicacion_rating(Double publicacion_rating) {
		this.publicacion_rating = publicacion_rating;
	}
	public ArrayList<Comentario> getPublicacion_comentarios() {
		return publicacion_comentarios;
	}
	public void setPublicacion_comentarios(ArrayList<Comentario> publicacion_comentarios) {
		this.publicacion_comentarios = publicacion_comentarios;
	}
	public String getPublicacion_img_link() {
		return publicacion_img_link;
	}
	public void setPublicacion_img_link(String publicacion_img_link) {
		this.publicacion_img_link = publicacion_img_link;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPublicacion_numero_comentarios() {
		return publicacion_numero_comentarios;
	}
	public void setPublicacion_numero_comentarios(
			int publicacion_numero_comentarios) {
		this.publicacion_numero_comentarios = publicacion_numero_comentarios;
	}
}

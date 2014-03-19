package com.buzzter.buzzter.models;

public class Publicacion {
	public final static String PUBLICACION_MUSICA = "Musica";
	public final static String PUBLICACION_PELICULA = "Pelicula";
	private String username;
	private String publicacion_titulo;
	private String publicacion_descripcion;
	private String publicacion_fecha;
	private String publicacion_tipo;
	public Publicacion(String username, String fecha,String publicacion_titulo, String publicacion_descripcion){
		this.username = username;
		this.publicacion_fecha = fecha;
		this.publicacion_titulo = publicacion_titulo;
		this.publicacion_descripcion = publicacion_descripcion;
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
	public String getPublicacion_tipo() {
		return publicacion_tipo;
	}
	public void setPublicacion_tipo(String publicacion_tipo) {
		this.publicacion_tipo = publicacion_tipo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}

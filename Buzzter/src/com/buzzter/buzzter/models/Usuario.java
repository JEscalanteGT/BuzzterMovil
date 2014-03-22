package com.buzzter.buzzter.models;

import java.util.ArrayList;

public class Usuario {
	private int id;
	private String usuario_username;
	private String usuario_email;
	private String usuario_nombre;
	private String usuario_pais;
	private String usuario_imgUrl;
	private ArrayList<Usuario> usuario_followers;
	private ArrayList<Usuario> usuario_following;
	private ArrayList<Publicacion> usuario_publicaciones;
	public Usuario(int id, String username, String email, String nombre, String imgUrl){
		this.id = id;
		this.usuario_username = username;
		this.usuario_email = email;
		this.usuario_nombre = nombre;
		this.usuario_imgUrl = imgUrl;
		this.usuario_followers = new ArrayList<Usuario>();
		this.usuario_following = new ArrayList<Usuario>();
		this.usuario_publicaciones = new ArrayList<Publicacion>();
	}
	public String getUsuario_username() {
		return usuario_username;
	}
	public void setUsuario_username(String usuario_username) {
		this.usuario_username = usuario_username;
	}
	public String getUsuario_email() {
		return usuario_email;
	}
	public void setUsuario_email(String usuario_email) {
		this.usuario_email = usuario_email;
	}
	public String getUsuario_nombre() {
		return usuario_nombre;
	}
	public void setUsuario_nombre(String usuario_nombre) {
		this.usuario_nombre = usuario_nombre;
	}
	public String getUsuario_pais() {
		return usuario_pais;
	}
	public void setUsuario_pais(String usuario_pais) {
		this.usuario_pais = usuario_pais;
	}
	public String getUsuario_imgUrl() {
		return usuario_imgUrl;
	}
	public void setUsuario_imgUrl(String usuario_imgUrl) {
		this.usuario_imgUrl = usuario_imgUrl;
	}
	public ArrayList<Usuario> getUsuario_followers() {
		return usuario_followers;
	}
	public void setUsuario_followers(ArrayList<Usuario> usuario_followers) {
		this.usuario_followers = usuario_followers;
	}
	public ArrayList<Usuario> getUsuario_following() {
		return usuario_following;
	}
	public void setUsuario_following(ArrayList<Usuario> usuario_following) {
		this.usuario_following = usuario_following;
	}
	public ArrayList<Publicacion> getUsuario_publicaciones() {
		return usuario_publicaciones;
	}
	public void setUsuario_publicaciones(ArrayList<Publicacion> usuario_publicaciones) {
		this.usuario_publicaciones = usuario_publicaciones;
	}
	public void add_follower(Usuario usuario){
		this.usuario_followers.add(usuario);
	}
	public void add_following(Usuario usuario){
		this.usuario_following.add(usuario);
	}
	public void add_publicacion(Publicacion publicacion){
		this.usuario_publicaciones.add(publicacion);
	}
}
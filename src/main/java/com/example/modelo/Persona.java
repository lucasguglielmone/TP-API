package com.example.modelo;

import views.PersonaView;

@Entity
@Table(name = "personas")
public class Persona {
	@Id
	@Column
	private String documento;
	@Column
	private String nombre;
	@Column
	private String mail;
	@Column
	private String contrasenia;
	
	public Persona(String documento, String nombre, String mail, String contrasenia) {
		this.documento = documento;
		this.nombre = nombre;
		this.mail = mail;
		this.contrasenia = contrasenia;
	}

	public void cambiarPassword(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public String getDocumento() {
		return documento;
	}

	public String getNombre() {
		return nombre;
	}

	
	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return contrasenia;
	}

	public PersonaView toView() {
		return new PersonaView(documento, nombre);
	}
}

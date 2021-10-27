package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paciente")

public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idpaciente;
	@Column(name="dni")
	private String dni;
	@Column(name="nombres")
	private String nombres;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="telefono")
	private String telefono;
	
	
	public Paciente() {
		super();
	}


	public Paciente(long idpaciente, String dni, String nombres, String apellidos, String telefono) {
		super();
		this.idpaciente = idpaciente;
		this.dni = dni;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}


	public long getIdpaciente() {
		return idpaciente;
	}


	public void setIdpaciente(long idpaciente) {
		this.idpaciente = idpaciente;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	
	

}

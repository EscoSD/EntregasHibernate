package com.esco.entidades;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "generos")
public class Genero implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String nombre;

	public Genero() {
	}

	public Genero(String name) {
		this.nombre = name;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String name) {
		this.nombre = name;
	}
}

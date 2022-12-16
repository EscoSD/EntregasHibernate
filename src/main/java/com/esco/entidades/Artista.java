package com.esco.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String nombre;

	@Column
	private int edad;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "artista")
	private List<Instrumento> instrumentos;

	// Propietario de la relación con Tienda
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_Tienda", referencedColumnName = "id")
	private Tienda tienda;

	// Propietario de la relación con Género
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "FK_Género", referencedColumnName = "id")
	private Genero genero;

	public Artista() {
	}

	public Artista(String nombre, int edad, List<Instrumento> instrumentos, Tienda tienda, Genero genero) {
		this.nombre = nombre;
		this.edad = edad;
		this.instrumentos = instrumentos;
		this.tienda = tienda;
		this.genero = genero;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public List<Instrumento> getInstrumentos() {
		return instrumentos;
	}

	public void setInstrumentos(List<Instrumento> instrumentos) {
		this.instrumentos = instrumentos;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}

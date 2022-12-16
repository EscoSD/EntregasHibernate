package com.esco.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorColumn(name = "categoría", discriminatorType = DiscriminatorType.STRING)
public abstract class Instrumento implements Serializable {

	public enum Tipo {
		Pulsada, Frotada, Percutida, Metal, Madera, Membranofono, Idiofono
		// Las dos últimas llevan tilde pero no me gusta poner tildes a variables por si da problemas
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String nombre;

	@Column
	private double precio;

	@Column
	private String tipo;

	@ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "instrumentos")
	private List<Tienda> tiendas;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_Artista", referencedColumnName = "id")
	private Artista artista;

	public Instrumento() {}

	public Instrumento(String nombre, double precio, String tipo, List<Tienda> tiendas, Artista artista) {
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
		this.tiendas = tiendas;
		this.artista = artista;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(List<Tienda> tiendas) {
		this.tiendas = tiendas;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
}

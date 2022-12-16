package com.esco.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
@DiscriminatorValue(value = "VIENTO")
public class Viento extends Instrumento {

	@Column
	private int longitud;

	public Viento() {
		super();
	}

	public Viento(String nombre, double precio, String tipo, int longitud, List<Tienda> tiendas, Artista artista) {
		super(nombre, precio, tipo, tiendas, artista);
		this.longitud = longitud;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
}

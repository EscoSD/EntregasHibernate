package com.esco.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
@DiscriminatorValue(value = "CUERDA")
public class Cuerda extends Instrumento {

	@Column
	private int cuerdas;

	public Cuerda() {
		super();
	}

	public Cuerda(String nombre, double precio, String tipo, int cuerdas, List<Tienda> tiendas, Artista artista) {
		super(nombre, precio, tipo, tiendas, artista);
		this.cuerdas = cuerdas;
	}

	public int getCuerdas() {
		return cuerdas;
	}

	public void setCuerdas(int cuerdas) {
		this.cuerdas = cuerdas;
	}
}

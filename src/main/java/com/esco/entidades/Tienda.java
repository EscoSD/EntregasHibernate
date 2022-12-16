package com.esco.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tiendas")
public class Tienda implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String nombre;

	@Column(name = "dirección")
	private String direc;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "instrumento_tienda",
		joinColumns = {@JoinColumn(name = "FK_Tienda", referencedColumnName = "id")},
		inverseJoinColumns = {@JoinColumn(name = "FK_Instrumento", referencedColumnName = "id")})
	private List<Instrumento> instrumentos;

	@OneToOne(cascade = CascadeType.PERSIST, mappedBy = "tienda")
	private Artista artista;

	public Tienda() {
	}

	public Tienda(String nombre, String direc, List<Instrumento> instrumentos, Artista artista) {
		this.nombre = nombre;
		this.direc = direc;
		this.instrumentos = instrumentos;
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

	public String getDirec() {
		return direc;
	}

	public void setDirec(String direc) {
		this.direc = direc;
	}

	public List<Instrumento> getInstrumentos() {
		return instrumentos;
	}

	public void setInstrumentos(List<Instrumento> instrumentos) {
		this.instrumentos = instrumentos;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
}

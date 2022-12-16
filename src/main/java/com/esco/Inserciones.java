package com.esco;

import com.esco.entidades.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Inserciones {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// Creación de objetos género
		Genero jazz = new Genero("Jazz");
		Genero house = new Genero("House");
		Genero drAndBss = new Genero("Drum and Bass");

		// Creación de objetos artista
		Artista artista1 = new Artista("Sebastián", 20, null, null, jazz);
		Artista artista2 = new Artista("Mejillón", 32, null, null, drAndBss);
		Artista artista3 = new Artista("Pablofiestas", 25, null, null, house);

		// Creación de objetos instrumento
		Instrumento instrumento1 = new Cuerda("Guitarra", 499.50, Instrumento.Tipo.Pulsada.name(), 6, null, artista3);
		Instrumento instrumento2 = new Cuerda("Violín", 655.75, Instrumento.Tipo.Frotada.name(), 4, null, artista1);
		Instrumento instrumento3 = new Cuerda("Piano", 999.99, Instrumento.Tipo.Percutida.name(), 230, null, artista2);

		Instrumento instrumento4 = new Viento("Saxofón", 99.55, Instrumento.Tipo.Madera.name(), 40, null, artista3);
		Instrumento instrumento5 = new Viento("Tuba", 324.99, Instrumento.Tipo.Metal.name(), 6, null, artista2);
		Instrumento instrumento6 = new Viento("Ocarina", 5, Instrumento.Tipo.Madera.name(), 500, null, artista1);

		// ArrayList contenedor de todos los instrumentos
		ArrayList<Instrumento> instrumentos = new ArrayList<>(
				List.of(new Instrumento[]{instrumento1, instrumento2, instrumento3, instrumento4, instrumento5, instrumento6})
		);

		// Creación de objetos tienda
		Tienda tienda1 = new Tienda("Música paco", "España", instrumentos, artista1);
		Tienda tienda2 = new Tienda("Soundsation", "Andorra", instrumentos, artista2);
		Tienda tienda3 = new Tienda("Sonorama", "Argentina", instrumentos, artista3);

		// ArrayList contenedor de todas las tiendas
		ArrayList<Tienda> tiendas = new ArrayList<>(
				List.of(new Tienda[]{tienda1, tienda2, tienda3})
		);

		// Añadimos las tiendas a sus artistas
		artista1.setTienda(tienda1);
		artista2.setTienda(tienda2);
		artista3.setTienda(tienda3);

		/* Tan solo es necesario persistir las tiendas,
		   ya que estas contienen tanto los instrumentos como los artistas,
		   y a su vez, los artistas contienen los géneros,
		   por lo que todos los objetos son almacenados en la base de datos*/
		for (Tienda tienda: tiendas)
			session.persist(tienda);

		transaction.commit();
		session.close();
	}
}

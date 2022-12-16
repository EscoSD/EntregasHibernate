package com.esco;

import com.esco.entidades.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Consultas {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		// Consulta para obtener artistas, sus géneros y sus instrumentos
		System.out.println("\nArtistas registrados en la base de datos, su género musical y sus instrumentos.-");

		Query<Object[]> artistasInst = session.createQuery("SELECT A.nombre, G.nombre, I.nombre FROM Artista A, Genero G, Instrumento I " +
				"WHERE A.id = I.artista.id AND A.genero.id = G.id");
		List<Object[]> list1 = artistasInst.list();

		for (int i = 0; i < list1.size(); i++) {
			if (i%2 == 0)
				System.out.print("\n" + list1.get(i)[0] + ".- " + list1.get(i)[1] + "\n\t");
			System.out.print(list1.get(i)[2] + " ");
		}

		// Consulta para obtener las tiendas y sus artistas propietarios
		System.out.println("\n\nTiendas registradas en la base de datos y sus artistas propietarios.-");

		Query<Object[]> tiendasArts = session.createQuery("SELECT T.nombre, A.nombre FROM Artista A, Tienda T WHERE T.id = A.tienda.id");
		List<Object[]> list2 = tiendasArts.list();

		for (Object[] array: list2)
			System.out.print("\n" + array[0] + ".- " + array[1]);

		// Consulta para obtener el artista con mas edad
		System.out.print("\n\nArtista con mas edad.- ");

		Query<Artista> artistaMayor = session.createQuery("FROM Artista A WHERE A.edad = " +
				"(SELECT max(edad) FROM Artista )" ,Artista.class);
		Artista aux = artistaMayor.uniqueResult();
		System.out.print(aux.getNombre() + " - " + aux.getEdad() + " años");

		// Consulta para obtener al artista mas joven
		System.out.print("\n\nArtista con menos edad.- ");

		Query<Artista> artistaMenor = session.createQuery("FROM Artista A WHERE A.edad = " +
				"(SELECT min(edad) FROM Artista )" ,Artista.class);
		aux = artistaMenor.uniqueResult();
		System.out.print(aux.getNombre() + " - " + aux.getEdad() + " años");

		// Consulta para obtener a los artistas mayores de 20
		System.out.println("\n\nArtistas mayores de 20 (Con parámetro).- ");

		Query<Artista> artistasMayores20 = session.createQuery("FROM Artista A WHERE A.edad > :edadMin", Artista.class);
		artistasMayores20.setParameter("edadMin", 20);
		List<Artista> list3 = artistasMayores20.list();

		for (Artista a: list3)
			System.out.println(a.getNombre() + " - " + a.getEdad() + " años");
	}
}

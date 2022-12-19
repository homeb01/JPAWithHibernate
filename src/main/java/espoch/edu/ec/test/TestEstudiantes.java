package espoch.edu.ec.test;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import espoch.edu.ec.modelo.Estudiante;
import espoch.edu.ec.modelo.Universidad;

public class TestEstudiantes {

	private static EntityManager entityManager;
	private static EntityManagerFactory entityManagerFactory;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("Persistencia");
		entityManager = entityManagerFactory.createEntityManager();

		Estudiante hb = new Estudiante("Homero Barragan", 22, 19f);
		Estudiante sr = new Estudiante("Steeven Romero", 23, 19.5f);
		Estudiante ed = new Estudiante("Emily Dominguez", 22, 19.3f);
		Estudiante tc = new Estudiante("Tatiana Carrillo", 22, 20f);
		
		Universidad ESPOCH = new Universidad("ESPOCH", new GregorianCalendar(1969, 4, 18).getTime());;
		Universidad UNACH = new Universidad("UNACH", new GregorianCalendar(1995, 8, 31).getTime());;
		
		ESPOCH.agregarEstudiante(hb);
		ESPOCH.agregarEstudiante(sr);
		
		UNACH.agregarEstudiante(ed);
		UNACH.agregarEstudiante(tc);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(hb);
		entityManager.persist(sr);
		entityManager.persist(ed);
		entityManager.persist(tc);
		
		entityManager.persist(ESPOCH);
		entityManager.persist(UNACH);
		
		entityManager.getTransaction().commit();
	}

}

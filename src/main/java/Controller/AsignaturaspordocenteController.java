package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Asignatura;
import model.Asignaturaspordocente;
import model.Docente;

public class AsignaturaspordocenteController {

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("ProfesoresymateriasJPA");

	/**
	 * 
	 * @param a
	 * @param d
	 * @return
	 */
	public static Asignaturaspordocente asignaturaPorDocente(Asignatura a, Docente d) {
		Asignaturaspordocente as = null;
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			Query q = em.createNativeQuery("select * from asignaturaspordocente where idAsignatura = " + a.getId()
					+ " and idDocente = " + d.getId() + ";", Asignaturaspordocente.class);
			as = (Asignaturaspordocente) q.getSingleResult();

		} catch (Exception e2) {
		}
		em.close();
		return as;
	}

	/**
	 * 
	 * @param as
	 */
	public static void update(Asignaturaspordocente as) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(as);
		System.out.println("He realizado la modificacion");
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * 
	 * @param as
	 */
	public static void insert(Asignaturaspordocente as) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(as);
		System.out.println("He realizado la inserccion");
		em.getTransaction().commit();
		em.close();
	}
}
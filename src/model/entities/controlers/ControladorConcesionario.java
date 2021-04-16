package model.entities.controlers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Cliente;
import model.entities.Concesionario;

public class ControladorConcesionario {

	//Declaración de la instacia como null para crear un Singleton
	private static ControladorConcesionario instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("GestionFabricantesJPA");
	
	
	/**
	 * Creación del patrón Singleton para poder acceder a todos los métodos mediante su instacia
	 */
	public static ControladorConcesionario getInstance() {
		//Si es la primera vez que se ejecuta, se inicializa la instacia
		if (instance == null) {
			instance = new ControladorConcesionario();
		}
		return instance;
	}
	
	/**
	 * Constructor por defecto de ControladorConcesionario
	 */
	public ControladorConcesionario() {
	}
	
	public Concesionario find(int id) {
		Concesionario f = null;
		EntityManager em = factory.createEntityManager();
		f = (Concesionario) em.find(Concesionario.class, id);
		em.close();
		return f;
	}

	/**
	 * Método utilizado para buscar el primer registro de la tabla Concesionario
	 * @return
	 */
	public Concesionario findPrimero() {
		//En principio inicializar un objeto de tipo Concesionario a null
		Concesionario co = null;
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.concesionario order by id limit 1",Concesionario.class);
		co = (Concesionario) q.getSingleResult();
		em.close();
		return co;
	}
	
	/**
	 * Método utilizado para encontrar el último registro de la tabla Concesionario
	 * @return
	 */
	public Concesionario findUltimo() {
		//En principio inicializar un objeto de tipo Concesionario a null
		Concesionario co = null;
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.concesionario order by id desc limit 1",Concesionario.class);
		co = (Concesionario) q.getSingleResult();
		em.close();
		return co;
	}
	
	/**
	 * Método utilizado para encontrar un siguiente Concesionario
	 * @param idActualidActual Es necesario pasarle cual es el registro en el que ya se está para poder
	 * 		determinar cuál es el anterior
	 * @return
	 */
	public Concesionario findSiguiente(int idActual) {
		//En principio inicializar un objeto de tipo Concesionario a null
		Concesionario co = null;
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.concesionario where id > ? order by id limit 1",Concesionario.class);
		q.setParameter(1, idActual);
		co = (Concesionario) q.getSingleResult();
		em.close();
		return co;
	}
	
	/**
	 * Método utilizado para encontrar un anterior Concesionario
	 * @param idActual Es necesario pasarle cual es el registro en el que ya se está para poder
	 * 		determinar cuál es el anterior
	 * @return
	 */
	public Concesionario findAnterior(int idActual) {
		//En principio inicializar un objeto de tipo Concesionario a null
		Concesionario co = null;
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.concesionario where id < ? order by id desc limit 1",Concesionario.class);
		q.setParameter(1, idActual);
		co = (Concesionario) q.getSingleResult();
		em.close();
		return co;
	}
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	public boolean guardar (Concesionario c) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (c.getId() == 0) {
				em.persist(c);
			}
			else {
				em.merge(c);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public void borrar(Concesionario co) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		co = em.merge(co);
		em.remove(co);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Método utilizado para buscar todos los fabricantes
	 * @return
	 */
	public List<Concesionario> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM concesionario", Concesionario.class);
		
		List<Concesionario> list = (List<Concesionario>) q.getResultList();
		em.close();
		return list;
	}

}

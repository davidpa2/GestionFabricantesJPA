package model.entities.controlers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Coche;

public class ControladorCoche {

	//Declaración de la instacia como null para crear un Singleton
	private static ControladorCoche instance = null;
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("GestionFabricantesJPA");
	
	/**
	 * Creación del patrón Singleton para poder acceder a todos los métodos mediante su instacia
	 */
	public static ControladorCoche getInstance() {
		//Si es la primera vez que se ejecuta, se inicializa la instacia
		if (instance == null) {
			instance = new ControladorCoche();
		}
		return instance;
	}
	
	/**
	 * Constructor por defecto de ControladorCoche
	 */
	public ControladorCoche() {
	}
	
	public Coche find(int id) {
		Coche f = null;
		EntityManager em = factory.createEntityManager();
		f = (Coche) em.find(Coche.class, id);
		em.close();
		return f;
	}

	/**
	 * Método utilizado para buscar el primer registro de la tabla fabricante
	 * @return
	 */
	public Coche findPrimero() {
		Coche c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.coche order by id limit 1",Coche.class);
		c = (Coche) q.getSingleResult();
		em.close();
		return c;
	}
	
	/**
	 * Método utilizado para encontrar el último registro de la tabla coche
	 * @return
	 */
	public Coche findUltimo() {
		Coche c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.coche order by id desc limit 1",Coche.class);
		c = (Coche) q.getSingleResult();
		em.close();
		return c;
	}
	
	/**
	 * Método utilizado para encontrar un siguiente coche
	 * @param idActualidActual Es necesario pasarle cual es el registro en el que ya se está para poder
	 * 		determinar cuál es el anterior
	 * @return
	 */
	public Coche findSiguiente(int idActual) {
		//En principio inicializar un objeto de tipo Coche a null
		Coche c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.coche where id > ? order by id limit 1",Coche.class);
		q.setParameter(1, idActual);
		c = (Coche) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * Método utilizado para encontrar un anterior coche
	 * @param idActual Es necesario pasarle cual es el registro en el que ya se está para poder
	 * 		determinar cuál es el anterior
	 * @return
	 */
	public Coche findAnterior(int idActual) {
		//En principio inicializar un objeto de tipo Coche a null
		Coche c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.coche where id < ? order by id desc limit 1",Coche.class);
		q.setParameter(1, idActual);
		c = (Coche) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	public boolean guardar (Coche c) {
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
	public void borrar(Coche c) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		c = em.merge(c);
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Método utilizado para buscar todos los fabricantes
	 * @return
	 */
	public List<Coche> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM coche", Coche.class);
		
		List<Coche> list = (List<Coche>) q.getResultList();
		em.close();
		return list;
	}
	
}

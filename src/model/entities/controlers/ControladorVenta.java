package model.entities.controlers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Venta;

public class ControladorVenta {

	//Declaración de la instacia como null para crear un Singleton
	private static ControladorVenta instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("GestionFabricantesJPA");
	
	/**
	 * Creación del patrón Singleton para poder acceder a todos los métodos mediante su instacia
	 */
	public static ControladorVenta getInstance() {
		//Si es la primera vez que se ejecuta, se inicializa la instacia
		if (instance == null) {
			instance = new ControladorVenta();
		}
		return instance;
	}
	
	/**
	 * Constructor de ControladorVenta
	 */
	public ControladorVenta() {
	}

	/**
	 * Método utilizado para buscar el primer registro de la tabla fabricante
	 * @return
	 */
	public Venta findPrimero() {
		//En principio inicializar un objeto de tipo Venta a null
		Venta v = null;
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.venta order by id limit 1",Venta.class);
		v = (Venta) q.getSingleResult();
		em.close();
		return v;
	}
	
	/**
	 * Método utilizado para encontrar el último registro de la tabla venta
	 * @return
	 */
	public Venta findUltimo() {
		//En principio inicializar un objeto de tipo Venta a null
		Venta v = null;
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.venta order by id desc limit 1",Venta.class);
		v = (Venta) q.getSingleResult();
		em.close();
		return v;
	}
	
	/**
	 * Método utilizado para encontrar una siguiente venta
	 * @param idActualidActual Es necesario pasarle cual es el registro en el que ya se está para poder
	 * 		determinar cuál es el anterior
	 * @return
	 */
	public Venta findSiguiente(int idActual) {
		//En principio inicializar un objeto de tipo Venta a null
		Venta v = null;
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.venta where id > ? order by id limit 1",Venta.class);
		q.setParameter(1, idActual);
		v = (Venta) q.getSingleResult();
		em.close();
		return v;
	}
	
	/**
	 * Método utilizado para encontrar una anterior venta
	 * @param idActual Es necesario pasarle cual es el registro en el que ya se está para poder
	 * 		determinar cuál es el anterior
	 * @return
	 */
	public Venta findAnterior(int idActual) {
		//En principio inicializar un objeto de tipo Venta a null
		Venta v = null;
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.venta where id < ? order by id desc limit 1",Venta.class);
		q.setParameter(1, idActual);
		v = (Venta) q.getSingleResult();
		em.close();
		return v;
	}
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	public boolean guardar (Venta c) {
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
	public void borrar(Venta v) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction();
		v = em.merge(v);
		em.remove(v);
		em.getTransaction().commit();
		em.close();
	}
	
}

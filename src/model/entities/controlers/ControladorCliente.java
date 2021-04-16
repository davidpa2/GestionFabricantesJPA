package model.entities.controlers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Cliente;

public class ControladorCliente {

	//Declaración de la instacia como null para crear un Singleton
	private static ControladorCliente instance = null;
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("GestionFabricantesJPA");
	
		
	/**
	 * Creación del patrón Singleton para poder acceder a todos los métodos mediante su instacia
	 */
	public static ControladorCliente getInstance() {
		//Si es la primera vez que se ejecuta, se inicializa la instacia
		if (instance == null) {
			instance = new ControladorCliente();
		}
		return instance;
	}	
	
	public ControladorCliente() {
	}
	
	public Cliente find(int id) {
		Cliente f = null;
		EntityManager em = factory.createEntityManager();
		f = (Cliente) em.find(Cliente.class, id);
		em.close();
		return f;
	}
	
	/**
	 * Método utilizado para buscar el primer registro de la tabla fabricante
	 * @return
	 */
	public Cliente findPrimero() {
		Cliente c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente order by id limit 1",Cliente.class);
		c = (Cliente) q.getSingleResult();
		em.close();
		return c;
	}
	
	/**
	 * Método utilizado para encontrar el último registro de la tabla fabricante
	 * @return
	 */
	public Cliente findUltimo() {
		//En principio inicializar un objeto de tipo Fabricante a null
		Cliente c = null;
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente order by id desc limit 1",Cliente.class);
		c = (Cliente) q.getSingleResult();
		em.close();
		return c;
	}
	
	/**
	 * Método utilizado para encontrar un siguiente cliente
	 * @param idActualidActual Es necesario pasarle cual es el registro en el que ya se está para poder
	 * 		determinar cuál es el anterior
	 * @return
	 */
	public Cliente findSiguiente(int idActual) {
		//En principio inicializar un objeto de tipo cliente a null
		Cliente c = null;
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente where id > ? order by id limit 1",Cliente.class);
		q.setParameter(1, idActual);
		c = (Cliente) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * Método utilizado para encontrar un anterior cliente
	 * @param idActual Es necesario pasarle cual es el registro en el que ya se está para poder
	 * 		determinar cuál es el anterior
	 * @return
	 */
	public Cliente findAnterior(int idActual) {
		//En principio inicializar un objeto de tipo Cliente a null
		Cliente c = null;
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente where id < ? order by id desc limit 1",Cliente.class);
		q.setParameter(1, idActual);
		c = (Cliente) q.getSingleResult();
		em.close();
		
		return c;
	}
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	public boolean guardar (Cliente c) {
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
	public void borrar(Cliente c) {
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
	public List<Cliente> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM cliente", Cliente.class);
		
		List<Cliente> list = (List<Cliente>) q.getResultList();
		em.close();
		return list;
	}

}

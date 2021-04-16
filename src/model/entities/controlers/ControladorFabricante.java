package model.entities.controlers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.List;
import model.entities.Fabricante;

public class ControladorFabricante {

	//Declaración de la instacia como null para crear un Singleton
		private static ControladorFabricante instance = null;
		
		private EntityManagerFactory factory = Persistence.createEntityManagerFactory("GestionFabricantesJPA");
		
		/**
		 * Creación del patrón Singleton para poder acceder a todos los métodos mediante su instacia
		 */
		public static ControladorFabricante getInstance() {
			//Si es la primera vez que se ejecuta, se inicializa la instacia
			if (instance == null) {
				instance = new ControladorFabricante();
			}
			return instance;
		}
		
		/**
		 * Constructor por defecto de ControladorCoche
		 */
		public ControladorFabricante() {
		}
		
		public Fabricante find(int id) {
			Fabricante f = null;
			EntityManager em = factory.createEntityManager();
			f = (Fabricante) em.find(Fabricante.class, id);
			em.close();
			return f;
		}

		/**
		 * Método utilizado para buscar el primer registro de la tabla fabricante
		 * @return
		 */
		public Fabricante findPrimero() {
			Fabricante c = null;
			
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from tutorialjavacoches.fabricante order by id limit 1",Fabricante.class);
			c = (Fabricante) q.getSingleResult();
			em.close();
			return c;
		}
		
		/**
		 * Método utilizado para encontrar el último registro de la tabla coche
		 * @return
		 */
		public Fabricante findUltimo() {
			Fabricante c = null;
			
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from tutorialjavacoches.fabricante order by id desc limit 1",Fabricante.class);
			c = (Fabricante) q.getSingleResult();
			em.close();
			return c;
		}
		
		/**
		 * Método utilizado para encontrar un siguiente coche
		 * @param idActualidActual Es necesario pasarle cual es el registro en el que ya se está para poder
		 * 		determinar cuál es el anterior
		 * @return
		 */
		public Fabricante findSiguiente(int idActual) {
			//En principio inicializar un objeto de tipo Coche a null
			Fabricante c = null;
			
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from tutorialjavacoches.fabricante where id > ? order by id limit 1",Fabricante.class);
			q.setParameter(1, idActual);
			c = (Fabricante) q.getSingleResult();
			em.close();
			
			return c;
		}
		
		/**
		 * Método utilizado para encontrar un anterior coche
		 * @param idActual Es necesario pasarle cual es el registro en el que ya se está para poder
		 * 		determinar cuál es el anterior
		 * @return
		 */
		public Fabricante findAnterior(int idActual) {
			//En principio inicializar un objeto de tipo Coche a null
			Fabricante c = null;
			
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from tutorialjavacoches.fabricante where id < ? order by id desc limit 1",Fabricante.class);
			q.setParameter(1, idActual);
			c = (Fabricante) q.getSingleResult();
			em.close();
			
			return c;
		}
		
		/**
		 * 
		 * @param f
		 * @return
		 */
		public boolean guardar (Fabricante c) {
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
		public void borrar(Fabricante c) {
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
		public List<Fabricante> findAll () {
			EntityManager em = factory.createEntityManager();
			
			Query q = em.createNativeQuery("SELECT * FROM fabricante", Fabricante.class);
			
			List<Fabricante> list = (List<Fabricante>) q.getResultList();
			em.close();
			return list;
		}
		
}

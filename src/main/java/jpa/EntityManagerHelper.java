package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {
	  private static final EntityManagerFactory factory; 
	    private static final ThreadLocal<EntityManager> threadLocal;

	    static {
	        factory = Persistence.createEntityManagerFactory("mysql");
	        threadLocal = new ThreadLocal<EntityManager>();
	    }

	    public static EntityManager getEntityManager() {
	        EntityManager em = threadLocal.get();

	        if (em == null) {
	            em = factory.createEntityManager();
	            threadLocal.set(em);
	        }
	        if (!em.isOpen()){
	            em = factory.createEntityManager();
	            threadLocal.set(em);
	        }
	        return em;
	    }

	    public static EntityManagerFactory getfactory() {
			return factory;
		}

		public static void closeEntityManager() {
	        EntityManager em = threadLocal.get();
	        if (em != null) {
	            em.close();
	            threadLocal.set(null);
	        }
	    }

	    public static void closeEntityManagerFactory() {
	        factory.close();
	    }

	    public static void beginTransaction() {
	        getEntityManager().getTransaction().begin();
	    }

	    public static void rollback() {
	        getEntityManager().getTransaction().rollback();
	    }

	    public static void commit() {
	        getEntityManager().getTransaction().commit();
	    } 

}

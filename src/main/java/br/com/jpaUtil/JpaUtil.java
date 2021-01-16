package br.com.jpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory factory = null;

	static {
		init();
	}
	
	private static void init() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("projetoautopecas");
		}
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}

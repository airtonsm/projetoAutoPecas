package br.com.jpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil { // classe que retorna o entity responsável por dar persistencia.

	private static EntityManagerFactory factory = null;

	static { // garante que persistence será executado
		if (factory == null)// garante execução única
			factory = Persistence.createEntityManagerFactory("projetoautopecas"); // prover a persistencia, salvar, editar remover etc;
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager(); 
	}
	

}

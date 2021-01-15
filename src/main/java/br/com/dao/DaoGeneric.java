package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.jpaUtil.JpaUtil;

public class DaoGeneric<E> { //indica receber qualquer tipo de classe 
	
	public void save(E entidade) {
		EntityManager entityManager = JpaUtil.getEntityManager();
				EntityTransaction entityTransaction = entityManager.getTransaction(); // iniciar transaçãp
				entityTransaction.begin();
		
		entityManager.persist(entidade);
		
		entityTransaction.commit();
		entityManager.close();
	}
	

}

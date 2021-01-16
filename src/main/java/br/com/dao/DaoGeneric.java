package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.jpaUtil.JpaUtil;

public class DaoGeneric<E> {

	public void salvar(E entidade) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction(); // iniciar transaçãp
		entityTransaction.begin();

		entityManager.persist(entidade);

		entityTransaction.commit();
		entityManager.close();
	}

}

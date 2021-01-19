package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.entities.Usuario;
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
	
	public List<E> getListEntitie(Class<E> entidade){
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction(); // iniciar transaçãp
		entityTransaction.begin();
		
		List<E> retorno = entityManager.createQuery("from " +  entidade.getName()).getResultList();	
		
		entityTransaction.commit();
		entityManager.close();
		
		return retorno;
	} 

}

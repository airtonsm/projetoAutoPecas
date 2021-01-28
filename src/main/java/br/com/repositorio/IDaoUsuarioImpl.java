package br.com.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.dao.DaoGeneric;
import br.com.entities.Usuario;
import br.com.jpaUtil.JpaUtil;

public class IDaoUsuarioImpl implements IDaoUsuario {

	@Override
	public Usuario consultarUsuario(String login, String senha) {

		Usuario usuario = null;

		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction(); // iniciar transaçãp
		entityTransaction.begin();

		usuario = (Usuario) entityManager
				.createQuery("select p from Usuario p where p.login = '" 
						+ login + "' and p.senha = '" + senha + "'")
				.getSingleResult();
		
		

		entityTransaction.commit();
		entityManager.close();

		return usuario;
	}
	
	@Override
	public List<Usuario> getListSearchLogin(String login){
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction(); // iniciar transaçãp
		entityTransaction.begin();
		
		List<Usuario> retorno = entityManager.createQuery("from Usuario"
		+ " where lower(login) like '%" + login.toLowerCase() + "%'").getResultList();	
		
		entityTransaction.commit();
		entityManager.close();
		
		return retorno;
	} 

}

package br.com.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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

}

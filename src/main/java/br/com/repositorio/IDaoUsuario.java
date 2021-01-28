package br.com.repositorio;

import java.util.List;

import br.com.entities.Usuario;

public interface IDaoUsuario {
	
	Usuario consultarUsuario(String login, String senha);
	
	List <Usuario> getListSearchLogin( String login);

}

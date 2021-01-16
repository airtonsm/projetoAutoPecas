package br.com.repositorio;

import br.com.entities.Usuario;

public interface IDaoUsuario {
	
	Usuario consultarUsuario(String login, String senha);

}

package br.com.joseairton;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;


import br.com.dao.DaoGeneric;
import br.com.entities.Usuario;


@ManagedBean(name = "userBean") // reference for utilize at the jsf (front)
public class UserBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private Usuario usuario = new Usuario();
	private DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
	
	public String salvar() {
		daoGeneric.save(usuario);		
		return "";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public DaoGeneric<Usuario> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Usuario> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}
	
	
	
	
}
	

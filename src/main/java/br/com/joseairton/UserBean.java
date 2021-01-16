package br.com.joseairton;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DaoGeneric;
import br.com.entities.Usuario;

@ViewScoped
@ManagedBean(name = "userBean")
public class UserBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private Usuario usuario = new Usuario();
	private DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
	
	public String salva() {
		daoGeneric.salvar(usuario);	
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
	

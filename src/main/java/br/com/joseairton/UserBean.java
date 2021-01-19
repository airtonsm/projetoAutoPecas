package br.com.joseairton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.dao.DaoGeneric;
import br.com.entities.Usuario;
import br.com.repositorio.IDaoUsuario;
import br.com.repositorio.IDaoUsuarioImpl;

@ViewScoped
@ManagedBean(name = "userBean")
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario usuario = new Usuario();
	private DaoGeneric<Usuario> daoGeneric = new DaoGeneric<Usuario>();
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	private IDaoUsuario idaoUsuario = new IDaoUsuarioImpl();



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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String logar() {

		Usuario usuarioLog = idaoUsuario.consultarUsuario(usuario.getLogin(), usuario.getSenha());

		if (usuarioLog != null) {

			// adicionar o usuário na sessão usuarioLogado para autenticação no filter
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext externalContext = context.getExternalContext();
			externalContext.getSessionMap().put("usuarioLogado", usuarioLog);

			return "menu.jsf";
		}

		return "index.jsf";
	}
	
	public String salva() {
		daoGeneric.salvar(usuario);
		usuario = new Usuario();
		carregarUsuario();
		return "";
	}
	
	public String delete() {
		daoGeneric.deletePorId(usuario);
		usuario = new Usuario();
		carregarUsuario();
		return "";
	}

	public boolean permiteAcesso(String acesso) {

		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		Usuario user = (Usuario) externalContext.getSessionMap().get("usuarioLogado");

		return user.getCargo().equals(acesso);
	}

	@PostConstruct 
	public void carregarUsuario() {
		usuarios = daoGeneric.getListEntitie(Usuario.class);
	}

}

package br.com.joseairton;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DaoGeneric;
import br.com.entities.Cliente;

@ViewScoped
@ManagedBean(name = "clienteBean")
public class ClienteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private DaoGeneric<Cliente> daoGeneric = new DaoGeneric<Cliente>();
	private Cliente cliente = new Cliente();

	public DaoGeneric<Cliente> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Cliente> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public String salvar() {
		daoGeneric.salvar(cliente);
		return"";
	}

	
	

}

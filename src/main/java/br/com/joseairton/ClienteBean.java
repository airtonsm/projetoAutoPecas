package br.com.joseairton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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
	
	List<Cliente> clientes = new ArrayList<Cliente>();

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
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	public String salvar() {
		daoGeneric.salvar(cliente);
		carregarClientes();
		return"";
	}
	
	@PostConstruct
	public void carregarClientes() {
		clientes = daoGeneric.getListEntitie(Cliente.class);
	}

	public String limpar() {
		cliente = new Cliente();
		return "";
	}
	
	

}

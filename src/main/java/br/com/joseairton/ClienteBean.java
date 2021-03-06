package br.com.joseairton;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import com.google.gson.Gson;

import br.com.dao.DaoGeneric;
import br.com.entities.Cliente;

@ViewScoped
@ManagedBean(name = "clienteBean")
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Cliente cliente = new Cliente();
	private DaoGeneric<Cliente> daoGeneric = new DaoGeneric<Cliente>();

	List<Cliente> clientes = new ArrayList<Cliente>();

	@PostConstruct
	public void carregarClientes() {
		clientes = daoGeneric.getListEntitie(Cliente.class);
	}

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
		cliente = new Cliente();
		return "";
	}
	
	public String delete() {
		daoGeneric.deletePorId(cliente);
		cliente = new Cliente();
		return"";
	}

	public String limpar() {
		cliente = new Cliente();
		return "";
	}

	public void pesquisaCep(AjaxBehaviorEvent event) {

		try {
			URL url = new URL("https://viacep.com.br/ws/" + cliente.getCep() + "/json/");
			URLConnection connection = url.openConnection(); // abre conexão
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

			String cep = "";
			StringBuilder jsonCep = new StringBuilder();

			while ((cep = br.readLine()) != null) {
				
				jsonCep.append(cep);
			}

			Cliente userCepPessoa = new Gson().fromJson(jsonCep.toString(), Cliente.class);
			
			cliente.setCep(userCepPessoa.getCep());
			cliente.setLogradouro(userCepPessoa.getLogradouro());
			cliente.setComplemento(userCepPessoa.getComplemento());
			cliente.setBairro(userCepPessoa.getBairro());
			cliente.setLocalidade(userCepPessoa.getLocalidade());
			cliente.setUf(userCepPessoa.getUf());
			cliente.setIbge(userCepPessoa.getIbge());
			cliente.setGia(userCepPessoa.getGia());
			cliente.setDdd(userCepPessoa.getDdd());
			cliente.setSiafi(userCepPessoa.getSiafi());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao mostrar Cep: ");
		}

	}

}

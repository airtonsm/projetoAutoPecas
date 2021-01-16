package br.com.joseairton;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DaoGeneric;
import br.com.entities.Pecas;

@ViewScoped
@ManagedBean(name = "pecasBean")
public class PecasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pecas pecas = new Pecas();
	private DaoGeneric<Pecas> daoGeneric = new DaoGeneric<Pecas>();

	public Pecas getPecas() {
		return pecas;
	}

	public void setPecas(Pecas pecas) {
		this.pecas = pecas;
	}

	public DaoGeneric<Pecas> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Pecas> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

	public String salvar() {
		daoGeneric.salvar(pecas);
		return "";
	}

}

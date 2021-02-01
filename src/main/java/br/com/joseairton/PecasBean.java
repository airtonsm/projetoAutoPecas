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

	public void calcular() {
		if (pecas.getValorCusto() <= 50.00) {
			pecas.setTaxa(120.00);
			pecas.setValorVenda(pecas.getValorCusto() + (pecas.getValorCusto() * pecas.getTaxa() / 100));
		} else if ((pecas.getValorCusto() > 50.00) && (pecas.getValorCusto() <= 100.00)) {
			pecas.setTaxa(100.00);
			pecas.setValorVenda(pecas.getValorCusto() + (pecas.getValorCusto() * pecas.getTaxa() / 100));
		} else if ((pecas.getValorCusto() > 100.00)) {
			pecas.setTaxa(80.00);
			pecas.setValorVenda(pecas.getValorCusto() + (pecas.getValorCusto() * pecas.getTaxa() / 100));
		}

	}

	public void salvar() {
		daoGeneric.salvar(pecas);
		pecas = new Pecas();
	}

}

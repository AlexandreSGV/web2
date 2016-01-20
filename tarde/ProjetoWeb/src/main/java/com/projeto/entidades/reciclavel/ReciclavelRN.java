package com.projeto.entidades.reciclavel;

import java.util.List;

import com.projeto.util.DAOFactory;

public class ReciclavelRN {
	private ReciclavelDAO reciclavelDAO;

	public ReciclavelRN() {
		this.reciclavelDAO = DAOFactory.criarReciclavelDAO();
	}

	public Reciclavel carregar(Integer codigo) {
		return this.reciclavelDAO.carregar(codigo);
	}


	public void salvar(Reciclavel reciclavel) {
		Integer codigo = reciclavel.getId();
		if (codigo == null || codigo == 0) {
			this.reciclavelDAO.salvar(reciclavel);
		} else {
			this.reciclavelDAO.atualizar(reciclavel);
		}
	}

	public void excluir(Reciclavel reciclavel) {
		this.reciclavelDAO.excluir(reciclavel);
	}

	public List<Reciclavel> listar() {
		return this.reciclavelDAO.listar();
	}
}

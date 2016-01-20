package com.projeto.entidades.reciclavel;

import java.util.List;

import com.projeto.util.DAOFactory;

public class TipoItemRN {
	private TipoItemDAO tipoItemDAO;

	public TipoItemRN() {
		this.tipoItemDAO = DAOFactory.criarTipoItemDAO();
	}

	public TipoItem carregar(Integer codigo) {
		return this.tipoItemDAO.carregar(codigo);
	}


	public void salvar(TipoItem tipoItem) {
		Integer codigo = tipoItem.getId();
		if (codigo == null || codigo == 0) {
			this.tipoItemDAO.salvar(tipoItem);
		} else {
			this.tipoItemDAO.atualizar(tipoItem);
		}
	}

	public void excluir(TipoItem tipoItem) {
		this.tipoItemDAO.excluir(tipoItem);
	}

	public List<TipoItem> listar() {
		return this.tipoItemDAO.listar();
	}
}

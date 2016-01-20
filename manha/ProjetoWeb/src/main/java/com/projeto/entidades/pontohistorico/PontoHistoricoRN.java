package com.projeto.entidades.pontohistorico;

import java.util.List;

import com.projeto.util.DAOFactory;

public class PontoHistoricoRN {
	private PontoHistoricoDAO pontoHistoricoDAO;

	public PontoHistoricoRN() {
		this.pontoHistoricoDAO = DAOFactory.criarPontoHistoricoDAO();
	}

	public PontoHistorico carregar(Integer codigo) {
		return this.pontoHistoricoDAO.carregar(codigo);
	}

	public PontoHistorico buscarPorNome(String nome) {
		return this.pontoHistoricoDAO.buscarPorNome(nome);
	}

	public void salvar(PontoHistorico usuario) {
		Integer codigo = usuario.getId();
		if (codigo == null || codigo == 0) {
			this.pontoHistoricoDAO.salvar(usuario);
		} else {
			this.pontoHistoricoDAO.atualizar(usuario);
		}
	}

	public void excluir(PontoHistorico usuario) {
		this.pontoHistoricoDAO.excluir(usuario);
	}

	public List<PontoHistorico> listar() {
		return this.pontoHistoricoDAO.listar();
	}
}

package com.projeto.util;

import com.projeto.entidades.pontohistorico.PontoHistoricoDAO;
import com.projeto.entidades.usuario.UsuarioDAO;

public class DAOFactory {

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO; 
	}

	public static PontoHistoricoDAO criarPontoHistoricoDAO() {
		PontoHistoricoDAO pontoHistoricoDAO = new PontoHistoricoDAO();
		pontoHistoricoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return pontoHistoricoDAO;
	}
}

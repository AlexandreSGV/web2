package com.projeto.util;

import com.projeto.entidades.reciclavel.ReciclavelDAO;
import com.projeto.entidades.reciclavel.TipoItemDAO;
import com.projeto.entidades.usuario.UsuarioDAO;

public class DAOFactory {

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO; 
	}

	public static ReciclavelDAO criarReciclavelDAO() {
		ReciclavelDAO reciclavelDAO = new ReciclavelDAO();
		reciclavelDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return reciclavelDAO; 
		
	}

	public static TipoItemDAO criarTipoItemDAO() {
		TipoItemDAO tipoItemDAO = new TipoItemDAO();
		tipoItemDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return null;
	}
}

package com.projeto.entidades.usuario;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.projeto.dao.DAO;

public class UsuarioDAO extends DAO{
	private Session currentSession;  
	  
    public UsuarioDAO () {    	
        currentSession = super.getSession();  
    }  

	public void setSession(Session session) {
		this.currentSession = session;
	}

	public void salvar(Usuario usuario) {
		this.currentSession.save(usuario);
	}

	public void atualizar(Usuario usuario) {
		this.currentSession.update(usuario);
	}

	public void excluir(Usuario usuario) {
		this.currentSession.delete(usuario);
	}

	public Usuario carregar(Integer codigo) {
		return (Usuario) this.currentSession.get(Usuario.class, codigo);
	}

	public List<Usuario> listar() {
		return this.currentSession.createCriteria(Usuario.class).list();
	}

	public Usuario buscarPorLogin(String login) {
		String hql = "select u from Usuario u where u.login = :login";
		Query consulta = this.currentSession.createQuery(hql);
		consulta.setString("login", login);
		return (Usuario) consulta.uniqueResult();
	}
	
	public Usuario buscarPorEmail(String email) {
		String hql = "select u from Usuario u where u.email = :email";
		Query consulta = this.currentSession.createQuery(hql);
		consulta.setString("email", email);
		return (Usuario) consulta.uniqueResult();
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}
}

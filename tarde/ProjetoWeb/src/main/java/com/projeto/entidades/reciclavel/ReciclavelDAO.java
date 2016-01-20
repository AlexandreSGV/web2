package com.projeto.entidades.reciclavel;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.projeto.dao.DAO;

public class ReciclavelDAO extends DAO{
	private Session currentSession;  
	  
    public ReciclavelDAO () {    	
        currentSession = super.getSession();  
    }  

	public void setSession(Session session) {
		this.currentSession = session;
	}

	public void salvar(Reciclavel reciclavel) {
		this.currentSession.save(reciclavel);
	}

	public void atualizar(Reciclavel reciclavel) {
		this.currentSession.update(reciclavel);
	}

	public void excluir(Reciclavel reciclavel) {
		this.currentSession.delete(reciclavel);
	}

	public Reciclavel carregar(Integer codigo) {
		return (Reciclavel) this.currentSession.get(Reciclavel.class, codigo);
	}

	public List<Reciclavel> listar() {
		return this.currentSession.createCriteria(Reciclavel.class).list();
	}

	public Reciclavel buscarPorNome(String nome) {
		String hql = "select u from Reciclavel u where u.nome = :nome";
		Query consulta = this.currentSession.createQuery(hql);
		consulta.setString("nome", nome);
		return (Reciclavel) consulta.uniqueResult();
	}
	
	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}
}

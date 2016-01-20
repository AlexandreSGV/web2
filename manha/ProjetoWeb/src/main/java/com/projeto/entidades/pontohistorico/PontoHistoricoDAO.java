package com.projeto.entidades.pontohistorico;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.projeto.dao.DAO;

public class PontoHistoricoDAO extends DAO{
	private Session currentSession;  
	  
    public PontoHistoricoDAO () {    	
        currentSession = super.getSession();  
    }  

	public void setSession(Session session) {
		this.currentSession = session;
	}

	public void salvar(PontoHistorico pontoHistorico) {
		this.currentSession.save(pontoHistorico);
	}

	public void atualizar(PontoHistorico pontoHistorico) {
		this.currentSession.update(pontoHistorico);
	}

	public void excluir(PontoHistorico pontoHistorico) {
		this.currentSession.delete(pontoHistorico);
	}

	public PontoHistorico carregar(Integer codigo) {
		return (PontoHistorico) this.currentSession.get(PontoHistorico.class, codigo);
	}

	public List<PontoHistorico> listar() {
		return this.currentSession.createCriteria(PontoHistorico.class).list();
	}

	public PontoHistorico buscarPorNome(String nome) {
		String hql = "select ph from PontoHistorico ph where ph.nome = :nome";
		Query consulta = this.currentSession.createQuery(hql);
		consulta.setString("nome", nome);
		return (PontoHistorico) consulta.uniqueResult();
	}
	
	

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}
}

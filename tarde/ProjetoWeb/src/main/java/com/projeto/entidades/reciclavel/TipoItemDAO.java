package com.projeto.entidades.reciclavel;
import java.util.List;

import org.hibernate.Session;

import com.projeto.dao.DAO;

public class TipoItemDAO extends DAO{
	private Session currentSession;  
	  
    public TipoItemDAO () {    	
        currentSession = super.getSession();  
    }  

	public void setSession(Session session) {
		this.currentSession = session;
	}

	public void salvar(TipoItem tipoItem) {
		this.currentSession.save(tipoItem);
	}

	public void atualizar(TipoItem tipoItem) {
		this.currentSession.update(tipoItem);
	}

	public void excluir(TipoItem tipoItem) {
		this.currentSession.delete(tipoItem);
	}

	public TipoItem carregar(Integer codigo) {
		return (TipoItem) this.currentSession.get(TipoItem.class, codigo);
	}

	public List<TipoItem> listar() {
		return this.currentSession.createCriteria(TipoItem.class).list();
	}

	
	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}
}

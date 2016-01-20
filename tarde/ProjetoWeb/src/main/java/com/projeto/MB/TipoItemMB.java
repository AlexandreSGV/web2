package com.projeto.MB;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import com.projeto.entidades.reciclavel.TipoItem;
import com.projeto.entidades.reciclavel.TipoItemRN;
import com.projeto.entidades.usuario.Usuario;
import com.projeto.entidades.usuario.UsuarioRN;

@ManagedBean
@RequestScoped
public class TipoItemMB {

	private TipoItem tipoItem= new TipoItem();
	private String destinoSalvar;
    private List<TipoItem> lista;
    private List<Usuario> listaUsuarios;
	
	

	public TipoItemMB() {
		if (tipoItem == null){
			tipoItem = new TipoItem();
		}
	}
	
	public String salvar(){
		TipoItemRN tipoItemRN = new TipoItemRN();
		tipoItemRN.salvar(this.tipoItem);
		return destinoSalvar;
	}
	public String novo() {
		this.tipoItem = new TipoItem();
		this.destinoSalvar = "/publico/reciclavel/listagem_tipoitem";
		return "/publico/tipoitem";
	}
	
	
	
	public List<TipoItem> getLista() {
		if(lista == null){
			TipoItemRN tipoItemRN = new TipoItemRN();
			lista = tipoItemRN.listar();
		}
		return lista;
	}
	
	public List<Usuario> getListaUsuarios() {
		if(listaUsuarios == null){
			UsuarioRN usuarioRN = new UsuarioRN();
			listaUsuarios = usuarioRN.listar();
		}
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public void setLista(List<TipoItem> lista) {
		this.lista = lista;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public TipoItem getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}
	
	
}

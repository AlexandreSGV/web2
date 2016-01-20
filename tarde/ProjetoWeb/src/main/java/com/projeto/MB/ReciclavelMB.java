package com.projeto.MB;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import com.projeto.entidades.reciclavel.Reciclavel;
import com.projeto.entidades.reciclavel.ReciclavelRN;
import com.projeto.entidades.usuario.Usuario;
import com.projeto.entidades.usuario.UsuarioRN;

@ManagedBean
@RequestScoped
public class ReciclavelMB {

	private Reciclavel reciclavel;
	private String destinoSalvar;
    private List<Reciclavel> lista;
    private List<Usuario> listaUsuarios;
	
	

	public ReciclavelMB() {
		if (reciclavel == null){
			reciclavel = new Reciclavel();
		}
	}
	
	public String salvar(){
		ReciclavelRN reciclavelRN = new ReciclavelRN();
		reciclavelRN.salvar(this.reciclavel);
		return destinoSalvar;
	}
	public String novo() {
		this.reciclavel = new Reciclavel();
		this.destinoSalvar = "/publico/reciclavel/listagem_reciclavel";
		return "/publico/reciclavel";
	}
	
	
	
	public List<Reciclavel> getLista() {
		if(lista == null){
			ReciclavelRN reciclavelRN = new ReciclavelRN();
			lista = reciclavelRN.listar();
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

	public void setLista(List<Reciclavel> lista) {
		this.lista = lista;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public Reciclavel getReciclavel() {
		return reciclavel;
	}

	public void setReciclavel(Reciclavel reciclavel) {
		this.reciclavel = reciclavel;
	}
	
	
}

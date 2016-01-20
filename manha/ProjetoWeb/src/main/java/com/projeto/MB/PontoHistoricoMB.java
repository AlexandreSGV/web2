package com.projeto.MB;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import com.projeto.entidades.pontohistorico.PontoHistorico;
import com.projeto.entidades.pontohistorico.PontoHistoricoRN;

@ManagedBean
@RequestScoped

public class PontoHistoricoMB {
	private PontoHistorico pHistorico= new PontoHistorico();
	private List<PontoHistorico> lista;
	
	public String novo() {
		pHistorico = new PontoHistorico();
		return "/publico/phistorico/phistorico";
	}

	public String salvar() {
		PontoHistoricoRN pHistoricoRN = new PontoHistoricoRN();
		pHistoricoRN.salvar(this.pHistorico);

		return "/publico/phistorico/phistoricolist";
	}

	
	
	public List<PontoHistorico> getLista() {
		if (this.lista == null) {
			PontoHistoricoRN pHistoricoRN = new PontoHistoricoRN();
			this.lista = pHistoricoRN.listar();
		}
		return lista;
	}

	public void setLista(List<PontoHistorico> lista) {
		this.lista = lista;
	}

	public PontoHistorico getpHistorico() {
		return pHistorico;

	}

	public void setpHistorico(PontoHistorico pHistorico) {
		this.pHistorico = pHistorico;

	}

}

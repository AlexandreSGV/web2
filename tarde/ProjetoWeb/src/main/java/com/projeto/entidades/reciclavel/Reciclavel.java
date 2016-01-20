package com.projeto.entidades.reciclavel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

import com.projeto.entidades.usuario.Usuario;

@Entity
public class Reciclavel {
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@ForeignKey(name = "fk_reciclavel_usuario")
	private Usuario usuario;
	@ManyToOne
	@ForeignKey(name = "fk_reciclavel_tipoitem")
	private TipoItem tipoItem;
	private String nome;
	private int quantidade;

	public Reciclavel() {
		super();
		this.usuario = new Usuario();
		this.tipoItem = new TipoItem(); 
	}

	public Reciclavel(Usuario usuario, TipoItem tipoItem, String nome, int quantidade) {
		super();
		this.usuario = usuario;
		this.tipoItem = tipoItem;
		this.nome = nome;
		this.quantidade = quantidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoItem getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + quantidade;
		result = prime * result + ((tipoItem == null) ? 0 : tipoItem.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reciclavel other = (Reciclavel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (quantidade != other.quantidade)
			return false;
		if (tipoItem == null) {
			if (other.tipoItem != null)
				return false;
		} else if (!tipoItem.equals(other.tipoItem))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	

}

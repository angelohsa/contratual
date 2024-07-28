package br.com.empresa.contratos.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
public class Empresa extends EntidadeAbstrata<Long> {

	@NotBlank
	@Size(max=60)
	@Column(unique=true)
	private String nome;
	
	@NotBlank
	@Size(max=3)
	private String numero;
	private boolean inativo;
	
	@OneToMany(mappedBy = "empresa")
	private List<Unidade> unidades;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean isInativo() {
		return inativo;
	}

	public void setInativo(boolean inativo) {
		this.inativo = inativo;
	}

	public List<Unidade> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}

}

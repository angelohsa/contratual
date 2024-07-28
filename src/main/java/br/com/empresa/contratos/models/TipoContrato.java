package br.com.empresa.contratos.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
public class TipoContrato extends EntidadeAbstrata<Long> {

	@NotBlank
	@Size(max=60)
	@Column(unique=true)
	private String tipo;
	
	@NotBlank
	@Size(max=100)
	private String descricao;
	private boolean inativo;

	@OneToMany(mappedBy = "tipoContrato")
	private List<Contrato> contratos;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public boolean isInativo() {
		return inativo;
	}

	public void setInativo(boolean inativo) {
		this.inativo = inativo;
	}

}

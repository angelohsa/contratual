package br.com.empresa.contratos.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
public class CentroDeCusto extends EntidadeAbstrata<Long> {

	@NotBlank
	@Size(min=7,max=9)
	@Column(unique=true)
	private String codigo;
	
	@NotBlank
	@Size(max=60)
	private String descricao;
	private boolean inativo;
	
	@OneToMany(mappedBy="centroDeCusto")
	private List<Contrato> contratos;
 
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isInativo() {
		return inativo;
	}

	public void setAtivo(boolean inativo) {
		this.inativo = inativo;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public void setInativo(boolean inativo) {
		this.inativo = inativo;
	}



}

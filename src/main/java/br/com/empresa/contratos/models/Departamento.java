package br.com.empresa.contratos.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
public class Departamento extends EntidadeAbstrata<Long>{

	@NotBlank
	@Size(max=40)
	@Column(unique=true)
	private String nome;
	
	@OneToMany(mappedBy="departamento")
	private List<Contrato> contrato;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Contrato> getContrato() {
		return contrato;
	}

	public void setContrato(List<Contrato> contrato) {
		this.contrato = contrato;
	}
	

}

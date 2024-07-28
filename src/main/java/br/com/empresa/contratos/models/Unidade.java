package br.com.empresa.contratos.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
public class Unidade extends EntidadeAbstrata<Long> {

	@NotBlank
	@Size(max=60)
	private String nome;
	
	@NotNull
	private Integer site;
	
	@NotBlank
	@Size(max=20)
	@Column(unique=true)
	private String dimensaoAx;
	
	@NotBlank
	@Size(max=18)
	private String cnpj;
	private boolean inativo;
	private boolean matriz;

	@ManyToOne
	@JoinColumn(name = "id_empresa_fk")
	private Empresa empresa;

	@OneToMany(mappedBy = "unidade")
	private List<Contrato> contratos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getSite() {
		return site;
	}

	public void setSite(Integer site) {
		this.site = site;
	}

	public String getDimensaoAx() {
		return dimensaoAx;
	}

	public void setDimensaoAx(String dimensaoAx) {
		this.dimensaoAx = dimensaoAx;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public boolean isInativo() {
		return inativo;
	}

	public void setInativo(boolean inativo) {
		this.inativo = inativo;
	}

	public boolean isMatriz() {
		return matriz;
	}

	public void setMatriz(boolean matriz) {
		this.matriz = matriz;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

}

package br.com.empresa.contratos.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
public class Contraparte extends EntidadeAbstrata<Long> {
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoEntidade tipoEntidade;
	
	@NotBlank
	@Size(min=6, max=10)
	private String codigoContraparte;
	
	@NotBlank
	@Size(max=60)
	private String razaoSocial;
	
	@NotBlank
	@Size(max=18)
	private String cnpjcpfnum;
	
	@OneToMany(mappedBy="contraparte")
	private List<Contrato> contratos;
	
	public TipoEntidade getTipoEntidade() {
		return tipoEntidade;
	}

	public void setTipoEntidade(TipoEntidade tipo) {
		this.tipoEntidade = tipo;
	}

	public String getCodigoContraparte() {
		return codigoContraparte;
	}

	public void setCodigoContraparte(String codigoContraparte) {
		this.codigoContraparte = codigoContraparte;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpjcpfnum() {
		return cnpjcpfnum;
	}

	public void setCnpjcpfnum(String cnpjcpfnum) {
		this.cnpjcpfnum = cnpjcpfnum;
	}


}

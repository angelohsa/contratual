package br.com.empresa.contratos.models;

public enum Emissor {

	F("F", "Fornecedor"),
	S("S", "empresa");
	
	private String sigla;
	private String descricao;
	
	Emissor(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}

package br.com.empresa.contratos.models;

public enum TipoEntidade {
	
	F("F", "Fornecedor"),
	C("C", "Cliente");
	
	private String sigla;
	private String descricao;
	
	TipoEntidade(String sigla, String descricao) {
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

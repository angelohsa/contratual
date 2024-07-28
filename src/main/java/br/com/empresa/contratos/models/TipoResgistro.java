package br.com.empresa.contratos.models;

public enum TipoResgistro {
	C("Contrato"), A("Aditivo"), D("Distrato");

	private String descricao;

	private TipoResgistro(String descricao) {

		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

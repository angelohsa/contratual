package br.com.empresa.contratos.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Audited
public class Contrato extends EntidadeAbstrata<Long> {
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Audited
	private TipoResgistro tipoRegistro;

	@NotNull
	@ManyToOne
	@JoinColumn(name="id_tipo_contrato_fk")
	@NotAudited
	private TipoContrato tipoContrato;
	
	@NotAudited
	@Size(max=20)
	private String tipoEspecifico;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_contraparte_fk")
	@NotAudited
	private Contraparte contraparte;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_departamento_fk")
	@NotAudited
	private Departamento departamento;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_unidade_fk")
	@NotAudited
	private Unidade unidade;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_centro_de_custo_fk")
	@NotAudited
	private CentroDeCusto centroDeCusto;

	@NotNull
	@Enumerated(EnumType.STRING)
	@NotAudited
	private Emissor emissor;
	
	@NotAudited
	private boolean possuiDocumento;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "data_criacao", columnDefinition = "DATETIME")
	@NotAudited
	@CreationTimestamp
	private LocalDateTime dataCriacao;

	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_inicio", columnDefinition = "DATE")
	@Audited
	private LocalDate dataInicio;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_fim", columnDefinition = "DATE")
	@Audited
	private LocalDate dataFim;

	@Audited
	private boolean renovacaoAutomatica;
	
	@Audited
	//@Type(value=String.class)
	private String observacoes;
	
	@NotBlank
	@NotAudited
	@Size(max=9)
	private String codigoProcesso;
	
	@NotAudited
	@Size(max=30)
	private String codigoContrato;
	
	@NotBlank
	@Audited
	@Size(max=60)
	private String responsavel;
	
	@NotNull
	@Audited
	private BigDecimal valor;
	
	@Audited
	private Integer fidelidade;
	
	@Audited
	@Size(max=30)
	private String codigoAditivo;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_inicio_aditivo", columnDefinition = "DATE")
	@Audited
	private LocalDate dataInicioAditivo;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_fim_aditivo", columnDefinition = "DATE")
	@Audited
	private LocalDate dataFimAditivo;

	@Audited
	@Size(max=30)
	private String codigoDistrato;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_distrato", columnDefinition = "DATE")
	@Audited
	private LocalDate dataDistrato;
	
	

	public TipoResgistro getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(TipoResgistro tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getTipoEspecifico() {
		return tipoEspecifico;
	}

	public void setTipoEspecifico(String tipoEspecifico) {
		this.tipoEspecifico = tipoEspecifico;
	}

	public Contraparte getContraparte() {
		return contraparte;
	}

	public void setContraparte(Contraparte contraparte) {
		this.contraparte = contraparte;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public CentroDeCusto getCentroDeCusto() {
		return centroDeCusto;
	}

	public void setCentroDeCusto(CentroDeCusto centroDeCusto) {
		this.centroDeCusto = centroDeCusto;
	}

	public Emissor getEmissor() {
		return emissor;
	}

	public void setEmissor(Emissor emissor) {
		this.emissor = emissor;
	}
	
	public boolean isPossuiDocumento() {
		return possuiDocumento;
	}

	public void setPossuiDocumento(boolean possuiDocumento) {
		this.possuiDocumento = possuiDocumento;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getCodigoProcesso() {
		return codigoProcesso;
	}

	public void setCodigoProcesso(String codigoProcesso) {
		this.codigoProcesso = codigoProcesso;
	}

	public String getCodigoContrato() {
		return codigoContrato;
	}

	public void setCodigoContrato(String codigoContrato) {
		this.codigoContrato = codigoContrato;
	}


	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public boolean isRenovacaoAutomatica() {
		return renovacaoAutomatica;
	}

	public void setRenovacaoAutomatica(boolean renovacaoAutomatica) {
		this.renovacaoAutomatica = renovacaoAutomatica;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer getFidelidade() {
		return fidelidade;
	}

	public void setFidelidade(Integer fidelidade) {
		this.fidelidade = fidelidade;
	}

	public String getCodigoAditivo() {
		return codigoAditivo;
	}

	public void setCodigoAditivo(String codigoAditivo) {
		this.codigoAditivo = codigoAditivo;
	}

	public LocalDate getDataInicioAditivo() {
		return dataInicioAditivo;
	}

	public void setDataInicioAditivo(LocalDate dataInicioAditivo) {
		this.dataInicioAditivo = dataInicioAditivo;
	}

	public LocalDate getDataFimAditivo() {
		return dataFimAditivo;
	}

	public void setDataFimAditivo(LocalDate dataFimAditivo) {
		this.dataFimAditivo = dataFimAditivo;
	}

	public String getCodigoDistrato() {
		return codigoDistrato;
	}

	public void setCodigoDistrato(String codigoDistrato) {
		this.codigoDistrato = codigoDistrato;
	}

	public LocalDate getDataDistrato() {
		return dataDistrato;
	}

	public void setDataDistrato(LocalDate dataDistrato) {
		this.dataDistrato = dataDistrato;
	}
	
	
}

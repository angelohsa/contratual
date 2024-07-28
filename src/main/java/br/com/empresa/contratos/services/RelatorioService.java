package br.com.empresa.contratos.services;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Tuple;

import br.com.empresa.contratos.models.CentroDeCusto;
import br.com.empresa.contratos.models.TipoContrato;
import br.com.empresa.contratos.models.TipoEntidade;
import br.com.empresa.contratos.models.Unidade;

public interface RelatorioService {
	List<Tuple> porUnidade(TipoContrato tipoContrato, CentroDeCusto centrocusto, LocalDate dataInicio,
			LocalDate dataFim, String cnpj);

	List<Tuple> porEntidade(TipoContrato tipoContrato, CentroDeCusto centrocusto, String cnpj, LocalDate dataInicio,
			LocalDate dataFim, Unidade unidade, TipoEntidade tipoEntidade);

	List<Tuple> porTipoContrato(CentroDeCusto centrocusto,  LocalDate dataInicio, LocalDate dataFim,
			Unidade unidade);
	
	List<Tuple> porCentroDeCusto(CentroDeCusto centrocusto,  LocalDate dataInicio, LocalDate dataFim,
			Unidade unidade);
	
	List<Tuple> porCentroDeCusto(TipoContrato tipoContrato, 
			CentroDeCusto centrocusto, Unidade unidade);
	
	List<Tuple> porVencimento(TipoContrato tipoContrato, CentroDeCusto centrocusto, Unidade unidade);
	
	List<Tuple> getQuantidadeDeRegistros();
	
	List<Tuple> getQuantidadePorCentroCusto();
	
	List<Tuple> getQuantidadePorTipo();
	
	List<Long> getVenciment90Dias();
	
	List<Tuple> getQuantidadePorUnidade();
}

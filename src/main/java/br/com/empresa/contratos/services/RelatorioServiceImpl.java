package br.com.empresa.contratos.services;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.empresa.contratos.daos.RelatorioDAO;
import br.com.empresa.contratos.models.CentroDeCusto;
import br.com.empresa.contratos.models.TipoContrato;
import br.com.empresa.contratos.models.TipoEntidade;
import br.com.empresa.contratos.models.Unidade;

@Service
@Transactional
public class RelatorioServiceImpl implements RelatorioService {

	@Autowired
	private RelatorioDAO relatorioDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Tuple> porUnidade(TipoContrato tipoContrato, CentroDeCusto centrocusto, LocalDate dataInicio,
			LocalDate dataFim, String cnpj) {
		return relatorioDAO.porUnidade(tipoContrato, centrocusto, dataInicio, dataFim, cnpj);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tuple> porEntidade(TipoContrato tipoContrato, CentroDeCusto centrocusto, String cnpj,
			LocalDate dataInicio, LocalDate dataFim, Unidade unidade, TipoEntidade tipoEntidade) {

		return relatorioDAO.porEntidade(tipoContrato, centrocusto, cnpj, dataInicio, dataFim, unidade, tipoEntidade);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tuple> porTipoContrato(CentroDeCusto centrocusto,  LocalDate dataInicio, LocalDate dataFim,
			Unidade unidade) {

		return relatorioDAO.porTipoContrato(centrocusto,  dataInicio, dataFim, unidade);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tuple> porCentroDeCusto(CentroDeCusto centrocusto, LocalDate dataInicio, LocalDate dataFim,
			Unidade unidade) {
		return relatorioDAO.porCentroDeCusto(centrocusto, dataInicio, dataFim, unidade);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tuple> porCentroDeCusto(TipoContrato tipoContrato, CentroDeCusto centrocusto, Unidade unidade) {
		return relatorioDAO.porVencimento(tipoContrato, centrocusto, unidade);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tuple> porVencimento(TipoContrato tipoContrato, CentroDeCusto centrocusto, Unidade unidade) {
		return relatorioDAO.porVencimento(tipoContrato, centrocusto, unidade);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tuple> getQuantidadeDeRegistros() {
		return relatorioDAO.getQuantidadeDeRegistros();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tuple> getQuantidadePorCentroCusto() {
		return relatorioDAO.getQuantidadePorCentroCusto();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tuple> getQuantidadePorTipo() {
		return relatorioDAO.getQuantidadePorTipo();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Long> getVenciment90Dias() {
		return relatorioDAO.getVenciment90Dias();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tuple> getQuantidadePorUnidade() {
		return relatorioDAO.getQuantidadePorLoja();
	}

}

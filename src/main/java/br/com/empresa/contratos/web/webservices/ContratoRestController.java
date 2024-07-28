package br.com.empresa.contratos.web.webservices;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import jakarta.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.empresa.contratos.models.CentroDeCusto;
import br.com.empresa.contratos.models.Contraparte;
import br.com.empresa.contratos.models.Contrato;
import br.com.empresa.contratos.models.Departamento;
import br.com.empresa.contratos.models.Emissor;
import br.com.empresa.contratos.models.TipoContrato;
import br.com.empresa.contratos.models.TipoEntidade;
import br.com.empresa.contratos.models.TipoResgistro;
import br.com.empresa.contratos.models.Unidade;
import br.com.empresa.contratos.services.CentroDeCustoService;
import br.com.empresa.contratos.services.ContraparteService;
import br.com.empresa.contratos.services.ContratoService;
import br.com.empresa.contratos.services.DepartamentoService;
import br.com.empresa.contratos.services.TipoContratoService;
import br.com.empresa.contratos.services.UnidadeService;

@RestController
public class ContratoRestController {

	@Autowired
	private ContratoService contratoService;
	
	@Autowired
	private TipoContratoService tipoContratoService;
	
	@Autowired
	private ContraparteService contraparteService;
	
	@Autowired
	private CentroDeCustoService centroCustoService;
	
	@Autowired
	private UnidadeService unidadeService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@PostMapping("/servico/contrato/salvar")
	public String salvar(@RequestBody Map<String, String> contratoPost) {
		
		try {
			boolean forn = contratoPost.get("$EMISSOR").equals("Fornecedor");
			TipoEntidade t = forn ? TipoEntidade.F : TipoEntidade.C;
			contraparteService.buscarPorCNPJ(contratoPost.get("$CNPJ"), t);
		} catch (NoResultException e) {
			contraparteService.salvar(contratoPost);
		}

		Contrato contrato = popularContrato(contratoPost);

		contratoService.salvar(contrato);
		
		return "sucesso";
	}
	
	@PostMapping("/servico/contrato/editar")
	public String editar(@RequestBody Map<String, String> contratoPost) {
		Contrato contrato = popularContrato(contratoPost);
		contratoService.editar(contrato);
		return "sucesso";
	}
	
	private Contrato popularContrato(Map<String, String> contratoPost) {
		String codigoProcesso = contratoPost.get("$CODIGO_PROCESSO");
		String tipoRegistro = contratoPost.get("$TIPO_REGISTRO");
		String emissor = contratoPost.get("$EMISSOR");
		String tipoContrato = contratoPost.get("$TIPO_CONTRATO");
		String tipoEspecifico = contratoPost.get("$TIPO_CONTRATO_ESPECI");
		String codigoContrato = contratoPost.get("$CODIGO_CONTRATO");
		String unidade = contratoPost.get("$UNIDADE");
		String codigoCentroDeCusto = contratoPost.get("$COD_CENTRO_CUSTO");
		String departamento = contratoPost.get("$DEPARTAMENTO");
		String cnpj = contratoPost.get("$CNPJ");
		String possuiOriginal = contratoPost.get("$POSSUI_ORIGINAL");
		String codigoProcessoOriginal = contratoPost.get("$CODIGO_PROCESSO_ORIG");
		String dataInicio = contratoPost.get("$INICIO_VIGENCIA");
		String dataFim = contratoPost.get("$FIM_VIGENCIA");
		String fidelidade = contratoPost.get("$FIDELIDADE");
		String renovacaoAutomatica = contratoPost.get("$RENOVACAO_AUTOMATICA");
		String valorAnualReferencia = contratoPost.get("$VALOR_CONTRATO");
		String responsavel = contratoPost.get("$RESPONSAVEL");
		String dataDistrato = contratoPost.get("$DATA_DISTRATO");
		String observacoes = contratoPost.get("$OBSERVACOES");
		
		TipoResgistro tipoRegistroEnum = null;
		if (tipoRegistro.equals("Contrato")) {
			tipoRegistroEnum = TipoResgistro.C;
		} else if (tipoRegistro.equals("Aditivo")) {
			tipoRegistroEnum = TipoResgistro.A;
		} else if (tipoRegistro.equals("Distrato")) {
			tipoRegistroEnum = TipoResgistro.D; 
		}
		
		TipoContrato tipoContratoObj = tipoContratoService.buscarPorDescricao(tipoContrato);
		TipoEntidade tipoEntidade = emissor.equals("Fornecedor") ? TipoEntidade.F : TipoEntidade.C;
		Contraparte contraparteObj = contraparteService.buscarPorCNPJ(cnpj, tipoEntidade);
		CentroDeCusto centroDeCustoObj = centroCustoService.buscarPorCodigo(codigoCentroDeCusto);
		Departamento depto = departamentoService.buscarPorNome(departamento);
		Unidade unidadeObj = unidadeService.buscarPorDimensao(unidade);

		Contrato contrato = null;
		if (tipoRegistro.equals("Contrato")) {
			contrato = new Contrato();
			contrato.setTipoRegistro(tipoRegistroEnum);
			contrato.setContraparte(contraparteObj);
			contrato.setCodigoContrato(codigoContrato);
			contrato.setCodigoProcesso(codigoProcesso);
			contrato.setTipoContrato(tipoContratoObj);
			contrato.setTipoEspecifico(tipoEspecifico);
			contrato.setCentroDeCusto(centroDeCustoObj);
			contrato.setDepartamento(depto);
			contrato.setUnidade(unidadeObj);
			contrato.setEmissor(emissor.equals("Fornecedor") ? Emissor.F : Emissor.S);
			contrato.setFidelidade(Integer.parseInt(fidelidade));
			contrato.setRenovacaoAutomatica(renovacaoAutomatica.equals("Sim"));
			contrato.setPossuiDocumento(true);
			contrato.setValor(new BigDecimal(valorAnualReferencia));
			contrato.setResponsavel(responsavel);
			contrato.setObservacoes(observacoes);
			
			if (!dataInicio.equals("") && !dataInicio.equals("NULL")) {
				LocalDate dataInicioLocale = LocalDate.of(
						Integer.parseInt(dataInicio.substring(6, 10), 10) ,
						Integer.parseInt(dataInicio.substring(3, 5), 10), 
						Integer.parseInt(dataInicio.substring(0, 2), 10));
				
				contrato.setDataInicio(dataInicioLocale);
			}
			
			if (!dataFim.equals("") && !dataFim.equals("NULL")) {
				LocalDate dataFimLocale = LocalDate.of(
						Integer.parseInt(dataFim.substring(6, 10), 10),
						Integer.parseInt(dataFim.substring(3, 5), 10), 
						Integer.parseInt(dataFim.substring(0, 2), 10));
				
				contrato.setDataFim(dataFimLocale);
			}

		} else if (tipoRegistro.equals("Aditivo") && possuiOriginal.equals("Sim")) {
			contrato = contratoService.buscarPorCodigoProcesso(codigoProcessoOriginal);
			contrato.setTipoRegistro(tipoRegistroEnum);
			contrato.setCodigoAditivo(codigoContrato);
			contrato.setFidelidade(Integer.parseInt(fidelidade));
			contrato.setRenovacaoAutomatica(renovacaoAutomatica.equals("Sim"));
			contrato.setValor(new BigDecimal(valorAnualReferencia));
			contrato.setResponsavel(responsavel);
			contrato.setObservacoes(observacoes);
			
			if (!dataInicio.equals("") && !dataInicio.equals("NULL")) {
				LocalDate dataInicioLocale = LocalDate.of(
						Integer.parseInt(dataInicio.substring(6, 10), 10) ,
						Integer.parseInt(dataInicio.substring(3, 5), 10), 
						Integer.parseInt(dataInicio.substring(0, 2), 10));
				contrato.setDataInicioAditivo(dataInicioLocale);
			}
			
			if (!dataFim.equals("") && !dataFim.equals("NULL")) {
				LocalDate dataFimLocale = LocalDate.of(
						Integer.parseInt(dataFim.substring(6, 10), 10),
						Integer.parseInt(dataFim.substring(3, 5), 10), 
						Integer.parseInt(dataFim.substring(0, 2), 10));
				
				contrato.setDataFimAditivo(dataFimLocale);
			}
		} else if (tipoRegistro.equals("Aditivo") && possuiOriginal.equals("Não")) {
			contrato = new Contrato();
			contrato.setTipoRegistro(tipoRegistroEnum);
			contrato.setContraparte(contraparteObj);
			contrato.setCodigoContrato(codigoContrato);
			contrato.setCodigoAditivo(codigoContrato);
			contrato.setCodigoProcesso(codigoProcesso);
			contrato.setTipoContrato(tipoContratoObj);
			contrato.setTipoEspecifico(tipoEspecifico);
			contrato.setCentroDeCusto(centroDeCustoObj);
			contrato.setDepartamento(depto);
			contrato.setUnidade(unidadeObj);
			contrato.setEmissor(emissor.equals("Fornecedor") ? Emissor.F : Emissor.S);
			contrato.setFidelidade(Integer.parseInt(fidelidade));
			contrato.setRenovacaoAutomatica(renovacaoAutomatica.equals("Sim"));
			contrato.setPossuiDocumento(possuiOriginal.equals("Sim"));
			contrato.setValor(new BigDecimal(valorAnualReferencia));
			contrato.setResponsavel(responsavel);
			contrato.setObservacoes(observacoes);

			
			if (!dataInicio.equals("") && !dataInicio.equals("NULL")) {
				LocalDate dataInicioLocale = LocalDate.of(
						Integer.parseInt(dataInicio.substring(6, 10), 10) ,
						Integer.parseInt(dataInicio.substring(3, 5), 10), 
						Integer.parseInt(dataInicio.substring(0, 2), 10));
				
				contrato.setDataInicio(dataInicioLocale);
				contrato.setDataInicioAditivo(dataInicioLocale);
			}
			
			if (!dataFim.equals("") && !dataFim.equals("NULL")) {
				LocalDate dataFimLocale = LocalDate.of(
						Integer.parseInt(dataFim.substring(6, 10), 10),
						Integer.parseInt(dataFim.substring(3, 5), 10), 
						Integer.parseInt(dataFim.substring(0, 2), 10));
				
				contrato.setDataFim(dataFimLocale);
				contrato.setDataFimAditivo(dataFimLocale);
			}
		} else if (tipoRegistro.equals("Distrato") && possuiOriginal.equals("Sim")) {
		
			contrato = contratoService.buscarPorCodigoProcesso(codigoProcessoOriginal);
			contrato.setTipoRegistro(tipoRegistroEnum);
			contrato.setCodigoDistrato(codigoContrato);
			contrato.setResponsavel(responsavel);
			contrato.setObservacoes(observacoes);
			
			if (!dataDistrato.equals("") && !dataDistrato.equals("NULL")) {
				LocalDate dataDistratoLocale = LocalDate.of(
						Integer.parseInt(dataDistrato.substring(6, 10), 10),
						Integer.parseInt(dataDistrato.substring(3, 5), 10), 
						Integer.parseInt(dataDistrato.substring(0, 2), 10));
				
				contrato.setDataDistrato(dataDistratoLocale);
			}
		} else if (tipoRegistro.equals("Distrato") && possuiOriginal.equals("Não")) {
			contrato = new Contrato();
			contrato.setTipoRegistro(tipoRegistroEnum);
			contrato.setContraparte(contraparteObj);
			contrato.setCodigoContrato(codigoContrato);
			contrato.setCodigoDistrato(codigoContrato);
			contrato.setCodigoProcesso(codigoProcesso);
			contrato.setTipoContrato(tipoContratoObj);
			contrato.setTipoEspecifico(tipoEspecifico);
			contrato.setCentroDeCusto(centroDeCustoObj);
			contrato.setDepartamento(depto);
			contrato.setUnidade(unidadeObj);
			contrato.setEmissor(emissor.equals("Fornecedor") ? Emissor.F : Emissor.S);
			contrato.setPossuiDocumento(possuiOriginal.equals("Sim"));
			contrato.setResponsavel(responsavel);
			contrato.setObservacoes(observacoes);
			
			if (!dataDistrato.equals("") && !dataDistrato.equals("NULL")) {
				LocalDate dataDistratoLocale = LocalDate.of(
						Integer.parseInt(dataDistrato.substring(6, 10), 10),
						Integer.parseInt(dataDistrato.substring(3, 5), 10), 
						Integer.parseInt(dataDistrato.substring(0, 2), 10));
				
				contrato.setDataDistrato(dataDistratoLocale);
			}
		}

		return contrato;
	}

}

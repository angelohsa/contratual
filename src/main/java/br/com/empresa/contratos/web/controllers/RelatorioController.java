package br.com.empresa.contratos.web.controllers;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.empresa.contratos.models.CentroDeCusto;
import br.com.empresa.contratos.models.Emissor;
import br.com.empresa.contratos.models.TipoContrato;
import br.com.empresa.contratos.models.TipoEntidade;
import br.com.empresa.contratos.models.Unidade;
import br.com.empresa.contratos.services.CentroDeCustoService;
import br.com.empresa.contratos.services.RelatorioService;
import br.com.empresa.contratos.services.TipoContratoService;
import br.com.empresa.contratos.services.UnidadeService;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {

	@Autowired
	private TipoContratoService tipoContratoService;
	
	@Autowired
	private CentroDeCustoService centroCustoService;
	
	@Autowired
	private RelatorioService relatorioService;
	
	@Autowired
	private UnidadeService unidadeService;
	
	@GetMapping("/unidade")
	public String porUnidade() {
		return "relatorios/porunidade";
	}
	
	@GetMapping("/unidade/gerar")
	public String gerarPorUnidade(ModelMap model, TipoContrato tipoContrato, 
			CentroDeCusto centrocusto, String cnpj,@RequestParam("dataInicio") LocalDate dataInicio,
			@RequestParam("dataFim") LocalDate dataFim) {

		
		List<Tuple> resultado = relatorioService.porUnidade(tipoContrato, centrocusto, dataInicio, dataFim, cnpj);
		model.addAttribute("resultado", resultado);
		model.addAttribute("tipoC", tipoContrato);
		model.addAttribute("centroC", centrocusto);
		model.addAttribute("cnpjc", cnpj);
		model.addAttribute("dataI", dataInicio);
		model.addAttribute("dataF", dataFim);
		return "relatorios/resultadoporunidade";
	}
	
	@GetMapping("/entidade")
	public String porEntidade() {
		return "relatorios/porentidade";
	}
	
	@GetMapping("/entidade/gerar")
	public String gerarPorEntidade(ModelMap model, TipoContrato tipoContrato, 
			CentroDeCusto centrocusto, String cnpj,@RequestParam("dataInicio") LocalDate dataInicio,
			@RequestParam("dataFim") LocalDate dataFim, Unidade unidade, TipoEntidade tipoEntidade) {
		
		List<Tuple> resultado = relatorioService.porEntidade(tipoContrato, centrocusto, cnpj, 
				dataInicio, dataFim, unidade, tipoEntidade);
		
		model.addAttribute("resultado", resultado);
		model.addAttribute("tipoC", tipoContrato);
		model.addAttribute("centroC", centrocusto);
		model.addAttribute("cnpjc", cnpj);
		model.addAttribute("dataI", dataInicio);
		model.addAttribute("dataF", dataFim);
		model.addAttribute("tipoE", tipoEntidade);
		model.addAttribute("unid", unidade);
		
		return "relatorios/resultadoporentidade";
	}
	
	@GetMapping("/tipocontrato")
	public String porTipoContrato() {
		return "relatorios/portipocontrato";
	}
	
	@GetMapping("/tipocontrato/gerar")
	public String gerarPorTipoContrato(ModelMap model, 	CentroDeCusto centrocusto, @RequestParam("dataInicio") LocalDate dataInicio,
			@RequestParam("dataFim") LocalDate dataFim, Unidade unidade) {
		
		List<Tuple> resultado = relatorioService.porTipoContrato(centrocusto,  
				dataInicio, dataFim, unidade);
		
		model.addAttribute("resultado", resultado);
		model.addAttribute("centroC", centrocusto);
		model.addAttribute("dataI", dataInicio);
		model.addAttribute("dataF", dataFim);
		model.addAttribute("unid", unidade);
		
		return "relatorios/resultadoportipocontrato";
	}

	@GetMapping("/centrodecusto")
	public String porCentroDeCusto() {
		return "relatorios/porcentrodecusto";
	}
	
	@GetMapping("/centrodecusto/gerar")
	public String gerarPorCentroDeCusto(ModelMap model, 	CentroDeCusto centrocusto, @RequestParam("dataInicio") LocalDate dataInicio,
			@RequestParam("dataFim") LocalDate dataFim, Unidade unidade) {
		
		List<Tuple> resultado = relatorioService.porCentroDeCusto(centrocusto, dataInicio, dataFim, unidade);
		
		model.addAttribute("resultado", resultado);
		model.addAttribute("centroC", centrocusto);
		model.addAttribute("dataI", dataInicio);
		model.addAttribute("dataF", dataFim);
		model.addAttribute("unid", unidade);
		
		return "relatorios/resultadoporcentrodecusto";
	}
	
	@GetMapping("/porvencimento")
	public String porVencimento() {
		return "relatorios/porvencimento";
	}
	
	@GetMapping("/porvencimento/gerar")
	public String gerarPorCentroDeCusto(ModelMap model, TipoContrato tipoContrato, CentroDeCusto centrocusto, Unidade unidade) {
		
		List<Tuple> resultado = relatorioService.porVencimento(tipoContrato, centrocusto,  unidade);
		
		model.addAttribute("resultado", resultado);
		model.addAttribute("centroC", centrocusto);
		model.addAttribute("tipoC", tipoContrato);
		model.addAttribute("unid", unidade);
		
		return "relatorios/resultadoporvencimento";
	}
	
	@ModelAttribute("tiposContrato")
	public List<TipoContrato> getTipoContrato() {
		return tipoContratoService.buscarTodos(); 
	}
	
	@ModelAttribute("centrocusto")
	public List<CentroDeCusto> getCentrosDeCusto(){
		return centroCustoService.buscarTodos();
	}
	
	@ModelAttribute("unidades")
	public List<Unidade> getUnidades(){
		return unidadeService.buscarTodos();
	}
	
	@ModelAttribute("emissor")
	public Emissor[] getEmissores() {
		return Emissor.values();
	}
	
	@ModelAttribute("tiposEntidade")
	public TipoEntidade[] getTiposEntidade() {
		return TipoEntidade.values();
	}
}

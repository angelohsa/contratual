package br.com.empresa.contratos.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.empresa.contratos.models.CentroDeCusto;
import br.com.empresa.contratos.models.Contraparte;
import br.com.empresa.contratos.models.Contrato;
import br.com.empresa.contratos.models.Departamento;
import br.com.empresa.contratos.models.Emissor;
import br.com.empresa.contratos.models.TipoContrato;
import br.com.empresa.contratos.models.TipoResgistro;
import br.com.empresa.contratos.models.Unidade;
import br.com.empresa.contratos.services.CentroDeCustoService;
import br.com.empresa.contratos.services.ContraparteService;
import br.com.empresa.contratos.services.ContratoService;
import br.com.empresa.contratos.services.DepartamentoService;
import br.com.empresa.contratos.services.TipoContratoService;
import br.com.empresa.contratos.services.UnidadeService;

@Controller
@RequestMapping("/contrato")
public class ContratoController {

	@Autowired
	private ContratoService contratoService;
	
	@Autowired
	private CentroDeCustoService centroCustoService;
	
	@Autowired
	private ContraparteService contraparteService;
	
	@Autowired
	private DepartamentoService deptoService;
	
	@Autowired
	private TipoContratoService tipoContratoService;
	
	@Autowired
	private UnidadeService unidadeService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Contrato contrato) {
		return "contrato/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Contrato contrato) {
		contratoService.salvar(contrato);
		return "redirect:/contrato/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable Long id, ModelMap model) {
		model.addAttribute("contrato", contratoService.buscarPorId(id));
		return "contrato/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Contrato contrato) {
		contratoService.editar(contrato);
		return "redirect:/contrato/cadastrar";
	}
	
	@GetMapping("/lancaraditivo/{id}")
	public String lancarAditivo(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("contrato", contratoService.buscarPorId(id));
		model.addAttribute("aditivo", true);
		return "contrato/cadastro";
	}
	
	@GetMapping("/lancardistrato/{id}")
	public String lancarDistrato(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("contrato", contratoService.buscarPorId(id));
		model.addAttribute("distrato", true);
		return "contrato/cadastro";
	}
	
	@GetMapping("/pesquisar")
	public String listar(Contrato contrato, ModelMap model){
		return "contrato/lista";
	}
	

	@GetMapping("/buscar")
	public String pesquisar(Contrato contrato, ModelMap model){
		model.addAttribute("contratos", contratoService.pesquisar(contrato));
		return "contrato/lista";
	}
	
	@ModelAttribute("custos")
	public List<CentroDeCusto> getCentrosDeCusto() {
		return centroCustoService.buscarTodos();
	}
	
	@ModelAttribute("contrapartes")
	public List<Contraparte> getContrapartes() {
		return contraparteService.buscarTodos();
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> getDepartamentos() {
		return deptoService.buscarTodos();
	}
	

	@ModelAttribute("tiposcontrato")
	public List<TipoContrato> getTiposContrato() {
		return tipoContratoService.buscarTodos();
	}
	
	@ModelAttribute("unidades")
	public List<Unidade> getUnidades() {
		return unidadeService.buscarTodos();
	}
	
	@ModelAttribute("emissor")
	public Emissor[] getEmissores() {
		return Emissor.values();
	}
	
	@ModelAttribute("tiposRegistro")
	public TipoResgistro[] getTiposRegistro() {
		return TipoResgistro.values();
	}
}

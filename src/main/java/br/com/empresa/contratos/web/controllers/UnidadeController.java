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

import br.com.empresa.contratos.models.Empresa;
import br.com.empresa.contratos.models.Unidade;
import br.com.empresa.contratos.services.EmpresaService;
import br.com.empresa.contratos.services.UnidadeService;

@Controller
@RequestMapping("/unidade")
public class UnidadeController {

	@Autowired
	private UnidadeService unidadeService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Unidade unidade) {
		return "unidade/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Unidade unidade) {
		unidadeService.salvar(unidade);
		return "redirect:/unidade/cadastrar";
		
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable Long id, ModelMap model) {
		model.addAttribute("unidade", unidadeService.buscarPorId(id));
		model.addAttribute("empresas", empresaService.buscarTodos());
		return "unidade/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Unidade unidade) {
		unidadeService.editar(unidade);
		return "redirect:/unidade/cadastrar";
	}
	
	@ModelAttribute("empresas")
	public List<Empresa> getEmpresas() {
		return empresaService.buscarTodos();
	}
	
	@ModelAttribute("unidades")
	public List<Unidade> getUnidades(){
		return unidadeService.buscarTodos();
	}
}

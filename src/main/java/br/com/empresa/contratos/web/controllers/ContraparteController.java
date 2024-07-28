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

import br.com.empresa.contratos.models.Contraparte;
import br.com.empresa.contratos.models.TipoEntidade;
import br.com.empresa.contratos.services.ContraparteService;

@Controller
@RequestMapping("/contraparte")
public class ContraparteController {

	@Autowired
	private ContraparteService contraparteService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Contraparte contraparte) {
		return "contraparte/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Contraparte contraparte) {
		contraparteService.salvar(contraparte);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable Long id, ModelMap model) {
		model.addAttribute("contraparte", contraparteService.buscarPorId(id));
		return "contraparte/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Contraparte contraparte) {
		contraparteService.editar(contraparte);
		return "redirect:/contraparte/cadastrar"; 
	}
	
	@ModelAttribute("tiposEntidade")
	public TipoEntidade[] getEmissores() {
		return TipoEntidade.values();
	}
	
	@ModelAttribute("contrapartes")
	public List<Contraparte> getContrapartes(){
		return contraparteService.buscarTodos();
	}
}

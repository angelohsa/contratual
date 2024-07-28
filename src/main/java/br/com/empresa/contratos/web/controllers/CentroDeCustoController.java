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
import br.com.empresa.contratos.services.CentroDeCustoService;

@Controller
@RequestMapping("/centrocusto")
public class CentroDeCustoController {

	@Autowired
	private CentroDeCustoService centroDeCustoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(CentroDeCusto centroDeCusto, ModelMap model) {
		return "centrocusto/cadastro";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable Long id, ModelMap model) {
		model.addAttribute("centroDeCusto", centroDeCustoService.buscarPorId(id));
		return "centrocusto/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(CentroDeCusto centroDeCusto) {
		centroDeCustoService.editar(centroDeCusto);
		return "redirect:/centrocusto/cadastrar";
	}
	
	
	@PostMapping("/salvar")
	public String salvar(CentroDeCusto centroDeCusto) {
		centroDeCustoService.salvar(centroDeCusto);
		return "redirect:/centrocusto/cadastrar";
	}
	
	@ModelAttribute("centros")
	public List<CentroDeCusto> getCentros(){
		return centroDeCustoService.buscarTodos();
	}
	
}

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

import br.com.empresa.contratos.models.Departamento;
import br.com.empresa.contratos.services.DepartamentoService;

@Controller
@RequestMapping("/departamento")
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		return "departamento/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Departamento departamento) {
		departamentoService.salvar(departamento);
		return "redirect:/departamento/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable Long id, ModelMap model) {
		model.addAttribute("departamento", departamentoService.buscarPorId(id));
		return "departamento/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Departamento departamento) {
		departamentoService.editar(departamento);
		return "redirect:/departamento/cadastrar";
	}
	
	@ModelAttribute("deptos")
	public List<Departamento> getDeptos(){
		return departamentoService.buscarTodos();
	}
}

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
import br.com.empresa.contratos.services.EmpresaService;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Empresa empresa) {
		return "empresa/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Empresa empresa) {
		empresaService.salvar(empresa);
		return "redirect:/empresa/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable Long id, ModelMap model) {
		model.addAttribute("empresa", empresaService.buscarPorId(id));
		return "empresa/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Empresa empresa) {
		empresaService.editar(empresa);
		return "redirect:/empresa/cadastrar";
	}
	
	@ModelAttribute("empresas")
	public List<Empresa> getEmpresas(){
		return empresaService.buscarTodos();
	}
}

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

import br.com.empresa.contratos.models.TipoContrato;
import br.com.empresa.contratos.services.TipoContratoService;

@Controller
@RequestMapping("/tipocontrato")
public class TipoContratoController {

	@Autowired
	private TipoContratoService tipoContratoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(TipoContrato tipoContrato) {
		return "tipocontrato/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(TipoContrato tipoContrato) {
		tipoContratoService.salvar(tipoContrato);
		return "redirect:/tipocontrato/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable Long id, ModelMap model) {
		model.addAttribute("tipoContrato", tipoContratoService.buscarPorId(id));
		return "tipocontrato/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(TipoContrato tipoContrato) {
		tipoContratoService.editar(tipoContrato);
		return "redirect:/tipocontrato/cadastrar";
	}
	
	@ModelAttribute("tiposContrato")
	public List<TipoContrato> getTipos(){
		return tipoContratoService.buscarTodos();
	}
}

package br.com.empresa.contratos.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.empresa.contratos.services.RelatorioService;

@Controller
public class HomeController {
	
	@Autowired
	private RelatorioService relatorioService;

	@GetMapping("/")
	public String home(ModelMap model) {
		model.addAttribute("qtdeReg", relatorioService.getQuantidadeDeRegistros());
		model.addAttribute("qtdeCentro", relatorioService.getQuantidadePorCentroCusto());
		model.addAttribute("qtdeTipo", relatorioService.getQuantidadePorTipo());
		model.addAttribute("venc", relatorioService.getVenciment90Dias());
		model.addAttribute("qtdeUnid", relatorioService.getQuantidadePorUnidade());
		return "home";
	}
}

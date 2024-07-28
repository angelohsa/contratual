package br.com.empresa.contratos.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.empresa.contratos.models.Empresa;
import br.com.empresa.contratos.services.EmpresaService;

@Component
public class StringToEmpresaConversor implements Converter<String, Empresa> {
	
	@Autowired
	private EmpresaService service;

	@Override
	public Empresa convert(String texto) {
		if (texto == null || texto.isEmpty()) {
			return null;
		}
		
		Long id = Long.parseLong(texto);
		return service.buscarPorId(id);
		
	}

}

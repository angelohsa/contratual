package br.com.empresa.contratos.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.empresa.contratos.models.Departamento;
import br.com.empresa.contratos.services.DepartamentoService;

@Component
public class StringToDepartamentoConversor implements Converter<String, Departamento> {

	@Autowired
	private DepartamentoService service;
	
	@Override
	public Departamento convert(String source) {
		if (null == source || source.isEmpty()) {
			return null;
		}
		
		Long id = Long.parseLong(source);
		return service.buscarPorId(id);
	}

}

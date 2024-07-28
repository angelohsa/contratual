package br.com.empresa.contratos.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.empresa.contratos.models.Contraparte;
import br.com.empresa.contratos.services.ContraparteService;

@Component
public class StringToContraparteConversor implements Converter<String, Contraparte> {

	@Autowired
	private ContraparteService service;
	
	@Override
	public Contraparte convert(String source) {
		
		if (null == source || source.isEmpty()) {
			return null;
		}
		
		Long id = Long.parseLong(source);
		return service.buscarPorId(id);
		
	}

}

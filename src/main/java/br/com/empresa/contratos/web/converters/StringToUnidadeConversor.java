package br.com.empresa.contratos.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.empresa.contratos.models.Unidade;
import br.com.empresa.contratos.services.UnidadeService;

@Component
public class StringToUnidadeConversor implements Converter<String, Unidade>{

	@Autowired
	private UnidadeService service;
	
	@Override
	public Unidade convert(String source) {
		if (null == source || source.isEmpty()) {
			return null;
		}
		
		Long id = Long.parseLong(source);
		return service.buscarPorId(id);
	}

}

package br.com.empresa.contratos.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.empresa.contratos.models.CentroDeCusto;
import br.com.empresa.contratos.services.CentroDeCustoService;

@Component
public class StringToCentroDeCustoConversor implements Converter<String, CentroDeCusto> {

	@Autowired
	private CentroDeCustoService service;
	
	@Override
	public CentroDeCusto convert(String source) {
		if (null == source || source.isEmpty()) {
			return null;
		}
		
		Long id = Long.parseLong(source);
		return service.buscarPorId(id);
	}

}

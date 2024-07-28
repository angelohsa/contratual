package br.com.empresa.contratos.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.empresa.contratos.models.TipoContrato;
import br.com.empresa.contratos.services.TipoContratoService;

@Component
public class StringToTipoContratoConversor implements Converter<String, TipoContrato> {

	@Autowired
	private TipoContratoService service;

	@Override
	public TipoContrato convert(String source) {
		if (source == null || source.isEmpty()) {
			return null;
		}

		Long id = Long.parseLong(source);
		return service.buscarPorId(id);
	}

}

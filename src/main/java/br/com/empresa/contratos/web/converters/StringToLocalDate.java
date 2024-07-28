package br.com.empresa.contratos.web.converters;

import java.time.LocalDate;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToLocalDate implements Converter<String, LocalDate> {

	@Override
	public LocalDate convert(String source) {
		if (source.equals(""))
			return null;
			
		return LocalDate.of(Integer.parseInt(source.split("-")[0]),
				Integer.parseInt(source.split("-")[1]), 
				Integer.parseInt(source.split("-")[2]));
	}

}

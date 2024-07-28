package br.com.empresa.contratos.daos;

import java.util.List;

import br.com.empresa.contratos.models.TipoContrato;

public interface TipoContratoDAO {
	void save(TipoContrato tipoContrato);
	
	void update(TipoContrato tipoContrato);
	
	void delete(Long id);

	TipoContrato findById(Long id);
	
	List<TipoContrato> findAll();
	
	TipoContrato buscarPOrDescricao(String descricao);
}

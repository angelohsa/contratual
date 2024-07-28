package br.com.empresa.contratos.services;

import java.util.List;

import br.com.empresa.contratos.models.TipoContrato;

public interface TipoContratoService {

	void salvar(TipoContrato tipoContrato);
	
	void editar(TipoContrato tipoContrato);
	
	void excluir(Long id);

	TipoContrato buscarPorId(Long id);
	
	List<TipoContrato> buscarTodos();
	
	TipoContrato buscarPorDescricao(String descricao);
}

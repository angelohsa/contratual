package br.com.empresa.contratos.services;

import java.util.List;

import br.com.empresa.contratos.models.Unidade;

public interface UnidadeService {
	void salvar( Unidade  unidade);
	
	void editar( Unidade  unidade);
	
	void excluir(Long id);
	
	Unidade buscarPorId(Long id);
	
	List<Unidade> buscarTodos();
	
	Unidade buscarPorDimensao(String unidade);
}

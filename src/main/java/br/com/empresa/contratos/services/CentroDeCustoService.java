package br.com.empresa.contratos.services;

import java.util.List;

import br.com.empresa.contratos.models.CentroDeCusto;

public interface CentroDeCustoService {
	void salvar( CentroDeCusto  centroDeCusto);
	
	void editar( CentroDeCusto  centroDeCusto);
	
	void excluir(Long id);
	
	CentroDeCusto buscarPorId(Long id);
	
	List<CentroDeCusto> buscarTodos();
	
	CentroDeCusto buscarPorCodigo(String codigo);
}

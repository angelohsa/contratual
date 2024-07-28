package br.com.empresa.contratos.services;

import java.util.List;

import br.com.empresa.contratos.models.Departamento;

public interface DepartamentoService {
	void salvar( Departamento  departamento);
	
	void editar( Departamento  departamento);
	
	void excluir(Long id);
	
	Departamento buscarPorId(Long id);
	
	List<Departamento> buscarTodos();
	
	Departamento buscarPorNome(String nome);
}

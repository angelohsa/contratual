package br.com.empresa.contratos.services;

import java.util.List;

import br.com.empresa.contratos.models.Empresa;

public interface EmpresaService {
	void salvar( Empresa  empresa);
	
	void editar( Empresa  empresa);
	
	void excluir(Long id);

	Empresa buscarPorId(Long id);
	
	List<Empresa> buscarTodos();
}

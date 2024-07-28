package br.com.empresa.contratos.daos;

import java.util.List;

import br.com.empresa.contratos.models.Departamento;

public interface DepartamentoDAO {
	void save(Departamento departamento);

	void update(Departamento departamento);

	void delete(Long id);
	
	Departamento findById(Long id);
	
	List<Departamento> findAll();
	
	Departamento buscarPorNome(String nome);
}

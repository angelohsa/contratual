package br.com.empresa.contratos.daos;

import java.util.List;

import br.com.empresa.contratos.models.Empresa;

public interface EmpresaDAO {
	void save(Empresa empresa);
	
	void update(Empresa empresa);
	
	void delete(Long id);

	Empresa findById(Long id);
	
	List<Empresa> findAll();
}

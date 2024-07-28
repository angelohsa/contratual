package br.com.empresa.contratos.daos;

import java.util.List;

import br.com.empresa.contratos.models.Unidade;

public interface UnidadeDAO {
	void save(Unidade unidade);
	
	void update(Unidade unidade);
	
	void delete(Long id);
	
	Unidade findById(Long id);
	
	List<Unidade> findAll();
	
	Unidade buscarPorDimensao(String unidade);
}

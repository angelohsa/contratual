package br.com.empresa.contratos.daos;

import java.util.List;

import br.com.empresa.contratos.models.CentroDeCusto;

public interface CentroDeCustoDAO {
	void save(CentroDeCusto centroDeCusto);
	
	void update(CentroDeCusto centroDeCusto);
	
	void delete(Long id);
	
	CentroDeCusto findById(Long id);
	
	List<CentroDeCusto> findAll();
	
	CentroDeCusto buscarPorCodigo(String codigo);
}

package br.com.empresa.contratos.daos;

import java.util.List;

import br.com.empresa.contratos.models.Contrato;

public interface ContratoDAO {
	void save(Contrato contrato);
	
	void update(Contrato contrato);
	
	void delete(Long id);
	
	Contrato findById(Long id);
	
	List<Contrato> findAll();
	
	List<Contrato> search(Contrato contrato);
	
	Contrato buscarPorCodigoProcesso(String codigoProcesso);
}

package br.com.empresa.contratos.services;

import java.util.List;

import br.com.empresa.contratos.models.Contrato;

public interface ContratoService {

	void salvar(Contrato contrato);
	
	void editar(Contrato contrato);
	
	void excluir(Long ig);
	
	Contrato buscarPorId(Long id);
	
	List<Contrato> buscarTodos();
	
	List<Contrato> pesquisar(Contrato contrato);
	
	Contrato buscarPorCodigoProcesso(String codigoProcesso);
}

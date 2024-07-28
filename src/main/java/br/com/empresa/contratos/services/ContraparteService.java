package br.com.empresa.contratos.services;

import java.util.List;
import java.util.Map;

import br.com.empresa.contratos.models.Contraparte;
import br.com.empresa.contratos.models.TipoEntidade;

public interface ContraparteService {
	void salvar( Contraparte  contraparte);
	
	void salvar(Map<String, String> mapa);
	
	void editar( Contraparte  contraparte);
	
	void excluir(Long id);
	
	Contraparte buscarPorId(Long id);
	
	List<Contraparte> buscarTodos();

	List<Contraparte> buscarPorCNPJ(String cnpj);
	
	Contraparte buscarPorCNPJ(String cnpj, TipoEntidade tipoEntidade);
	
}

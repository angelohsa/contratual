package br.com.empresa.contratos.daos;

import java.util.List;

import br.com.empresa.contratos.models.Contraparte;
import br.com.empresa.contratos.models.TipoEntidade;

public interface ContraparteDAO {
	void save(Contraparte contraparte);
	
	void update(Contraparte contraparte);
	
	void delete(Long id);
	
	Contraparte findById(Long id);
	
	List<Contraparte> findAll();
	
	List<Contraparte> findByCNPJ(String cnpj);
	
	Contraparte findByCNPJ(String cnpjcpfnum, TipoEntidade tipoEntidade);
}

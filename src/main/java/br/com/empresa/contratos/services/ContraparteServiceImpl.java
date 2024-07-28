package br.com.empresa.contratos.services;

import java.util.List;
import java.util.Map;

import jakarta.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.empresa.contratos.daos.ContraparteDAO;
import br.com.empresa.contratos.models.Contraparte;
import br.com.empresa.contratos.models.TipoEntidade;

@Service
@Transactional
public class ContraparteServiceImpl implements ContraparteService {
	
	@Autowired
	private ContraparteDAO contraparteDAO;

	@Override
	@Transactional(readOnly=false)
	public void salvar(Contraparte contraparte) {
		contraparteDAO.save(contraparte);
		
	}

	@Override
	@Transactional(readOnly=false)
	public void editar(Contraparte contraparte) {
		contraparteDAO.update(contraparte);
			
	}

	@Override
	@Transactional(readOnly=false)
	public void excluir(Long id) {
		contraparteDAO.delete(id);
				
	}

	@Override
	@Transactional(readOnly=true)
	public Contraparte buscarPorId(Long id) {
		return contraparteDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Contraparte> buscarTodos() {
		return contraparteDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Contraparte> buscarPorCNPJ(String cnpj) {
		return contraparteDAO.findByCNPJ(cnpj);
	}

	@Override
	@Transactional(readOnly=true)
	public Contraparte buscarPorCNPJ(String cnpj, TipoEntidade tipoEntidade) throws NoResultException{
		return contraparteDAO.findByCNPJ(cnpj, tipoEntidade);
	}

	@Override
	@Transactional(readOnly=false)
	public void salvar(Map<String, String> mapa) {
		Contraparte contraparte = new Contraparte();
		
		if (mapa.get("$EMISSOR").equals("Fornecedor")) {
			contraparte.setCodigoContraparte(mapa.get("$CODIGO_FORNECEDOR"));
			contraparte.setTipoEntidade(TipoEntidade.F );
		} else {
			contraparte.setCodigoContraparte(mapa.get("$CODIGO_CLIENTE"));
			contraparte.setTipoEntidade(TipoEntidade.C  );
		}
		
		contraparte.setCnpjcpfnum(mapa.get("$CNPJ"));
		contraparte.setRazaoSocial(mapa.get("$RAZAO_SOCIAL"));
		contraparteDAO.save(contraparte);

	}

}

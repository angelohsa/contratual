package br.com.empresa.contratos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.empresa.contratos.daos.ContratoDAO;
import br.com.empresa.contratos.models.Contrato;

@Service
@Transactional
public class ContratoServiceImpl implements ContratoService {

	@Autowired
	private ContratoDAO contratoDAO;
	
	@Override
	@Transactional(readOnly=false)
	public void salvar(Contrato contrato) {
		contratoDAO.save(contrato);

	}

	@Override
	@Transactional(readOnly=false)
	public void editar(Contrato contrato) {
		contratoDAO.update(contrato);

	}

	@Override
	@Transactional(readOnly=false)
	public void excluir(Long id) {
		contratoDAO.delete(id);

	}

	@Override
	@Transactional(readOnly=true)
	public Contrato buscarPorId(Long id) {
		return contratoDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Contrato> buscarTodos() {
		return contratoDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Contrato> pesquisar(Contrato contrato) {
		return contratoDAO.search(contrato);
	}

	@Override
	@Transactional(readOnly=true)
	public Contrato buscarPorCodigoProcesso(String codigoProcesso) {
		return contratoDAO.buscarPorCodigoProcesso(codigoProcesso);
	}

}

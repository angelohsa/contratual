package br.com.empresa.contratos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.empresa.contratos.daos.TipoContratoDAO;
import br.com.empresa.contratos.models.TipoContrato;

@Service
@Transactional
public class TipoContratoServiceImpl implements TipoContratoService {

	@Autowired
	private TipoContratoDAO tipoContratoDAO;
	
	@Override
	@Transactional(readOnly=false)
	public void salvar(TipoContrato tipoContrato) {
		tipoContratoDAO.save(tipoContrato);

	}

	@Override
	@Transactional(readOnly=false)
	public void editar(TipoContrato tipoContrato) {
		tipoContratoDAO.update(tipoContrato);

	}

	@Override
	@Transactional(readOnly=false)
	public void excluir(Long id) {
		tipoContratoDAO.delete(id);
	}

	@Override
	@Transactional(readOnly=true)
	public TipoContrato buscarPorId(Long id) {
		return tipoContratoDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoContrato> buscarTodos() {
		return tipoContratoDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public TipoContrato buscarPorDescricao(String descricao) {
		return tipoContratoDAO.buscarPOrDescricao(descricao);
	}

}

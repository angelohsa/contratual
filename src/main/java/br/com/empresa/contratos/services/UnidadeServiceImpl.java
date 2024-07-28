package br.com.empresa.contratos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.empresa.contratos.daos.UnidadeDAO;
import br.com.empresa.contratos.models.Unidade;

@Service
public class UnidadeServiceImpl implements UnidadeService {

	@Autowired
	private UnidadeDAO unidadeDAO;
	
	@Override
	@Transactional(readOnly=false)
	public void salvar(Unidade unidade) {
		unidadeDAO.save(unidade);
	}

	@Override
	@Transactional(readOnly=false)
	public void editar(Unidade unidade) {
		unidadeDAO.update(unidade);

	}

	@Override
	@Transactional(readOnly=false)
	public void excluir(Long id) {
		unidadeDAO.delete(id);

	}

	@Override
	@Transactional(readOnly=true)
	public Unidade buscarPorId(Long id) {
		return unidadeDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Unidade> buscarTodos() {
		return unidadeDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Unidade buscarPorDimensao(String unidade) {
		return unidadeDAO.buscarPorDimensao(unidade);
	}

}

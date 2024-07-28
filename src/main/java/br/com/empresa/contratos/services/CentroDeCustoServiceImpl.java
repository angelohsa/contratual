package br.com.empresa.contratos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.empresa.contratos.daos.CentroDeCustoDAO;
import br.com.empresa.contratos.models.CentroDeCusto;

@Service
@Transactional
public class CentroDeCustoServiceImpl implements CentroDeCustoService {

	@Autowired
	private CentroDeCustoDAO centroDeCustoDAO; 
	
	@Override
	@Transactional(readOnly=false)
	public void salvar(CentroDeCusto centroDeCusto) {
		centroDeCustoDAO.save(centroDeCusto);

	}

	@Override
	@Transactional(readOnly=false)
	public void editar(CentroDeCusto centroDeCusto) {
		centroDeCustoDAO.update(centroDeCusto);

	}

	@Override
	@Transactional(readOnly=false)
	public void excluir(Long id) {
		centroDeCustoDAO.delete(id);

	}

	@Override
	@Transactional(readOnly=true)
	public CentroDeCusto buscarPorId(Long id) {
		return centroDeCustoDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CentroDeCusto> buscarTodos() {
		return centroDeCustoDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public CentroDeCusto buscarPorCodigo(String codigo) {
		return centroDeCustoDAO.buscarPorCodigo(codigo);
	}

}

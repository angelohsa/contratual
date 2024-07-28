package br.com.empresa.contratos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.empresa.contratos.daos.DepartamentoDAO;
import br.com.empresa.contratos.models.Departamento;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoDAO departamentoDAO;
	
	@Override
	@Transactional(readOnly=false)
	public void salvar(Departamento departamento) {
		departamentoDAO.save(departamento);

	}

	@Override
	@Transactional(readOnly=false)
	public void editar(Departamento departamento) {
		departamentoDAO.update(departamento);

	}

	@Override
	@Transactional(readOnly=false)
	public void excluir(Long id) {
		departamentoDAO.delete(id);

	}

	@Override
	@Transactional(readOnly=true)
	public Departamento buscarPorId(Long id) {
		return departamentoDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Departamento> buscarTodos() {
		return departamentoDAO.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Departamento buscarPorNome(String nome) {
		return departamentoDAO.buscarPorNome(nome);
	}

}

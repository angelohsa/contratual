package br.com.empresa.contratos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.empresa.contratos.daos.EmpresaDAO;
import br.com.empresa.contratos.models.Empresa;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaDAO empresaDAO;
	
	@Override
	@Transactional(readOnly=false)
	public void salvar(Empresa empresa) {
		empresaDAO.save(empresa);

	}

	@Override
	@Transactional(readOnly=false)
	public void editar(Empresa empresa) {
		empresaDAO.update(empresa);

	}

	@Override
	@Transactional(readOnly=false)
	public void excluir(Long id) {
		empresaDAO.delete(id);

	}

	@Override
	@Transactional(readOnly=true)
	public Empresa buscarPorId(Long id) {
		return empresaDAO.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Empresa> buscarTodos() {
		return empresaDAO.findAll();
	}


}

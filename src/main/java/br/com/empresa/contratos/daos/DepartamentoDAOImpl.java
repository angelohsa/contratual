package br.com.empresa.contratos.daos;

import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.empresa.contratos.models.Departamento;

@Repository
public class DepartamentoDAOImpl extends AbstractDAO<Departamento, Long> implements DepartamentoDAO {

	@Override
	public Departamento buscarPorNome(String nome) {
		String sql = "from Departamento d where d.nome = :nome";
		TypedQuery<Departamento> query = entityManager.createQuery(sql, Departamento.class);
		query.setParameter("nome", nome);
		return query.getSingleResult();
	}


}

package br.com.empresa.contratos.daos;

import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.empresa.contratos.models.Unidade;

@Repository
public class UnidadeDAOImpl extends AbstractDAO<Unidade, Long> implements UnidadeDAO {

	@Override
	public Unidade buscarPorDimensao(String unidade) {
		String sql = "from Unidade u where u.dimensaoAx = :unidade";
		TypedQuery<Unidade> query = entityManager.createQuery(sql, Unidade.class);
		query.setParameter("unidade", unidade);
		return query.getSingleResult();
		
	}

}

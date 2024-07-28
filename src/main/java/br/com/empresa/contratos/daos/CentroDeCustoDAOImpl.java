package br.com.empresa.contratos.daos;

import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.empresa.contratos.models.CentroDeCusto;

@Repository
public class CentroDeCustoDAOImpl extends AbstractDAO<CentroDeCusto, Long> implements CentroDeCustoDAO {

	@Override
	public CentroDeCusto buscarPorCodigo(String codigo) {
		String sql = "from CentroDeCusto c where c.codigo = :codigo";
		TypedQuery<CentroDeCusto> query = entityManager.createQuery(sql, CentroDeCusto.class);
		query.setParameter("codigo", codigo);
		return query.getSingleResult();
	}


}

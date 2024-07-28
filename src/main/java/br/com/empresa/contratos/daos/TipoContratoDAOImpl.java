package br.com.empresa.contratos.daos;

import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.empresa.contratos.models.TipoContrato;

@Repository
public class TipoContratoDAOImpl extends AbstractDAO<TipoContrato, Long> implements TipoContratoDAO {

	@Override
	public TipoContrato buscarPOrDescricao(String descricao) {
		String sql = "from TipoContrato t where t.tipo = :descricao";
		TypedQuery<TipoContrato> query = entityManager.createQuery(sql, TipoContrato.class);
		query.setParameter("descricao", descricao);
		return query.getSingleResult();
	}

}

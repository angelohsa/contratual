package br.com.empresa.contratos.daos;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.empresa.contratos.models.Contraparte;
import br.com.empresa.contratos.models.TipoEntidade;

@Repository
public class ContraparteDAOImpl extends AbstractDAO<Contraparte, Long> implements ContraparteDAO {

	@Override
	public List<Contraparte> findByCNPJ(String cnpjcpfnum) {
		TypedQuery<Contraparte> query = entityManager
					.createQuery("from Contraparte c where c.cnpjcpfnum = :cnpjcpfnum", Contraparte.class);
		query.setParameter("cnpjcpfnum", cnpjcpfnum);
		return query.getResultList();
		
	}

	@Override
	public Contraparte findByCNPJ(String cnpjcpfnum, TipoEntidade tipoEntidade) throws NoResultException {
		TypedQuery<Contraparte> query = entityManager
				.createQuery("from Contraparte c where c.cnpjcpfnum "
						+ "= :cnpjcpfnum and c.tipoEntidade = :tipoEntidade", Contraparte.class);
			query.setParameter("cnpjcpfnum", cnpjcpfnum);
			query.setParameter("tipoEntidade", tipoEntidade);
			return query.getSingleResult();
	}


}

package br.com.empresa.contratos.daos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.empresa.contratos.models.Contrato;

@Repository
public class ContratoDAOImpl extends AbstractDAO<Contrato, Long> implements ContratoDAO {

	public List<Contrato> search(Contrato contrato){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contrato> query = builder.createQuery(Contrato.class);
		Root<Contrato> root = query.from(Contrato.class);

		List<Predicate> predicates = new ArrayList<>();
		
		if (!contrato.getCodigoProcesso().isEmpty()) {
			predicates.add(builder.equal(root.get("codigoProcesso"), contrato.getCodigoProcesso()));
		}

		if (!contrato.getCodigoContrato().isEmpty()) {
			predicates.add(builder.like(root.get("codigoContrato"), "%" + contrato.getCodigoContrato() + "%" ));
		}

		if (! (null == contrato.getEmissor())) {
			predicates.add(builder.equal(root.get("emissor"), contrato.getEmissor()));
		}
		
		if (!(null == contrato.getTipoContrato())) {
			predicates.add(builder.equal(root.get("tipoContrato"), contrato.getTipoContrato()));
		}

		if (!(null == contrato.getCentroDeCusto())) {
			predicates.add(builder.equal(root.get("centroDeCusto"), contrato.getCentroDeCusto()));
		}

		if (!(null == contrato.getDepartamento())) {
			predicates.add(builder.equal(root.get("departamento"), contrato.getDepartamento()));
		}
		
		if (!(null == contrato.getUnidade())) {
			predicates.add(builder.equal(root.get("unidade"), contrato.getUnidade()));
		}
		
		if (!(null == contrato.getDataInicio())) {
			predicates.add(builder.greaterThanOrEqualTo(root.<LocalDate>get("dataInicio"), contrato.getDataInicio()));
		}
		
		if (!(null == contrato.getDataFim())) {
			predicates
				.add(builder
					.or(builder
						.lessThanOrEqualTo(root.<LocalDate>get("dataFim"), contrato.getDataFim()),
						builder.lessThanOrEqualTo(root.<LocalDate>get("dataDistrato"), contrato.getDataFim())));
		}
		
		Predicate[] p = new Predicate[predicates.size()];
		
		for (int i = 0; i < predicates.size(); i++) {
			p[i] = predicates.get(i);
			
		}
		
		query.select(root).where(p );
		
		return entityManager.createQuery(query).getResultList();
	}
	
	public Contrato buscarPorCodigoProcesso(String codigoProcesso) {
		String sql = "from Contrato c where c.codigoProcesso = :codigoProcesso";
		TypedQuery<Contrato> query = entityManager.createQuery(sql, Contrato.class);
		query.setParameter("codigoProcesso", codigoProcesso);
		return query.getSingleResult();
	}


}

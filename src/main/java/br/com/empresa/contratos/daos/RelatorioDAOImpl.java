package br.com.empresa.contratos.daos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.empresa.contratos.models.CentroDeCusto;
import br.com.empresa.contratos.models.Contrato;
import br.com.empresa.contratos.models.TipoContrato;
import br.com.empresa.contratos.models.TipoEntidade;
import br.com.empresa.contratos.models.TipoResgistro;
import br.com.empresa.contratos.models.Unidade;

@Repository
public class RelatorioDAOImpl implements RelatorioDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Tuple> porUnidade(TipoContrato tipoContrato, CentroDeCusto centrocusto, 
			LocalDate dataInicio, LocalDate dataFim, String cnpj) {
		
		List<Predicate> predicates = new ArrayList<>();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
		Root<Contrato> contrato = criteriaQuery.from(Contrato.class);
		criteriaQuery.multiselect(contrato.get("unidade").get("nome"), 
				criteriaBuilder.count(contrato.get("codigoProcesso")) , 
				criteriaBuilder.sum(contrato.get("valor")) );

		if (tipoContrato.getId() != null)
			predicates.add(criteriaBuilder.equal(contrato.get("tipoContrato"), tipoContrato));
		
		if (centrocusto.getId() != null)
			predicates.add(criteriaBuilder.equal(contrato.get("centroDeCusto"), centrocusto));
		
		if (null != cnpj && !cnpj.equals(""))
			predicates.add(criteriaBuilder.equal(contrato.get("contraparte").get("cnpjcpfnum"), cnpj));
		
		if (null != dataInicio) 
			predicates.add(criteriaBuilder.greaterThanOrEqualTo(contrato.<LocalDate>get("dataInicio"), dataInicio));
		
		if (null != dataFim) 
			predicates.add(criteriaBuilder.lessThanOrEqualTo(contrato.<LocalDate>get("dataFim"), dataFim));

		criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

		criteriaQuery.groupBy(contrato.get("unidade").get("nome"));
				
		Query query = entityManager.createQuery(criteriaQuery);
		List<Tuple> results = query.getResultList();
		return results;
	}

	@Override
	public List<Tuple> porEntidade(TipoContrato tipoContrato, CentroDeCusto centrocusto, String cnpj,
			LocalDate dataInicio, LocalDate dataFim, Unidade unidade, TipoEntidade tipoEntidade) {
		
		List<Predicate> predicates = new ArrayList<>();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
		Root<Contrato> contrato = criteriaQuery.from(Contrato.class);
		criteriaQuery.multiselect(contrato.get("contraparte").get("razaoSocial"),
				contrato.get("contraparte").get("tipoEntidade"),
				contrato.get("tipoContrato").get("tipo"),
				criteriaBuilder.count(contrato.get("codigoProcesso")) , 
				criteriaBuilder.sum(contrato.get("valor")) );

		
		if (null != tipoEntidade)
			predicates.add(criteriaBuilder.equal(contrato.get("contraparte").get("tipoEntidade"), tipoEntidade));
			
		if (tipoContrato.getId() != null)
			predicates.add(criteriaBuilder.equal(contrato.get("tipoContrato"), tipoContrato));
		
		if (centrocusto.getId() != null)
			predicates.add(criteriaBuilder.equal(contrato.get("centroDeCusto"), centrocusto));
		
		if ( unidade.getId() != null)
			predicates.add(criteriaBuilder.equal(contrato.get("unidade"), unidade));
		
		if (null != cnpj && !cnpj.equals(""))
			predicates.add(criteriaBuilder.equal(contrato.get("contraparte").get("cnpjcpfnum"), cnpj));
		
		if (null != dataInicio) 
			predicates.add(criteriaBuilder.greaterThanOrEqualTo(contrato.<LocalDate>get("dataInicio"), dataInicio));
		
		if (null != dataFim) 
			predicates.add(criteriaBuilder.lessThanOrEqualTo(contrato.<LocalDate>get("dataFim"), dataFim));

		criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

		criteriaQuery.groupBy(contrato.get("contraparte").get("razaoSocial") ,
				contrato.get("contraparte").get("tipoEntidade"),
				contrato.get("tipoContrato").get("tipo") );
				
		Query query = entityManager.createQuery(criteriaQuery);
		List<Tuple> results = query.getResultList();
		return results;
	}

	@Override
	public List<Tuple> porTipoContrato(CentroDeCusto centrocusto,LocalDate dataInicio, LocalDate dataFim,
			Unidade unidade) {

		List<Predicate> predicates = new ArrayList<>();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
		Root<Contrato> contrato = criteriaQuery.from(Contrato.class);
		criteriaQuery.multiselect(contrato.get("tipoContrato").get("tipo"),
				criteriaBuilder.count(contrato.get("codigoProcesso")) , 
				criteriaBuilder.sum(contrato.get("valor")));

		
		if (centrocusto.getId() != null)
			predicates.add(criteriaBuilder.equal(contrato.get("centroDeCusto"), centrocusto));
		
		if ( unidade.getId() != null)
			predicates.add(criteriaBuilder.equal(contrato.get("unidade"), unidade));

		
		if (null != dataInicio) 
			predicates.add(criteriaBuilder.greaterThanOrEqualTo(contrato.<LocalDate>get("dataInicio"), dataInicio));
		
		if (null != dataFim) 
			predicates.add(criteriaBuilder.lessThanOrEqualTo(contrato.<LocalDate>get("dataFim"), dataFim));

		criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

		criteriaQuery.groupBy(contrato.get("tipoContrato").get("tipo") );
				
		Query query = entityManager.createQuery(criteriaQuery);
		List<Tuple> results = query.getResultList();
		return results;
	}

	@Override
	public List<Tuple> porCentroDeCusto(CentroDeCusto centrocusto, LocalDate dataInicio, LocalDate dataFim,
			Unidade unidade) {
		
		List<Predicate> predicates = new ArrayList<>();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
		Root<Contrato> contrato = criteriaQuery.from(Contrato.class);
		criteriaQuery.multiselect(contrato.get("centroDeCusto").get("descricao"),
				criteriaBuilder.count(contrato.get("codigoProcesso")) , 
				criteriaBuilder.sum(contrato.get("valor")));

		
		if (centrocusto.getId() != null)
			predicates.add(criteriaBuilder.equal(contrato.get("centroDeCusto"), centrocusto));
		
		if ( unidade.getId() != null)
			predicates.add(criteriaBuilder.equal(contrato.get("unidade"), unidade));

		
		if (null != dataInicio) 
			predicates.add(criteriaBuilder.greaterThanOrEqualTo(contrato.<LocalDate>get("dataInicio"), dataInicio));
		
		if (null != dataFim) 
			predicates.add(criteriaBuilder.lessThanOrEqualTo(contrato.<LocalDate>get("dataFim"), dataFim));

		criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

		criteriaQuery.groupBy(contrato.get("centroDeCusto").get("descricao") );
				
		Query query = entityManager.createQuery(criteriaQuery);
		List<Tuple> results = query.getResultList();
		return results;
	}

	@Override
	public List<Tuple> porVencimento(TipoContrato tipoContrato, CentroDeCusto centrocusto, Unidade unidade) {
		
		
		List<Predicate> predicates = new ArrayList<>();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
		Root<Contrato> contrato = criteriaQuery.from(Contrato.class);
		criteriaQuery.multiselect(contrato.get("codigoProcesso"),
				contrato.get("codigoContrato"),
				contrato.get("contraparte").get("razaoSocial") ,
				contrato.get("tipoContrato").get("tipo"),
				contrato.get("unidade").get("nome"),
				criteriaBuilder.selectCase()
				.when(criteriaBuilder.equal(
						contrato.get("tipoRegistro"), TipoResgistro.D),
						contrato.get("dataDistrato"))
				.otherwise(contrato.get("dataFim")));

		if (tipoContrato.getId() != null)
			predicates.add(criteriaBuilder.equal(contrato.get("tipoContrato"), tipoContrato));
		
		if (centrocusto.getId() != null)
			predicates.add(criteriaBuilder.equal(contrato.get("centroDeCusto"), centrocusto));
		
		if ( unidade.getId() != null)
			predicates.add(criteriaBuilder.equal(contrato.get("unidade"), unidade));

		LocalDate hoje = LocalDate.now();
		LocalDate noventaDias = hoje.plusDays(90);
		
		predicates
		.add(criteriaBuilder
			.or(criteriaBuilder
				.between(contrato.<LocalDate>get("dataFim"), hoje, noventaDias),
				criteriaBuilder
				.between(contrato.<LocalDate>get("dataDistrato"),hoje, noventaDias)));
		
		criteriaQuery.orderBy(criteriaBuilder.asc(contrato.get("dataFim")));
		criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
		
		Query query = entityManager.createQuery(criteriaQuery);
		List<Tuple> results = query.getResultList();
		return results;
	}

	@Override
	public List<Tuple> getQuantidadeDeRegistros() {
		String jpql = "select case c.tipoRegistro when 'C' then 'Contratos' "
				+ "when 'A' then 'Aditivos' when 'D' then 'Distratos' end , count(c.id) "
				+ " from Contrato c group by c.tipoRegistro order by 'qtde' desc";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Tuple> getQuantidadePorCentroCusto() {
		String jpql = "select c.centroDeCusto.descricao, count(c.codigoProcesso)  "
				+ "from Contrato c group by c.centroDeCusto order by count(c.codigoProcesso) desc ";
		return entityManager.createQuery(jpql).setMaxResults(10).getResultList();
	}

	@Override
	public List<Tuple> getQuantidadePorTipo() {
		String jpql = "select c.tipoContrato.tipo, count(c.id)  "
				+ "from Contrato c group by c.tipoContrato order by count(c.tipoContrato) desc ";
		return entityManager.createQuery(jpql).setMaxResults(10).getResultList();

	}

	@Override
	public List<Long> getVenciment90Dias() {
		LocalDate hoje = LocalDate.now();
		LocalDate trintaDias = hoje.plusDays(30);
		LocalDate sessentaDias = hoje.plusDays(60);
		LocalDate noventeDias = hoje.plusDays(90);
		
		String jpql = "SELECT  count(c.id) FROM Contrato  c "
				+ "where c.dataFim between :hojeF and :diasF "
				+ "or c.dataDistrato between :hojeD and :diasD ";
				
		Query query30 = entityManager.createQuery(jpql);		 
		query30.setParameter("hojeF", hoje);
		query30.setParameter("diasF", trintaDias);
		query30.setParameter("hojeD", hoje);
		query30.setParameter("diasD", trintaDias);
		Long t = (Long) query30.getSingleResult();
		
		Query query60 = entityManager.createQuery(jpql);		 
		query60.setParameter("hojeF", hoje);
		query60.setParameter("diasF", sessentaDias);
		query60.setParameter("hojeD", hoje);
		query60.setParameter("diasD", sessentaDias);
		Long s = (Long) query60.getSingleResult();
		
		Query query90 = entityManager.createQuery(jpql);		 
		query90.setParameter("hojeF", hoje);
		query90.setParameter("diasF", noventeDias);
		query90.setParameter("hojeD", hoje);
		query90.setParameter("diasD", noventeDias);
		Long n = (Long) query90.getSingleResult();
	
		List<Long> resultado = new ArrayList<>();
		resultado.add(t);
		resultado.add(s);
		resultado.add(n);

		return resultado;
	}

	@Override
	public List<Tuple> getQuantidadePorLoja() {
		String jpql = "select c.unidade.nome, count(c.id)  "
				+ "from Contrato c group by c.unidade order by count(c.id) desc ";
		return entityManager.createQuery(jpql).setMaxResults(10).getResultList();
	}

}

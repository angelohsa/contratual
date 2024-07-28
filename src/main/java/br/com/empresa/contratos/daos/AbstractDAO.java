package br.com.empresa.contratos.daos;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class AbstractDAO<T, PK extends Serializable> {

	@SuppressWarnings("unchecked")
	private final Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
			.getActualTypeArguments()[0];

	@PersistenceContext
	protected EntityManager entityManager;

	public void save(T entity) {

		entityManager.persist(entity);
	}

	public void update(T entity) {

		entityManager.merge(entity);
	}

	public void delete(PK id) {

		entityManager.remove(entityManager.getReference(entityClass, id));
	}

	public T findById(PK id) {
		return entityManager.find(entityClass, id);
	}
	
	public List<T> findAll(){
		    List<T> list = entityManager.createQuery("from " + entityClass.getSimpleName(), entityClass)
				.getResultList();

		    return list;

	}

}

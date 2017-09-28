package com.sajid.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDaoImpl<PK extends Serializable, T> {
	
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDaoImpl(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager(){
		return this.entityManager;
	}

	public T getByKey(PK key) {
		return (T) entityManager.find(persistentClass, key);
	}
	
	public T findById(int key) {
		return (T) entityManager.find(persistentClass, key);
	}
	
	public List<T> findAll() {
        return entityManager.createQuery("Select t from " + persistentClass.getSimpleName() + " t").getResultList();
}

	public void persist(T entity) {
		entityManager.persist(entity);
	}
	
	public void save(T entity) {
		entityManager.persist(entity);
	}
	
	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

}

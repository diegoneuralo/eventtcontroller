package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dao.interfaces.IGenericDao;

public class GenericDao<T> implements IGenericDao<T> {
	
	
	private Class<T> clazz;
	
	@PersistenceContext(name="eventtcontroller")
	private EntityManager manager;
	
	public GenericDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public void add(T object) {
		manager.persist(object);
		
	}

	@Override
	public T showDetail(int object) {
		return manager.find(clazz, object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> showAll(T object) {
		Query query = manager.createQuery("SELECT FROM T");
		List<T> results = query.getResultList();
		return results;
	}
}
package model.dao.interfaces;

import java.util.List;

public interface IGenericDao<T> {
	public void add(T object);
	public T showDetail(int object);
	List<T> showAll(T object);
}

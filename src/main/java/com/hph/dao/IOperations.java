package com.hph.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 持久层通用接口，所有持久层接口都会实现此接口
 * @author hupenghao
 *
 * @param <T>
 */
public interface IOperations<T extends Serializable> {
	
	
	T findOne(final int id);

	List<T> findAll();

	void create(final T entity);

	void update(final T entity);

	void delete(final T entity);

	void deleteById(final int entityId);
}

package com.delivery.utils;

import java.util.List;

public interface Dao<T> {

	public List<T> get();

	public T getById(Long id);

	public void create(T e);

	public void update(T u);

	public void delete(T d);
}

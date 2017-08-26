package br.com.lelo.collections;

public interface CustomCollection<T> {

	boolean add(T t);

	boolean add(Integer position, T t);

	T get(int position);

	T remove(int position);

	boolean exists(T t);

	int size();

}
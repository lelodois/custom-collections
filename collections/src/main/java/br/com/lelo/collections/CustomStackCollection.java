package br.com.lelo.collections;

public interface CustomStackCollection<T> {

	public T getNext();

	public boolean add(T item);

	public T viewNext();

	int size();

	boolean exists(T t);
}

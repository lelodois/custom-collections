package br.com.lelo.collections;

public interface CustomLinkedListCollection<T> extends CustomCollection<T> {

	public boolean addFirst(T item);

	public boolean addLast(T item);

	public T removeFirst();

	public T removeLast();

}
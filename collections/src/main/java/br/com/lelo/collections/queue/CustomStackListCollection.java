package br.com.lelo.collections.queue;

import br.com.lelo.collections.CustomStackCollection;
import br.com.lelo.collections.linkedlist.CustomLinkedList;

public class CustomStackListCollection<T> implements CustomStackCollection<T> {

	private CustomLinkedList<T> linkedList = new CustomLinkedList<T>();

	@Override
	public T getNext() {
		return linkedList.removeLast();
	}

	@Override
	public boolean add(T item) {
		return linkedList.addFirst(item);
	}

	@Override
	public T viewNext() {
		return linkedList.get(size() - 1);
	}

	@Override
	public int size() {
		return linkedList.size();
	}

	@Override
	public boolean exists(T t) {
		return linkedList.exists(t);
	}

}

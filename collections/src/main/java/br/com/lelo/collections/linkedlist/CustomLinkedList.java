package br.com.lelo.collections.linkedlist;

import br.com.lelo.collections.CustomLinkedListCollection;

public class CustomLinkedList<T> implements CustomLinkedListCollection<T> {

	private Celula<T> primeira;
	private Celula<T> ultima;
	private int actualSize = 0;

	@Override
	public boolean add(T item) {
		if (this.isEmpty()) {
			return this.addFirst(item);
		} else {
			return this.addLast(item);
		}
	}

	@Override
	public boolean addFirst(T item) {
		this.primeira = new Celula<T>(null, this.primeira, item);
		this.actualSize++;
		return true;
	}

	@Override
	public boolean add(Integer position, T item) {
		this.validatePosition(position);
		if (this.isEmpty()) {
			return this.addFirst(item);
		}
		if (position == actualSize && position > 0) {
			return this.addLast(item);
		}
		Celula<T> itemActual = null;
		Celula<T> itemNext = null;
		for (int indice = 0; indice < position; indice++) {
			if (indice == 0) {
				itemActual = primeira;
				itemNext = primeira.getNext();
			} else {
				itemActual = itemActual.getNext();
				itemNext = itemActual.getNext();
			}
		}
		Celula<T> newwItem = new Celula<T>(itemActual, itemNext, item);
		itemActual.setNext(newwItem);
		itemNext.setPrevious(newwItem);
		this.actualSize++;
		return true;
	}

	@Override
	public boolean addLast(T t) {
		if (isEmpty()) {
			return this.addFirst(t);
		} else {
			Celula<T> penultima = this.ultima == null ? this.primeira : this.ultima;
			Celula<T> actual = new Celula<T>(penultima, null, t);
			penultima.setNext(actual);
			this.ultima = actual;
			this.actualSize++;
			return true;
		}
	}

	@Override
	public T get(int position) {
		return getCel(position).getElement();
	}

	@Override
	public T remove(int position) {
		this.validatePosition(position);

		if (position == 0) {
			return this.removeFirst();

		} else if (position == this.actualSize - 1) {
			return this.removeLast();

		} else {
			Celula<T> itemPrevious = this.getCel(position - 1);
			Celula<T> itemNext = itemPrevious.getNext();
			Celula<T> itemNextNext = itemNext.getNext();

			itemPrevious.setNext(itemNextNext);
			itemNextNext.setPrevious(itemPrevious);
			this.actualSize--;
			return itemNext.getElement();
		}
	}

	@Override
	public T removeFirst() {
		if (this.isEmpty()) {
			throw new IllegalArgumentException("Posição não existe");
		}

		T element = this.primeira.getElement();
		this.primeira = this.primeira.getNext();
		this.actualSize--;

		if (this.actualSize == 0) {
			this.ultima = null;
		}
		return element;
	}

	@Override
	public T removeLast() {
		if (this.isEmpty()) {
			throw new IllegalArgumentException("Posição não existe");
		}
		if (this.actualSize == 1) {
			return this.removeFirst();
		} else {
			Celula<T> penultima = this.ultima.getPrevious();
			penultima.setNext(null);
			T element = this.ultima.getElement();
			this.ultima = penultima;
			this.actualSize--;
			return element;
		}
	}

	@Override
	public boolean exists(T t) {
		Celula<T> atual = this.primeira;

		while (atual != null) {
			if (atual.getElement() != null && atual.getElement().equals(t)) {
				return true;
			}
			atual = atual.getNext();
		}
		return false;
	}

	@Override
	public int size() {
		return actualSize;
	}

	private boolean isEmpty() {
		return this.actualSize == 0;
	}

	public Celula<T> getCel(int position) {
		this.validatePosition(position);

		Celula<T> result = primeira;
		for (int index = 0; index < position; index++) {
			result = result.getNext();
		}
		return result;
	}

	private void validatePosition(int position) {
		if (position > size() || position < 0) {
			throw new IllegalArgumentException("Invalid Position");
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Celula<T> item = primeira;
		int index = 0;
		while (item != null) {
			builder.append(index++ + "-" + item.toString());
			item = item.getNext();
		}
		return builder.toString();
	}
}

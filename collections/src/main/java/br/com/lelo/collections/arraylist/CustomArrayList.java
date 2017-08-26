package br.com.lelo.collections.arraylist;

import java.util.Arrays;

import br.com.lelo.collections.CustomCollection;

/**
 * @author Léo Costa - 10/06/17
 *
 * @param <T>
 */
public class CustomArrayList<T> implements CustomCollection<T> {

	private Object[] elements;
	private int actualSize = 0;

	public CustomArrayList(int size) {
		this.elements = newArray(size);
	}

	@Override
	public boolean add(T t) {
		this.maximizeArray();
		elements[getNextIndex()] = t;
		return true;
	}

	@Override
	public boolean add(Integer position, T t) {
		this.validatePosition(position);
		this.maximizeArray();
		for (int index = this.actualSize - 1; index >= position; index -= 1) {
			elements[index + 1] = elements[index];
		}

		this.elements[position] = t;
		this.actualSize++;
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T get(int position) {
		this.validatePosition(position);
		return (T) elements[position];
	}

	@Override
	public T remove(int position) {
		this.validatePosition(position);
		T t = get(position);
		elements[position] = null;
		this.actualSize--;

		for (int indice = position; indice < elements.length; indice++) {
			if (elements.length > indice + 1) {
				elements[indice] = elements[indice + 1];
			}
		}
		return t;
	}

	@Override
	public boolean exists(T t) {
		for (int index = 0; index < this.actualSize; index++) {
			if (elements[index] != null && elements[index].equals(t)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return actualSize;
	}

	@Override
	public String toString() {
		return Arrays.toString(elements);
	}

	private synchronized int getNextIndex() {
		int nextIndex = actualSize;
		this.actualSize = actualSize + 1;
		return nextIndex;
	}

	private void maximizeArray() {
		if (actualSize == elements.length) {
			Object[] neww = newArray(elements.length * 2);
			for (int i = 0; i < actualSize; i++) {
				neww[i] = elements[i];
			}
			elements = neww;
		}
	}

	private Object[] newArray(int size) {
		return new Object[size];
	}

	private void validatePosition(int position) {
		if (position > size() || position < 0) {
			throw new IllegalArgumentException("Invalid Position");
		}
	}
}
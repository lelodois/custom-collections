package br.com.lelo.collections.linkedlist;

public class Celula<T> {

	private Celula<T> next;
	private Celula<T> previous;
	private T element;

	public Celula(Celula<T> previous, Celula<T> next, T element) {
		super();
		this.previous = previous;
		this.next = next;
		this.element = element;
	}

	public void setNext(Celula<T> next) {
		this.next = next;
	}

	public void setPrevious(Celula<T> previous) {
		this.previous = previous;
	}

	public Celula<T> getPrevious() {
		return previous;
	}

	public T getElement() {
		return element;
	}

	public Celula<T> getNext() {
		return next;
	}

	@Override
	public String toString() {
		StringBuilder toString = new StringBuilder();
		toString.append(" [").append(previous != null ? "Previous=> " + previous.getElement() : "Previous=> null").append("]");
		toString.append(" [").append("Actual=> " + this.element).append("]");
		toString.append(" [").append(next != null ? "Next=> " + next.getElement() : "Next=> null").append("]");
		return toString.toString();
	}

}

package br.com.lelo.collections;

import java.io.Serializable;

public class Aluno implements Serializable {

	private static final long serialVersionUID = -8421112677138856875L;

	private String nome;

	public Aluno(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public String toString() {
		return "Aluno: " + getNome();
	}

	@Override
	public int hashCode() {
		return getNome() != null ? getNome().length() : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		Aluno other = (Aluno) obj;
		if (!nome.equals(other.nome))
			return false;

		return true;
	}
}
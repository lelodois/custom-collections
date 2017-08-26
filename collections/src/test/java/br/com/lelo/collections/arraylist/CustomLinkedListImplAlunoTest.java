package br.com.lelo.collections.arraylist;

import org.junit.Assert;
import org.junit.Test;

import br.com.lelo.collections.Aluno;
import br.com.lelo.collections.CustomLinkedListCollection;
import br.com.lelo.collections.linkedlist.CustomLinkedList;

public class CustomLinkedListImplAlunoTest extends BaseCustomListTest {

	protected CustomLinkedList<Aluno> getInstanceImpl() {
		return new CustomLinkedList<Aluno>();
	}

	@Test
	public void adicionarLastTest() {
		Aluno joao = new Aluno("João");
		Aluno jose = new Aluno("José");
		Aluno ana = new Aluno("Ana");

		CustomLinkedListCollection<Aluno> myVetor = new CustomLinkedList<Aluno>();
		Assert.assertTrue(myVetor.addLast(joao));
		Assert.assertTrue(myVetor.add(jose));

		Assert.assertEquals(myVetor.get(0).toString(), joao.toString());
		Assert.assertEquals(myVetor.get(1).hashCode(), jose.hashCode());
		Assert.assertEquals(myVetor.size(), 2);

		Assert.assertTrue(myVetor.add(1, ana));
		Assert.assertTrue(myVetor.add(2, new Aluno("Victor")));
	}

	@Test
	public void removeItemTest() {
		Aluno joao = new Aluno("João");
		Aluno jose = new Aluno("José");
		Aluno ana = new Aluno("Ana");
		Aluno marcelo = new Aluno("Marcelo");
		Aluno silvinha = new Aluno("Silvinha");

		CustomLinkedListCollection<Aluno> myVetor = new CustomLinkedList<Aluno>();
		Assert.assertTrue(myVetor.add(joao));
		Assert.assertTrue(myVetor.add(marcelo));
		Assert.assertTrue(myVetor.add(silvinha));
		Assert.assertTrue(myVetor.add(jose));
		Assert.assertTrue(myVetor.add(1, ana));

		Assert.assertEquals(silvinha, myVetor.remove(3));
		Assert.assertEquals(jose, myVetor.removeLast());
		Assert.assertEquals(joao, myVetor.remove(0));
	}

}
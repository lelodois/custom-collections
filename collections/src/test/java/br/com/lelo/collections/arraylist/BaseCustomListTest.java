package br.com.lelo.collections.arraylist;

import org.junit.Assert;
import org.junit.Test;

import br.com.lelo.collections.Aluno;
import br.com.lelo.collections.CustomCollection;

public abstract class BaseCustomListTest {

	@Test
	public void adicionarFimTest() {
		Aluno joao = new Aluno("João");
		Aluno jose = new Aluno("José");
		Aluno ana = new Aluno("Ana");

		CustomCollection<Aluno> myVetor = getInstanceImpl();
		Assert.assertTrue(myVetor.add(joao));
		Assert.assertTrue(myVetor.add(jose));
		Assert.assertTrue(myVetor.add(ana));

		Assert.assertEquals(myVetor.size(), 3);
	}

	@Test
	public void adicionarPosicaoTest() {
		Aluno joao = new Aluno("João");
		Aluno jose = new Aluno("José");
		Aluno ana = new Aluno("Ana");

		CustomCollection<Aluno> myVetor = getInstanceImpl();
		Assert.assertTrue(myVetor.add(joao));
		Assert.assertTrue(myVetor.add(jose));

		Assert.assertEquals(myVetor.get(1).toString(), jose.toString());
		Assert.assertEquals(myVetor.get(1).hashCode(), jose.hashCode());
		Assert.assertEquals(myVetor.size(), 2);

		Assert.assertTrue(myVetor.add(1, ana));
		Assert.assertEquals(myVetor.get(1), ana);

		Assert.assertEquals(myVetor.get(2), jose);

		Assert.assertEquals(myVetor.size(), 3);
	}

	@Test
	public void pegaPorPosicaoTest() {
		Aluno rafael = new Aluno("Rafael");
		Aluno paulo = new Aluno("Paulo");
		Aluno jose = new Aluno("Jose");

		CustomCollection<Aluno> myVetor = getInstanceImpl();
		Assert.assertTrue(myVetor.add(rafael));
		Assert.assertTrue(myVetor.add(paulo));
		Assert.assertTrue(myVetor.add(jose));

		Assert.assertEquals(myVetor.size(), 3);
		Assert.assertEquals(rafael, myVetor.get(0));
		Assert.assertEquals(paulo, myVetor.get(1));
		Assert.assertEquals(jose, myVetor.get(2));
	}

	@Test
	public void removerPorPosicaoTest() {
		Aluno rafael = new Aluno("Rafael");
		Aluno paulo = new Aluno("Paulo");
		Aluno marcelo = new Aluno("Marcelo");
		Aluno jonathan = new Aluno("Jonathan");

		CustomCollection<Aluno> myVetor = getInstanceImpl();
		Assert.assertTrue(myVetor.add(rafael));
		Assert.assertTrue(myVetor.add(paulo));
		Assert.assertTrue(myVetor.add(marcelo));
		Assert.assertTrue(myVetor.add(jonathan));

		Assert.assertEquals(myVetor.size(), 4);
		Assert.assertEquals(myVetor.remove(0), rafael);
		Assert.assertEquals(myVetor.size(), 3);
	}

	@Test
	public void posicaoInvalidaTest() {
		Aluno rafael = new Aluno("Rafael");
		Aluno paulo = new Aluno(null);

		CustomCollection<Aluno> myVetor = getInstanceImpl();
		Assert.assertTrue(myVetor.add(rafael));
		Assert.assertTrue(myVetor.add(paulo));

		Assert.assertEquals(myVetor.remove(0), rafael);
		Assert.assertEquals(myVetor.size(), 1);
		Assert.assertEquals(myVetor.get(0).toString(), paulo.toString());
		Assert.assertEquals(myVetor.get(0).hashCode(), paulo.hashCode());
		Assert.assertEquals(myVetor.remove(0), paulo);
		Assert.assertEquals(myVetor.size(), 0);
	}

	@Test
	public void posicaoInvalidaErrorTest() {
		CustomCollection<Aluno> myVetor = getInstanceImpl();
		myVetor.add(new Aluno("Rafael"));
		myVetor.add(null);
		myVetor.exists(new Aluno("test"));
		try {
			Assert.assertNull(myVetor.get(5));
			Assert.fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void contemAlunoTest() {
		Aluno rafael = new Aluno("Rafael");
		Aluno paulo = new Aluno("Paulo");

		CustomCollection<Aluno> myVetor = getInstanceImpl();
		Assert.assertTrue(myVetor.add(rafael));
		Assert.assertTrue(myVetor.add(paulo));

		Assert.assertTrue(myVetor.exists(rafael));
		Assert.assertTrue(myVetor.exists(paulo));
		Assert.assertFalse(myVetor.exists(new Aluno("rafael")));

		Aluno ana = new Aluno("Ana");
		Assert.assertTrue(myVetor.add(ana));
		Assert.assertEquals(myVetor.size(), 3);
	}

	@Test
	public void tamanhoListaTest() {
		Aluno rafael = new Aluno("Rafael");
		Aluno paulo = new Aluno("Paulo");

		CustomCollection<Aluno> myVetor = getInstanceImpl();
		Assert.assertTrue(myVetor.add(rafael));
		Assert.assertTrue(myVetor.add(paulo));

		Assert.assertEquals(myVetor.size(), 2);

		Aluno ana = new Aluno("Ana");
		Assert.assertTrue(myVetor.add(ana));
		Assert.assertEquals(myVetor.size(), 3);
		Assert.assertNotNull(myVetor.toString());
	}

	protected abstract CustomCollection<Aluno> getInstanceImpl();

}

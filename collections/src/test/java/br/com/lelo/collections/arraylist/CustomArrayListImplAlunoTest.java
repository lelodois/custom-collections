package br.com.lelo.collections.arraylist;

import br.com.lelo.collections.Aluno;
import br.com.lelo.collections.CustomCollection;

public class CustomArrayListImplAlunoTest extends BaseCustomListTest {

	protected CustomCollection<Aluno> getInstanceImpl() {
		return new CustomArrayList<Aluno>(3);
	}

}
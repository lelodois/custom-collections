package br.com.lelo.collections;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.lelo.collections.arraylist.CustomArrayListImplAlunoTest;
import br.com.lelo.collections.arraylist.CustomLinkedListImplAlunoTest;

@RunWith(Suite.class)
@SuiteClasses({ CustomArrayListImplAlunoTest.class, CustomLinkedListImplAlunoTest.class })
public class AllTests {

}

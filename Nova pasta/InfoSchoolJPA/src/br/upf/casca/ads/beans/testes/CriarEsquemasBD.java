package br.upf.casca.ads.beans.testes;

import javax.persistence.Persistence;

import org.junit.Test;

public class CriarEsquemasBD {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Persistence.createEntityManagerFactory("InfoSchoolJPA");
	}

}

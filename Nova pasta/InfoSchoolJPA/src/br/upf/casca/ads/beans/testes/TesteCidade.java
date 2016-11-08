package br.upf.casca.ads.beans.testes;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.upf.casca.ads.beans.classes.Cidade;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;

public class TesteCidade {

	@Test
	public void testNomeUfVazio() {
		Cidade o = new Cidade(null, "Nova Bassano", "RS");
		EntityManager em = ConexaoJPA.getEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}
	
	/*@Test
	public void testTamanhoNomeUf() {
		Cidade o = new Cidade(null, "Nova Araçá", "SC");
		EntityManager em = FabricaConexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}
	
	@Test
	public void testNomeUfValido(){
		Cidade o = new Cidade (null, "Nova Bassano", "RS");
		EntityManager em = FabricaConexao.getEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}*/

}

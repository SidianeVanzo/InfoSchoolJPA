package br.upf.casca.ads.beans.testes;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.upf.casca.ads.beans.classes.TipoAluno;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;

public class TesteTipoAluno {

	@Test
	public void testTipoAlunoVazio() {
		TipoAluno o = new TipoAluno(null, "Concluinte");
		EntityManager em = ConexaoJPA.getEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}


}

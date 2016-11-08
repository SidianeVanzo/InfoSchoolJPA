package br.upf.casca.ads.beans.testes;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.upf.casca.ads.beans.classes.Curso;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;

public class TesteCurso {

	@Test
	public void testeCerto() {
		Curso o = new Curso(null, "Excel Avançado", true, false, false, true, false, false, false, false, false, "20h");
		EntityManager em = ConexaoJPA.getEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
	}
	
	}

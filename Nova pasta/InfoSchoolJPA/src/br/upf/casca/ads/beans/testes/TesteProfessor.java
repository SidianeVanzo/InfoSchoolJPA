package br.upf.casca.ads.beans.testes;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.upf.casca.ads.beans.classes.Pessoa;
import br.upf.casca.ads.beans.classes.Professor;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;


public class TesteProfessor {

	@Test
	public void testNovo() {
		
		EntityManager em = ConexaoJPA.getEntityManager();
			
		Professor o = new Professor();
		Pessoa p = (Pessoa) em.createQuery("from Pessoa WHERE nome = 'Administrador'").getSingleResult();
		o.setId(p.getId());
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		
	}

}
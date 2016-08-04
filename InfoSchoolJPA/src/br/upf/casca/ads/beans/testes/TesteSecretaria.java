package br.upf.casca.ads.beans.testes;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.upf.casca.ads.beans.classes.Secretaria;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;


public class TesteSecretaria {

	@Test
	public void testNovo() {
		
		EntityManager em = ConexaoJPA.getEntityManager();
			
		Secretaria o = new Secretaria();
		o.setNome("Secretaria Um");
		o.setTelefone("96851517");
		o.setEmail("sidiane@gmail.com");
		o.setEndereco("Rua das Camelias");
		o.setFormacao("ADDS");
		o.setHorarioExpediente("12 as 18");	
				
		o.setUsuario("um");
		o.setSenha("um");
		
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		
	}

}

package br.upf.casca.ads.beans.testes;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.upf.casca.ads.beans.classes.Diretor;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;


public class TesteDiretor {

	@Test
	public void testNovo() {
		
		EntityManager em = ConexaoJPA.getEntityManager();
			
		Diretor o = new Diretor();
		o.setNome("Samira");
		o.setTelefone("99851513");
		o.setEmail("samira@gmail.com");
		o.setEndereco("Rua Flores da Cunha");
		o.setTipo("DIRETOR");
		o.setFormacao("Ciencias Contabeis");
									
		o.setUsuario("samira");
		o.setSenha("samira");
		
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		
	}

}

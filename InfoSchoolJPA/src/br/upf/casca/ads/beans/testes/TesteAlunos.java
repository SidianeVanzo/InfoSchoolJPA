package br.upf.casca.ads.beans.testes;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.upf.casca.ads.beans.classes.Alunos;
import br.upf.casca.ads.beans.classes.Cidade;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;


public class TesteAlunos {

	@Test
	public void testNovo() {
		
		EntityManager em = ConexaoJPA.getEntityManager();
		Date data = new Date();
		data.setTime(new Date().getTime()-30);
			
		Alunos o = new Alunos();
		o.setNome("Joao");
		o.setTelefone("97095437");
		o.setEmail("maria@gmail.com");
		o.setEndereco("Rua Ipiranga");
		o.setCidade(em.find(Cidade.class, 1));
		o.setCpf("028.726.240-58");
		o.setDataNascimento(data);
		o.setRg("7665432887");
		o.setTipoAluno("EM ESPERA");
		
		
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		
	}
//	
//	@Test
//	public void testSemNome() {
//		
//		EntityManager em = ConexaoJPA.getEntityManager();
//		Date data = new Date();
//		data.setTime(new Date().getTime()-30);
//			
//		Alunos o = new Alunos();
//		o.setNome("");
//		o.setTelefone("97095437");
//		o.setEmail("maria@gmail.com");
//		o.setEndereco("Rua Ipiranga");
//		o.setCidade(em.find(Cidade.class, 1));
//		o.setCpf("028.726.240-58");
//		o.setDataNascimento(data);
//		o.setRg("7665432887");
//		o.setTipoAluno("EM ESPERA");
//		
//		
//		em.getTransaction().begin();
//		em.persist(o);
//		em.getTransaction().commit();
//		
//	}
//	
//	@Test
//	public void testNomePequeno() {
//		
//		EntityManager em = ConexaoJPA.getEntityManager();
//		Date data = new Date();
//		data.setTime(new Date().getTime()-30);
//			
//		Alunos o = new Alunos();
//		o.setNome("J");
//		o.setTelefone("97095437");
//		o.setEmail("maria@gmail.com");
//		o.setEndereco("Rua Ipiranga");
//		o.setCidade(em.find(Cidade.class, 1));
//		o.setCpf("028.726.240-58");
//		o.setDataNascimento(data);
//		o.setRg("7665432887");
//		o.setTipoAluno("EM ESPERA");
//		
//		
//		em.getTransaction().begin();
//		em.persist(o);
//		em.getTransaction().commit();
//		
//	}

}

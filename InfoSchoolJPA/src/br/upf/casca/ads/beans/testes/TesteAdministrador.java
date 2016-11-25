package br.upf.casca.ads.beans.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.upf.casca.ads.beans.classes.Administrador;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;


public class TesteAdministrador {

	@Test
	public void testNovo() {
		
		EntityManager em = ConexaoJPA.getEntityManager();
			
		Administrador o = new Administrador();
		o.setNome("Administrador");
		o.setTelefone("85858585");
		o.setEmail("sandro@gmail.com");
		o.setEndereco("Rua Secreta");
		try {
			o.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("15/11/2016"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		o.setSenha("123");
		o.setUsuario("adm");
		o.setTipo("ADMINISTRADOR");
		
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		
	}

}

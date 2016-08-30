package br.upf.casca.ads.beans.testes;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.upf.casca.ads.beans.classes.Administrador;
import br.upf.casca.ads.beans.classes.Cidade;
import br.upf.casca.ads.beans.classes.TipoAluno;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;


public class TesteAdministrador {

	@Test
	public void testNovo() {
		
		EntityManager em = ConexaoJPA.getEntityManager();
		Date data = new Date();
		data.setTime(new Date().getTime()-1);
			
		Administrador o = new Administrador();
		o.setNome("X9");
		o.setTelefone("85858585");
		o.setEmail("x9@gmail.com");
		o.setEndereco("Rua Secreta");
		o.setDataCadastro(data);
		o.setSenha("um");
		o.setUsuario("um");
		o.setTipo("ADMINISTRADOR");
		
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		
	}

}

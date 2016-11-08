package br.upf.casca.ads.beans.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.upf.casca.ads.beans.classes.Secretaria;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;


public class TesteSecretaria {

	@Test
	public void testNovo() {
		
		EntityManager em = ConexaoJPA.getEntityManager();
			
		Secretaria o = new Secretaria();
		o.setNome("Maria");
		o.setTelefone("99851513");
		o.setEmail("maria@gmail.com");
		o.setEndereco("Rua Flores da Cunha");
		o.setFormacao("Administração");
		o.setTipo("SECRETARIA");
		try {
			o.setHorarioInicioExpediente(new SimpleDateFormat("HH:mm").parse("08:00"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			o.setHorarioFimExpediente(new SimpleDateFormat("HH:mm").parse("17:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
				
		o.setUsuario("maria");
		o.setSenha("maria");
		
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		
	}

}

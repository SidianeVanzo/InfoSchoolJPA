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
		o.setNome("Joaquina");
		o.setTelefone("96851517");
		o.setEmail("joaquina@gmail.com");
		o.setEndereco("Rua das Camelias");
		o.setFormacao("ADS");
		try {
			o.setHorarioInicioExpediente(new SimpleDateFormat("HH:mm").parse("09:00"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			o.setHorarioFimExpediente(new SimpleDateFormat("HH:mm").parse("18:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
				
		o.setUsuario("um");
		o.setSenha("um");
		
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		
	}

}

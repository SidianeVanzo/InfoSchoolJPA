package br.upf.casca.ads.beans.uteis;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.jpa.HibernateEntityManager;

public class ConexaoJPA {

	
	//unica execução durante toda a duração do sistema por causa da palavra final
	private static EntityManagerFactory factory;
	
	public static EntityManager getEntityManager(){
		
		if(factory == null){
			factory = Persistence.createEntityManagerFactory("InfoSchoolJPA");
		}
		
		return factory.createEntityManager();
	}
	
	public static Connection getEntityManagerJDBCConnection() throws SQLException {
		EntityManager em = getEntityManager();
		HibernateEntityManager hem = (HibernateEntityManager) em;
		SessionImplementor sim = (SessionImplementor) hem.getSession();
		Connection conexao = sim.connection();
		em.close();
		return conexao;
	}
}

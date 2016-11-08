package br.upf.projeto.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.upf.casca.ads.beans.classes.Aula;
import br.upf.casca.ads.beans.classes.Chamada;
import br.upf.casca.ads.beans.classes.Pessoa;
import br.upf.casca.ads.beans.classes.Turma;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;

@ManagedBean
@SessionScoped
public class ChamadaCrud {

	private Chamada objeto;
	private List<Chamada> chamadas;
		
	public List<Turma> completeTurma(String query) {
		EntityManager em = ConexaoJPA.getEntityManager();
		 List<Turma> results = em.createQuery(
		 "from Turma where upper(nome) like "+
		"'"+query.trim().toUpperCase()+"%' "+
		 "order by nome").getResultList();
		 em.close();
		 return results;
	}
	
	public void inicializarLista(){
		EntityManager em = ConexaoJPA.getEntityManager();
		chamadas = em.createQuery("from Chamada").getResultList();
		em.close();
	}
	
	public String incluir(){
		objeto = new Chamada();
		return "ChamadaForm?faces-redirect=true";
		
	}
	
	public String gravar(){
		EntityManager em = ConexaoJPA.getEntityManager();
		 em.getTransaction().begin();
		 em.merge(objeto);
		 em.getTransaction().commit();
		 em.close();
		 return "ChamadaList?faces-redirect=true";
	}
	
	public String cancelar() {
		 return "ChamadaList";
	}
	
	public String alterar(Integer id) {
		EntityManager em = ConexaoJPA.getEntityManager();
		objeto = em.find(Chamada.class, id);
		em.close();
		return "ChamadaForm?faces-redirect=true";
	}

	public String excluir(Integer id) {
		EntityManager em = ConexaoJPA.getEntityManager();
		objeto = em.find(Chamada.class, id);
		em.getTransaction().begin();
		em.remove(objeto);
		em.getTransaction().commit();
		em.close();
		return "ChamadaList?faces-redirect=true";
	}

	public ChamadaCrud() {
		super();
		objeto = new Chamada();
		EntityManager em = ConexaoJPA.getEntityManager();
		chamadas = em.createQuery("from Chamada").getResultList();
		em.close();
	}

	public Chamada getObjeto() {
		return objeto;
	}

	public void setObjeto(Chamada objeto) {
		this.objeto = objeto;
	}

	public List<Chamada> getChamadas() {
		return chamadas;
	}

	public void setChamadas(List<Chamada> chamadas) {
		this.chamadas = chamadas;
	}
	
	
	
	
	
	
	
	

	
	
	
	
}

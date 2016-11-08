package br.upf.projeto.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import br.upf.casca.ads.beans.classes.Curso;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;

@ManagedBean
@SessionScoped
public class CursoCrud {

	private Curso objeto;
	private List<Curso> cursos;
    
	
	public void inicializarLista(){
		EntityManager em = ConexaoJPA.getEntityManager();
		cursos = em.createQuery("from Curso").getResultList();
		em.close();
	}
	
	public String incluir(){
		objeto = new Curso();
		return "CursoForm?faces-redirect=true";
		
	}
	
	public String gravar(){
		EntityManager em = ConexaoJPA.getEntityManager();
		 em.getTransaction().begin();
		 em.merge(objeto);
		 em.getTransaction().commit();
		 em.close();
		 return "CursoList?faces-redirect=true";
	}
	
	public String cancelar() {
		 return "CursoList";
	}
	
	public String alterar(Integer id) {
		EntityManager em = ConexaoJPA.getEntityManager();
		objeto = em.find(Curso.class, id);
		em.close();
		return "CursoForm?faces-redirect=true";
	}

	public String excluir(Integer id) {
		EntityManager em = ConexaoJPA.getEntityManager();
		objeto = em.find(Curso.class, id);
		em.getTransaction().begin();
		em.remove(objeto);
		em.getTransaction().commit();
		em.close();
		return "CursoList?faces-redirect=true";
	}

	public CursoCrud() {
		super();
		objeto = new Curso();
		EntityManager em = ConexaoJPA.getEntityManager();
		cursos = em.createQuery("from Curso").getResultList();
		em.close();
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Curso getObjeto() {
		return objeto;
	}

	public void setObjeto(Curso objeto) {
		this.objeto = objeto;
	}
}

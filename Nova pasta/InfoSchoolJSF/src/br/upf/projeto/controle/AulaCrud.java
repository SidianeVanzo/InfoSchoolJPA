package br.upf.projeto.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.upf.casca.ads.beans.classes.Alunos;
import br.upf.casca.ads.beans.classes.AlunosTurma;
import br.upf.casca.ads.beans.classes.Aula;
import br.upf.casca.ads.beans.classes.Chamada;
import br.upf.casca.ads.beans.classes.Pessoa;
import br.upf.casca.ads.beans.classes.Turma;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;

@ManagedBean
@SessionScoped
public class AulaCrud {

	private Aula objeto;
	private Turma turma;
	private List<Aula> aulas;
	private List<Chamada> listChamada;

	public List<Turma> completeTurma(String query) {
		EntityManager em = ConexaoJPA.getEntityManager();
		List<Turma> results = em.createQuery(
				"from Turma where upper(nome) like " + "'" + query.trim().toUpperCase() + "%' " + "order by nome")
				.getResultList();
		em.close();
		return results;
	}

	public void inicializarLista() {
		EntityManager em = ConexaoJPA.getEntityManager();
		aulas = em.createQuery("from Aula").getResultList();
		em.close();
	}

	public String incluir(Aula objeto, Turma turma) {
		this.objeto = new Aula();
		this.turma = turma;
		if(objeto ==  null){
			objeto = new Aula();
		}		
		iniciaChamada();
		return "/Cadastros/Aula/AulaForm?faces-redirect=true";		
	}

	public String gravar() {
		EntityManager em = ConexaoJPA.getEntityManager();
		
		objeto.setChamada(listChamada);
		objeto.setTurma(turma);
		objeto.setData(new Date());
		objeto.setDescricao("Teste");
		
		em.getTransaction().begin();
		em.merge(objeto);
		em.getTransaction().commit();
		em.close();
		return "AulaList?faces-redirect=true";
	}

	public String cancelar() {
		return "AulaList";
	}

	public String alterar(Integer id) {
		EntityManager em = ConexaoJPA.getEntityManager();
		objeto = em.find(Aula.class, id);
		em.close();
		return "AulaForm?faces-redirect=true";
	}

	public String excluir(Integer id) {
		EntityManager em = ConexaoJPA.getEntityManager();
		objeto = em.find(Aula.class, id);
		em.getTransaction().begin();
		em.remove(objeto);
		em.getTransaction().commit();
		em.close();
		return "AulaList?faces-redirect=true";
	}

	public AulaCrud() {
		super();
		objeto = new Aula();
		EntityManager em = ConexaoJPA.getEntityManager();
		aulas = em.createQuery("from Aula").getResultList();
		em.close();
	}

	
	private void iniciaChamada(){
		listChamada = new ArrayList();
		if(turma != null){
			List<AlunosTurma> listAlunos = turma.getAlunosTurma();
			for(AlunosTurma aluno : turma.getAlunosTurma()){
				Chamada chamada = new Chamada();
				chamada.setAluno(aluno.getAlunos());
				chamada.setComparecimentoAula(false);
				chamada.setNotasProvas(0.00);
				chamada.setProvas("AAAAA");					
				listChamada.add(chamada);
			}
		}
		//objeto.set
	}
	
	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Aula getObjeto() {
		return objeto;
	}

	public void setObjeto(Aula objeto) {
		this.objeto = objeto;
	}


	public Turma getTurma() {
		return turma;
	}


	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Chamada> getListChamada() {
		return listChamada;
	}

	public void setListChamada(List<Chamada> listChamada) {
		this.listChamada = listChamada;
	}
	
	
}

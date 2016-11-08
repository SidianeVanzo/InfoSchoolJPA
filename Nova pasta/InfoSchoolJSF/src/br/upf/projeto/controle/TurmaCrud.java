package br.upf.projeto.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.upf.casca.ads.beans.classes.Alunos;
import br.upf.casca.ads.beans.classes.AlunosTurma;
import br.upf.casca.ads.beans.classes.Curso;
import br.upf.casca.ads.beans.classes.Pessoa;
import br.upf.casca.ads.beans.classes.Professor;
import br.upf.casca.ads.beans.classes.Turma;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;

@ManagedBean
@SessionScoped
public class TurmaCrud {

	private Turma objeto;
	private List<Turma> turmas;
	private String[] listaTipo = { "NORMAL", "PARTICULAR" };

	public List<Curso> completeCurso(String query) {
		EntityManager em = ConexaoJPA.getEntityManager();
		List<Curso> results = em.createQuery(
				"from Curso where upper(nome) like " + "'" + query.trim().toUpperCase() + "%' " + "order by nome")
				.getResultList();
		em.close();
		return results;
	}

	public List<Professor> completeProfessor(String query) {
		EntityManager em = ConexaoJPA.getEntityManager();
		List<Professor> results = em.createQuery(
				"from Professor where upper(nome) like " + "'" + query.trim().toUpperCase() + "%' " + "order by nome")
				.getResultList();
		em.close();
		return results;
	}

	public List<Alunos> completeAlunos(String query) {
		EntityManager em = ConexaoJPA.getEntityManager();
		List<Alunos> results = em.createQuery(
				"from Alunos where upper(nome) like " + "'" + query.trim().toUpperCase() + "%' " + "order by nome")
				.getResultList();
		em.close();
		return results;
	}

	public void inicializarLista() {
		EntityManager em = ConexaoJPA.getEntityManager();
		turmas = em.createQuery("from Turma").getResultList();
		em.close();
	}

	public String incluir() {
		objeto = new Turma();
		objeto.setAlunosTurma(new ArrayList<>());
		return "TurmaForm?faces-redirect=true";

	}

	public String gravar() {
		EntityManager em = ConexaoJPA.getEntityManager();
		em.getTransaction().begin();
		em.merge(objeto);
		em.getTransaction().commit();
		em.close();
		return "TurmaList?faces-redirect=true";
	}

	public String cancelar() {
		return "TurmaList";
	}

	public String alterar(Integer id) {
		EntityManager em = ConexaoJPA.getEntityManager();
		objeto = em.find(Turma.class, id);
		em.close();
		return "TurmaForm?faces-redirect=true";
	}

	public String excluir(Integer id) {
		EntityManager em = ConexaoJPA.getEntityManager();
		objeto = em.find(Turma.class, id);
		em.getTransaction().begin();
		em.remove(objeto);
		em.getTransaction().commit();
		em.close();
		return "TurmaList?faces-redirect=true";
	}

	public TurmaCrud() {
		super();
		objeto = new Turma();
		EntityManager em = ConexaoJPA.getEntityManager();
		turmas = em.createQuery("from Turma").getResultList();
		em.close();
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Turma getObjeto() {
		return objeto;
	}

	public void setObjeto(Turma objeto) {
		this.objeto = objeto;
	}

	public String[] getListaTipo() {
		return listaTipo;
	}

	public void setListaTipo(String[] listaTipo) {
		this.listaTipo = listaTipo;
	}

	private AlunosTurma alunosTurma; // itens em edição, vinculado ao formulário
	private Integer rowIndex = null; // índice dos itens selecionado - alterar e
										// excluir

	public void incluirItem() {
		rowIndex = null;
		alunosTurma = new AlunosTurma();
	}

	public void alterarItem(Integer rowIndex) {
		this.rowIndex = rowIndex;
		alunosTurma = objeto.getAlunosTurma().get(rowIndex); // pega itens da
																// coleção
	}

	public void excluirItem(Integer rowIndex) {
		objeto.getAlunosTurma().remove(rowIndex.intValue()); // exclui itens da
																// coleção
	}

	public void gravarItem() {

		if (this.rowIndex == null) {
			alunosTurma.setTurma(objeto);
			objeto.getAlunosTurma().add(alunosTurma); // adiciona itens na coleção
		} else {
			objeto.getAlunosTurma().set(rowIndex, alunosTurma); // altera na
																// coleção
		}
		rowIndex = null;
		alunosTurma = null;

	}

	public void cancelarItem() {
		rowIndex = null;
		alunosTurma = null;
	}

	public AlunosTurma getAlunosTurma() {
		return alunosTurma;
	}

	public void setAlunosTurma(AlunosTurma alunosTurma) {
		this.alunosTurma = alunosTurma;
	}

	public Integer getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(Integer rowIndex) {
		this.rowIndex = rowIndex;
	}

}

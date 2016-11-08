package br.upf.projeto.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.upf.casca.ads.beans.uteis.ConexaoJPA;
import br.upf.casca.ads.beans.classes.Cidade;
import br.upf.casca.ads.beans.classes.Secretaria;

@ManagedBean
@SessionScoped
public class CidadeCrud {

	private Cidade cidade;
	private List<Cidade> cidades;
	private String[] listaUF = { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
			"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" };

	public void inicializarLista() {
		EntityManager em = ConexaoJPA.getEntityManager();
		cidades = em.createQuery("from Cidade").getResultList();
		em.close();
	}

	public String incluir() {
		cidade = new Cidade();
		return "CidadeForm?faces-redirect=true";

	}

	public String gravar() {
		EntityManager em = ConexaoJPA.getEntityManager();
		em.getTransaction().begin();

		List<Cidade> listaNome = new ArrayList<Cidade>();

		if (cidade.getId() == null) {
			Query qry = em.createQuery("from Cidade where nome = :nome");
			qry.setParameter("nome", cidade.getNome());
			listaNome = qry.getResultList();
		}

		if (listaNome.isEmpty()) {
			em.merge(cidade);
			em.getTransaction().commit();
			em.close();
			return "CidadeList?faces-redirect=true";
		} else {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"A cidade informada já está cadastrada no sistema. Por favor, informe outra cidade!!", "");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			return "";
		}
	}

	public String cancelar() {
		return "CidadeList";
	}

	public String alterar(Integer id) {
		EntityManager em = ConexaoJPA.getEntityManager();
		cidade = em.find(Cidade.class, id);
		em.close();
		return "CidadeForm?faces-redirect=true";
	}

	public CidadeCrud() {
		super();
		cidade = new Cidade();
		EntityManager em = ConexaoJPA.getEntityManager();
		cidades = em.createQuery("from Cidade").getResultList();
		em.close();
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public String[] getListaUF() {
		return listaUF;
	}

	public void setListaUF(String[] listaUF) {
		this.listaUF = listaUF;
	}

}

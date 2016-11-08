package br.upf.projeto.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import br.upf.casca.ads.beans.classes.Alunos;
import br.upf.casca.ads.beans.classes.Aula;
import br.upf.casca.ads.beans.classes.Cidade;
import br.upf.casca.ads.beans.classes.Pessoa;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;

@ManagedBean
@SessionScoped
public class AlunosCrud {

	private Alunos objeto;
	private List<Alunos> alunos;
	private String[] listaTipo = { "EM ESPERA", "CURSANDO", "CONCLUINTE", "CANCELADO" };

	public List<Cidade> completeCidade(String query) {
		EntityManager em = ConexaoJPA.getEntityManager();
		List<Cidade> results = em.createQuery(
				"from Cidade where upper(nome) like " + "'" + query.trim().toUpperCase() + "%' " + "order by nome")
				.getResultList();
		em.close();
		return results;
	}

	public void inicializarLista() {
		EntityManager em = ConexaoJPA.getEntityManager();
		alunos = em.createQuery("from Alunos").getResultList();
		em.close();
	}

	public String incluir() {
		objeto = new Alunos();
		return "AlunosForm?faces-redirect=true";

	}

	public String gravar() {
		EntityManager em = ConexaoJPA.getEntityManager();
		em.getTransaction().begin();

		List<Alunos> listaEmail = new ArrayList<Alunos>();
		List<Alunos> listaCpf = new ArrayList<Alunos>();
		List<Alunos> listaRg = new ArrayList<Alunos>();
		
		if (objeto.getId() == null) {
			Query qry = em.createQuery("from Alunos where email = :email");
			qry.setParameter("email", objeto.getEmail());
			listaEmail = qry.getResultList();

			Query query = em.createQuery("from Alunos where cpf = :cpf");
			query.setParameter("cpf", objeto.getCpf());
			listaCpf = query.getResultList();

			Query qr = em.createQuery("from Alunos where rg = :rg");
			qr.setParameter("rg", objeto.getRg());
			listaRg = qr.getResultList();
		}

		if (listaEmail.isEmpty()) {
			if (listaCpf.isEmpty()) {
				if (listaRg.isEmpty()) {
					em.merge(objeto);
					em.getTransaction().commit();
					em.close();
					return "AlunosList?faces-redirect=true";
				} else {
					FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"O RG informado já está cadastrado no sistema. Por favor, informe outro valor!", "");
					FacesContext.getCurrentInstance().addMessage(null, mensagem);
					return "";
				}
			} else {
				FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"O CPF informado já está cadastrado no sistema. Por favor, informe outro valor!", "");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);
				return "";
			}
		} else {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"O e-mail informado já está cadastrado no sistema. Por favor, informe outro e-mail!!", "");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			return "";
		}

	}

	public String cancelar() {
		return "AlunosList";
	}

	public String alterar(Integer id) {
		EntityManager em = ConexaoJPA.getEntityManager();
		objeto = em.find(Alunos.class, id);
		em.close();
		return "AlunosForm?faces-redirect=true";
	}

	public String excluir(Integer id) {
		EntityManager em = ConexaoJPA.getEntityManager();
		objeto = em.find(Alunos.class, id);
		em.getTransaction().begin();
		em.remove(objeto);
		em.getTransaction().commit();
		em.close();
		return "AlunosList?faces-redirect=true";
	}

	public AlunosCrud() {
		super();
		objeto = new Alunos();
		EntityManager em = ConexaoJPA.getEntityManager();
		alunos = em.createQuery("from Alunos").getResultList();
		em.close();
	}

	public Alunos getObjeto() {
		return objeto;
	}

	public void setObjeto(Alunos objeto) {
		this.objeto = objeto;
	}

	public List<Alunos> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Alunos> alunos) {
		this.alunos = alunos;
	}

	public String[] getListaTipo() {
		return listaTipo;
	}

	public void setListaTipo(String[] listaTipo) {
		this.listaTipo = listaTipo;
	}

}

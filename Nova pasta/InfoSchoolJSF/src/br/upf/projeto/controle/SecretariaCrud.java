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
import br.upf.casca.ads.beans.classes.Secretaria;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;

@ManagedBean
@SessionScoped
public class SecretariaCrud {

	private Secretaria objeto;
	private List<Secretaria> secretarias;
		
	public void inicializarLista(){
		EntityManager em = ConexaoJPA.getEntityManager();
		secretarias = em.createQuery("from Secretaria").getResultList();
		em.close();
	}
	
	public String incluir(){
		objeto = new Secretaria();
		return "SecretariaForm?faces-redirect=true";
		
	}
	
	public String gravar(){
		EntityManager em = ConexaoJPA.getEntityManager();
		 em.getTransaction().begin();
		 objeto.setTipo("SECRETARIA");
		 
		 List<Secretaria> listaUsuario = new ArrayList<Secretaria>();
		 List<Secretaria> listaEmail = new ArrayList<Secretaria>();
			
			if (objeto.getId() == null) {
				Query qry = em.createQuery("from Pessoa where usuario = :usuario");
				qry.setParameter("usuario", objeto.getUsuario());
				listaUsuario = qry.getResultList();
				
				Query query = em.createQuery("from Pessoa where email = :email");
				query.setParameter("email", objeto.getEmail());
				listaEmail = query.getResultList();
			}

			if (listaUsuario.isEmpty()) {
				if(listaEmail.isEmpty()){
						em.merge(objeto);
						em.getTransaction().commit();
						em.close();
						return "SecretariaList?faces-redirect=true";
				}else{
					FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"O e-mail informado já está cadastrado no sistema. Por favor, informe outro e-mail!!", "");
					FacesContext.getCurrentInstance().addMessage(null, mensagem);
					return "";
				}
			} else {
				FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"O usuário informado já está cadastrado no sistema. Por favor, informe outro usuário!!", "");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);
				return "";
			}

	}
	
	
	public String cancelar() {
		 return "SecretariaList";
	}
	
	public String alterar(Integer id) {
		EntityManager em = ConexaoJPA.getEntityManager();
		objeto = em.find(Secretaria.class, id);
		em.close();
		return "SecretariaForm?faces-redirect=true";
	}

	public String excluir(Integer id) {
		EntityManager em = ConexaoJPA.getEntityManager();
		objeto = em.find(Secretaria.class, id);
		em.getTransaction().begin();
		em.remove(objeto);
		em.getTransaction().commit();
		em.close();
		return "SecretariaList?faces-redirect=true";
	}

	public SecretariaCrud() {
		super();
		objeto = new Secretaria();
		EntityManager em = ConexaoJPA.getEntityManager();
		secretarias = em.createQuery("from Secretaria").getResultList();
		em.close();
	}

	public Secretaria getObjeto() {
		return objeto;
	}

	public void setObjeto(Secretaria objeto) {
		this.objeto = objeto;
	}

	public List<Secretaria> getSecretarias() {
		return secretarias;
	}

	public void setSecretarias(List<Secretaria> secretarias) {
		this.secretarias = secretarias;
	}

}

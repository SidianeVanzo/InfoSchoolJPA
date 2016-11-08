package br.upf.projeto.controle;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.upf.casca.ads.beans.classes.Pessoa;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;



@ManagedBean 
@SessionScoped 
public class LoginAdControle {
	
	private String usuario; 
    private String senha;
    private Pessoa usuarioLogado = null;
	public LoginAdControle() {
		super();
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	   
	public Pessoa getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Pessoa usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	public String entrar() {  
        EntityManager em = ConexaoJPA.getEntityManager(); 
        Query qry = em.createQuery("from Pessoa where usuario = :usuario and senha = :senha and tipo='ADMINISTRADOR'"); 
        qry.setParameter("usuario", usuario); 
        qry.setParameter("senha", senha); 
        List<Pessoa> list = qry.getResultList();  
         em.close();  
        if (list.size() <= 0){ 
               usuarioLogado = null; 
               FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,  
                                  "Usuário ou senha inválida!" , ""); 
               FacesContext.getCurrentInstance().addMessage(null, mensagem);                  
               return ""; 
        }else{ 
        	usuarioLogado = list.get(0); 
            return "/faces/Ad_Sistema/HomeAd/HomeAd.xhtml"; 
        } 
 } 
	
	 public String sair() {  
		 usuarioLogado = null; 
         FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,  
                                                  "Usuario Desconectado!" , ""); 
         FacesContext.getCurrentInstance().addMessage(null, mensagem);                  
         return "/faces/Login/LoginAdForm.xhtml"; 
  }    

	
}

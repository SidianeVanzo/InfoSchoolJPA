package br.upf.projeto.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import com.sun.faces.action.RequestMapping;

import br.upf.casca.ads.beans.classes.Pessoa;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;


@ManagedBean
@SessionScoped
public class LoginControle implements Serializable {

	private String usuario;
	private String senha;
	private HttpSession session;
	/**
	 * Atributo para controle do usu�rio logado. � inicializado quando
	 * informados usuario e senha v�lidos. Setado para null quando o usu�rio sair
	 * do sistema.
	 */
	private Pessoa usuarioLogado = null;

	public LoginControle() {
		super();
	}

	/**
	 * M�todo respons�vel por valodar o usuario e senha do usu�rio. Se for v�lido
	 * inicializa o usu�rio logado com a instancia do usu�rio respectivo ao
	 * usuario e senha informados e redireciona para a tela principal da
	 * aplica��o.
	 * 
	 * @throws Exception
	 */
	

	public String entrar() {
		EntityManager em = ConexaoJPA.getEntityManager();
		Query qry = em.createQuery("from Pessoa where usuario = :usuario and senha = :senha");
		qry.setParameter("usuario", usuario);
		qry.setParameter("senha", senha);
		List<Pessoa> list = qry.getResultList();
		em.close();
		if (list.size() <= 0) {
			usuarioLogado = null;
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario ou senha inv�lida!", "");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			return "";
		} else {
			session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			usuarioLogado = list.get(0);
			session.setAttribute("tipo", usuarioLogado.getTipo());	
			return "/Sistema/Home/Home.xhtml";
		}
	}

	/**
	 * M�todo respons�vel por desconectar o usu�rio e abrir a p�gina de usuario
	 * 
	 * @throws Exception
	 */
	public String sair() {
		usuarioLogado = null;
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu�rio Desconectado!", "");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
		return "/faces/Login/LoginForm.xhtml";
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


}

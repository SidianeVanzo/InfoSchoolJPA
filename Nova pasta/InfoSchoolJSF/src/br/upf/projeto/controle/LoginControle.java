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
	 * Atributo para controle do usuário logado. É inicializado quando
	 * informados usuario e senha válidos. Setado para null quando o usuário sair
	 * do sistema.
	 */
	private Pessoa usuarioLogado = null;

	public LoginControle() {
		super();
	}

	/**
	 * Método responsável por valodar o usuario e senha do usuário. Se for válido
	 * inicializa o usuário logado com a instancia do usuário respectivo ao
	 * usuario e senha informados e redireciona para a tela principal da
	 * aplicação.
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
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario ou senha inválida!", "");
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
	 * Método responsável por desconectar o usuário e abrir a página de usuario
	 * 
	 * @throws Exception
	 */
	public String sair() {
		usuarioLogado = null;
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário Desconectado!", "");
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

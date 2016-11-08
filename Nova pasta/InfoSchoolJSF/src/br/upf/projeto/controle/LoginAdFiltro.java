package br.upf.projeto.controle;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns={"/faces/Ad_Cadastros/*", "/faces/Ad_Sistema/*"})
public class LoginAdFiltro implements Filter {

    /**
     * Default constructor. 
     */
    public LoginAdFiltro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request; 
        HttpServletResponse httpResponse = (HttpServletResponse) response; 
        HttpSession sessao = httpRequest.getSession(); 
        String contextPath = httpRequest.getContextPath(); 
         
        LoginAdControle lc = (LoginAdControle) sessao.getAttribute("loginAdControle"); 
        if ((lc == null) || (lc.getUsuarioLogado() == null)){  
           httpResponse.sendRedirect(contextPath + "/faces/Login/LoginAdForm.xhtml"); 
        } 
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

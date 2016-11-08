package br.upf.projeto.relatorios;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import br.upf.casca.ads.beans.classes.Cidade;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@ManagedBean
@RequestScoped
public class AlunosRel {

	private Cidade cidade;

	public void executaRelatorio() {

		try {
			HashMap parameters = new HashMap();
			// passar a cidade por parametro para o relatoriio
			parameters.put("CIDADE", cidade.getId());
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.responseComplete();
			ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
			Connection con = ConexaoJPA.getEntityManagerJDBCConnection();
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					scontext.getRealPath("/WEB-INF/Relatorios/Alunos/Alunos.jasper"), parameters, con);
			byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);
			HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();
			res.setContentType("application/pdf");
			res.setHeader("Content-disposition", "inline;filename=arquivo.pdf"); // diretamente
																					// na
																					// página
			// res.setHeader("Content-disposition",
			// "attachment;filename=arquivo.pdf");// baixar ou salvar
			res.getOutputStream().write(b);
			res.getCharacterEncoding();
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Cidade> completeCidade(String query) {
		EntityManager em = ConexaoJPA.getEntityManager();
		List<Cidade> results = em.createQuery(
				"from Cidade where upper(nome) like " + "'" + query.trim().toUpperCase() + "%' " + "order by nome")
				.getResultList();
		em.close();
		return results;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}

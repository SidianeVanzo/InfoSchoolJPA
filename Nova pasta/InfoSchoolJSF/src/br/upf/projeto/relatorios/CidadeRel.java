package br.upf.projeto.relatorios;

import java.sql.Connection;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import br.upf.casca.ads.beans.uteis.ConexaoJPA;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@ManagedBean
@RequestScoped
public class CidadeRel {

	public void executaRelatorio(){
	
		try {
			HashMap parameters = new HashMap();
			
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.responseComplete();
			ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
			Connection con = ConexaoJPA.getEntityManagerJDBCConnection();
			JasperPrint jasperPrint = JasperFillManager.fillReport(scontext.getRealPath(
			"/WEB-INF/Relatorios/Cidade/Cidade.jasper"), parameters, con);
			byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);
			HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			res.setContentType("application/pdf");
			res.setHeader("Content-disposition", "inline;filename=arquivo.pdf"); // diretamente na página
			//res.setHeader("Content-disposition", "attachment;filename=arquivo.pdf");// baixar ou salvar
			res.getOutputStream().write(b);
			res.getCharacterEncoding();
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
}

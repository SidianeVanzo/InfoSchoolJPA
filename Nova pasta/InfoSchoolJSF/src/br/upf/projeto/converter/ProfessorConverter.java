package br.upf.projeto.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.upf.casca.ads.beans.classes.Professor;
import br.upf.casca.ads.beans.uteis.ConexaoJPA;

@FacesConverter(value = "professorConverter")
public class ProfessorConverter implements Converter{
	@Override
	public Professor getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				EntityManager em = ConexaoJPA.getEntityManager();
				Professor ret = em.find(Professor.class, Integer.parseInt(value));
				em.close();
				return ret;
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro de Conversão do Professor", "Professor inválido."));
			}
		} else
			return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((Professor) object).getId());
		} else
			return null;
	}
}

package br.upf.casca.ads.beans.classes;

import java.io.Serializable;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import br.upf.casca.ads.beans.classes.Pessoa;
import static javax.persistence.FetchType.EAGER;

/**
 * Entity implementation class for Entity: Professor
 *
 */
@Entity
public class Professor extends Pessoa implements Serializable {

	@ManyToMany(fetch = EAGER)
	//retorna uma lista de cursos, para que o professor escolha qual ele é habilitado para lecionar
	private List<Curso> cursosHabilitados;
	
	private Boolean manha;
	private Boolean tarde;
	private Boolean noite;
	
	private Boolean segundaFeira;
	private Boolean tercaFeira;
	private Boolean quartaFeira;
	private Boolean quintaFeira;
	private Boolean sextaFeira;
	private Boolean sabado;
	
	private static final long serialVersionUID = 1L;

	public Professor() {
		super();
		//retorna uma coleção de cursos, podendo ser usada qualquer informação do mesmo
		cursosHabilitados = new ArrayList<>();
	}   
  
	public Professor(Integer id) {
		super(id);
	}

	public List<Curso> getCursosHabilitados() {
		return cursosHabilitados;
	}

	public void setCursosHabilitados(List<Curso> cursosHabilitados) {
		this.cursosHabilitados = cursosHabilitados;
	}

	public Boolean getManha() {
		return manha;
	}

	public void setManha(Boolean manha) {
		this.manha = manha;
	}

	public Boolean getTarde() {
		return tarde;
	}

	public void setTarde(Boolean tarde) {
		this.tarde = tarde;
	}

	public Boolean getNoite() {
		return noite;
	}

	public void setNoite(Boolean noite) {
		this.noite = noite;
	}

	public Boolean getSegundaFeira() {
		return segundaFeira;
	}

	public void setSegundaFeira(Boolean segundaFeira) {
		this.segundaFeira = segundaFeira;
	}

	public Boolean getTercaFeira() {
		return tercaFeira;
	}

	public void setTercaFeira(Boolean tercaFeira) {
		this.tercaFeira = tercaFeira;
	}

	public Boolean getQuartaFeira() {
		return quartaFeira;
	}

	public void setQuartaFeira(Boolean quartaFeira) {
		this.quartaFeira = quartaFeira;
	}

	public Boolean getQuintaFeira() {
		return quintaFeira;
	}

	public void setQuintaFeira(Boolean quintaFeira) {
		this.quintaFeira = quintaFeira;
	}

	public Boolean getSextaFeira() {
		return sextaFeira;
	}

	public void setSextaFeira(Boolean sextaFeira) {
		this.sextaFeira = sextaFeira;
	}

	public Boolean getSabado() {
		return sabado;
	}

	public void setSabado(Boolean sabado) {
		this.sabado = sabado;
	}

	public Professor(List<Curso> cursosHabilitados, Boolean manha, Boolean tarde, Boolean noite, Boolean segundaFeira,
			Boolean tercaFeira, Boolean quartaFeira, Boolean quintaFeira, Boolean sextaFeira, Boolean sabado) {
		super();
		
		this.cursosHabilitados = cursosHabilitados;
		this.manha = manha;
		this.tarde = tarde;
		this.noite = noite;
		this.segundaFeira = segundaFeira;
		this.tercaFeira = tercaFeira;
		this.quartaFeira = quartaFeira;
		this.quintaFeira = quintaFeira;
		this.sextaFeira = sextaFeira;
		this.sabado = sabado;
	}

	public Professor(Integer id, String nome, String telefone, String email, String endereco, String usuario,
			String senha, String tipo, List<Curso> cursosHabilitados, Boolean manha, Boolean tarde, Boolean noite,
			Boolean segundaFeira, Boolean tercaFeira, Boolean quartaFeira, Boolean quintaFeira, Boolean sextaFeira,
			Boolean sabado) {
		super(id, nome, telefone, email, endereco, usuario, senha, tipo);
		this.cursosHabilitados = cursosHabilitados;
		this.manha = manha;
		this.tarde = tarde;
		this.noite = noite;
		this.segundaFeira = segundaFeira;
		this.tercaFeira = tercaFeira;
		this.quartaFeira = quartaFeira;
		this.quintaFeira = quintaFeira;
		this.sextaFeira = sextaFeira;
		this.sabado = sabado;
	}
}

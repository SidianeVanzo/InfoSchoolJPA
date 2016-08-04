package br.upf.casca.ads.beans.classes;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: Curso
 *
 */

@Entity

public class Curso implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "CursoId")
	@SequenceGenerator(name = "CursoId", sequenceName = "CursoId", allocationSize = 1)
	private Integer id;
	
	@Length(max=50, message="O tamanho máximo do nome do Curso é {max} caracteres")
	@NotEmpty(message="O nome do curso não pode estar vazio!")
	private String nome;
	
	private Boolean manha;
	private Boolean tarde;
	private Boolean noite;
	
	private Boolean segundaFeira;
	private Boolean tercaFeira;
	private Boolean quartaFeira;
	private Boolean quintaFeira;
	private Boolean sextaFeira;
	private Boolean sabado;
	
	@Length(max=6, message="O tamanho máximo da carga horária é {max} caracteres")
	@NotEmpty(message="A carga horaria não pode estar vazia!")
	private String cargaHoraria;
	
//	@ManyToOne(optional = false)
//	@NotNull(message="O campo Pessoa nao pode estar vazio")
//	private Pessoa pessoa;
	private static final long serialVersionUID = 1L;
	


	public Curso() {
		super();
	} 
	
	public Curso(Integer id) {
		super();
		this.id = id;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
   
	public String getCargaHoraria() {
		return this.cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
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

	public Curso(Integer id, String nome, Boolean manha, Boolean tarde, Boolean noite, Boolean segundaFeira,
			Boolean tercaFeira, Boolean quartaFeira, Boolean quintaFeira, Boolean sextaFeira, Boolean sabado,
			String cargaHoraria) {
		super();
		this.id = id;
		this.nome = nome;
		this.manha = manha;
		this.tarde = tarde;
		this.noite = noite;
		this.segundaFeira = segundaFeira;
		this.tercaFeira = tercaFeira;
		this.quartaFeira = quartaFeira;
		this.quintaFeira = quintaFeira;
		this.sextaFeira = sextaFeira;
		this.sabado = sabado;
		this.cargaHoraria = cargaHoraria;
	}   

	
	
}

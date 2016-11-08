package br.upf.casca.ads.beans.classes;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * Entity implementation class for Entity: Cidade
 *
 */
@Entity

public class Aula implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "AulaId")
	@SequenceGenerator(name = "AulaId", sequenceName = "AulaId", allocationSize = 1)
	private Integer id;
	
	@NotNull(message="A data da aula nao pode estar vazia!")
	@Temporal(DATE)
	private Date data;
	
	@NotEmpty(message="Deve informar a descricao da aula")
	@Length(max=400, message="O tamanho maximo da descricao da aula é de {max}")
	private String descricao;
	
	@ManyToOne(optional=false)
	@NotNull(message="A turma nao pode estar vazia")
	private Turma turma;
	
	@OneToMany(cascade = ALL, fetch = EAGER)
	private List<Chamada> chamada;
	

	private static final long serialVersionUID = 1L;

	public Aula() {
		super();
	} 
	
	public Aula(Integer id) {
		super();
		this.id = id;
		data = new Date();
		chamada = new ArrayList<Chamada>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Chamada> getChamada() {
		return chamada;
	}
	
	public void setChamada(List<Chamada> chamada){
		this.chamada = chamada;
	}

	public Aula(Integer id, Date data, String descricao, Turma turma, List<Chamada> chamada) {
		super();
		this.id = id;
		this.data = data;
		this.descricao = descricao;
		this.turma = turma;
		this.chamada = chamada;
	}




	
}
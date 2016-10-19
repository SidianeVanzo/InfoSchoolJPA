package br.upf.casca.ads.beans.classes;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

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
	

	private static final long serialVersionUID = 1L;

	public Aula() {
		super();
	} 
	
	public Aula(Integer id) {
		super();
		this.id = id;
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

	public Aula(Integer id, Date data, String descricao, Turma turma) {
		super();
		this.id = id;
		this.data = data;
		this.descricao = descricao;
		this.turma = turma;
	}

	
}
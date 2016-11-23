package br.upf.casca.ads.beans.classes;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.Length;

/**
 * Entity implementation class for Entity: Chamada
 *
 */
@Entity

public class Chamada implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "ChamadaId")
	@SequenceGenerator(name = "ChamadaId", sequenceName = "ChamadaId", allocationSize = 1)
	private Integer id;
	
	@Length(max=20, message="O tamanho máximo da descricao das provas é {max} caracteres")
	//@NotEmpty(message="A descricao das provas não pode estar vazia!")
	private String provas;
	
	//@NotNull(message="A nota da prova deve ser preenchida")
	private Double notasProvas;
	
	//@Length(max=1, message="O tamanho máximo do comparimento de aulas é {max} caracteres")
	//@NotEmpty(message="O campo comparecimentoAula não pode estar vazio!")
	@Column(name="comparecimento", nullable=false)
	private Boolean comparecimentoAula;
	
	@ManyToOne
    @JoinColumn(name="AlunoID", referencedColumnName="ID", nullable=false)
	private Alunos aluno;
	
	static final long serialVersionUID = 1L;

	public Chamada() {
		super();
	} 
	
	public Chamada(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
   
	public String getProvas() {
		return this.provas;
	}

	public void setProvas(String provas) {
		this.provas = provas;
	}   
	public Double getNotasProvas() {
		return this.notasProvas;
	}

	public void setNotasProvas(Double notasProvas) {
		this.notasProvas = notasProvas;
	}   


	public Boolean getComparecimentoAula() {
		return comparecimentoAula;
	}

	public void setComparecimentoAula(Boolean comparecimentoAula) {
		this.comparecimentoAula = comparecimentoAula;
	}

	public Alunos getAluno() {
		return aluno;
	}

	public void setAluno(Alunos aluno) {
		this.aluno = aluno;
	}

	public Chamada(Integer id, String provas, Double notasProvas, Boolean comparecimentoAula, Alunos aluno) {
		super();
		this.id = id;
		this.provas = provas;
		this.notasProvas = notasProvas;
		this.comparecimentoAula = comparecimentoAula;
		this.aluno = aluno;
	}


	
	
}

package br.upf.casca.ads.beans.classes;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

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
	
	@Length(max=10, message="O tamanho máximo do horário é {max} caracteres")
	@NotEmpty(message="O horário não pode estar vazio!")
	private String horario;
	
	@NotNull(message="A data das aulas nao deve ser nula")
	@Temporal(DATE)
	private Date datasAulas;
	
	@Length(max=500, message="O tamanho máximo do conteudo da aula é {max} caracteres")
	@NotEmpty(message="O conteudo da aula não pode estar vazio!")
	private String conteudoAula;
	
	@Length(max=20, message="O tamanho máximo da descricao das provas é {max} caracteres")
	@NotEmpty(message="A descricao das provas não pode estar vazia!")
	private String provas;
	
	@NotNull(message="A nota da prova deve ser preenchida")
	private Double notasProvas;
	
	@NotNull(message="A nota da recuperação deve ser preenchida")
	private Double notaRecuperacao;
	
	@Length(max=1, message="O tamanho máximo do comparimento de aulas é {max} caracteres")
	@NotEmpty(message="O campo comparecimentoAula não pode estar vazio!")
	private String comparecimentoAula;
	
	@ManyToOne(optional = false)
	@NotNull(message="O campo Turma nao pode estar vazio")
	private Turma turma;
	
	private static final long serialVersionUID = 1L;

	public Chamada() {
		super();
	} 
	
	public Chamada(Integer id) {
		super();
		this.id = id;
	}

	public Chamada(Integer id, String horario, Date datasAulas, String conteudoAula, String provas,
			Double notasProvas, Double notaRecuperacao, String comparecimentoAula, Turma turma) {
		super();
		this.id = id;
		this.horario = horario;
		this.datasAulas = datasAulas;
		this.conteudoAula = conteudoAula;
		this.provas = provas;
		this.notasProvas = notasProvas;
		this.notaRecuperacao = notaRecuperacao;
		this.comparecimentoAula = comparecimentoAula;
		this.turma = turma;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}   
	public Date getDatasAulas() {
		return this.datasAulas;
	}

	public void setDatasAulas(Date datasAulas) {
		this.datasAulas = datasAulas;
	}   
	public String getConteudoAula() {
		return this.conteudoAula;
	}

	public void setConteudoAula(String conteudoAula) {
		this.conteudoAula = conteudoAula;
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
	public Double getNotaRecuperacao() {
		return this.notaRecuperacao;
	}

	public void setNotaRecuperacao(Double notaRecuperacao) {
		this.notaRecuperacao = notaRecuperacao;
	}   
	public String getComparecimentoAula() {
		return this.comparecimentoAula;
	}

	public void setComparecimentoAula(String comparecimentoAula) {
		this.comparecimentoAula = comparecimentoAula;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}

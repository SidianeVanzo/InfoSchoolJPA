package br.upf.casca.ads.beans.classes;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.CascadeType.ALL;

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
	
	@NotNull(message="O horário de inicio não pode estar vazio!")
	@Temporal(TemporalType.TIME)
	private Date horarioInicio;
	
	@NotNull(message="O horário de fim não pode estar vazio!")
	@Temporal(TemporalType.TIME)
	private Date horarioFim;
	
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
	
	@OneToMany(cascade = ALL, mappedBy = "descricao", fetch = EAGER)
	private List<Aula> aula;
	
	@ManyToMany(fetch = EAGER)
	private List<Alunos> listaAlunos;
	
	static final long serialVersionUID = 1L;

	public Chamada() {
		super();
		listaAlunos = new ArrayList<>();
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

	public Date getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(Date horarioFim) {
		this.horarioFim = horarioFim;
	}

	public Date getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public List<Alunos> getListaAlunos() {
		return listaAlunos;
	}

	public void setListaAlunos(List<Alunos> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}

	public List<Aula> getAula() {
		return aula;
	}

	public void setAula(List<Aula> aula) {
		this.aula = aula;
	}

	public Chamada(Integer id, Date horarioInicio, Date horarioFim, String provas, Double notasProvas,
			Double notaRecuperacao, String comparecimentoAula, List<Aula> aula, List<Alunos> listaAlunos) {
		super();
		this.id = id;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.provas = provas;
		this.notasProvas = notasProvas;
		this.notaRecuperacao = notaRecuperacao;
		this.comparecimentoAula = comparecimentoAula;
		this.aula = aula;
		this.listaAlunos = listaAlunos;
	}
	
	
}

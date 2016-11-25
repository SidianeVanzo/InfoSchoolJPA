package br.upf.casca.ads.beans.classes;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.upf.casca.ads.beans.constraints.StringOptionsValid;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Turma
 *
 */
@Entity
public class Turma implements Serializable {
       
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "TurmaId")
	@SequenceGenerator(name = "TurmaId", sequenceName = "TurmaId", allocationSize = 1)
	private Integer id;
	
	@NotEmpty(message="Nome não pode estar vazio!")
	private String nome;
	
	private Boolean segundaFeira;
	private Boolean tercaFeira;
	private Boolean quartaFeira;
	private Boolean quintaFeira;
	private Boolean sextaFeira;
	private Boolean sabado;
	
	private Boolean manha;
	private Boolean tarde;
	private Boolean noite;
	
	@ManyToOne
	@NotNull(message="O Curso nao pode estar vazio")
	private Curso curso;
	
	@Length(max=30)	
	//com o StringOptionsValid, só será possível escolher uma das opções informadas abaixo para informar no tipoTurma
	@StringOptionsValid(message="Opção inválida no tipo da turma!", opcoes={"NORMAL", "PARTICULAR", "FINALIZADA"})
	private String tipoTurma;
	
	@NotNull(message="O horário de inicio não pode estar vazio!")
	@Temporal(TemporalType.TIME)
	private Date horarioInicio;
	
	@NotNull(message="O horário de fim não pode estar vazio!")
	@Temporal(TemporalType.TIME)
	private Date horarioFim;
	
	@ManyToOne(optional = false)
	@NotNull(message="O Professor nao pode estar vazio")
	private Professor professor;
	
	@OneToMany(cascade = ALL, mappedBy = "turma", fetch=FetchType.EAGER)
	private List<AlunosTurma> alunosTurma;
	
	private static final long serialVersionUID = 1L;

	public Turma() {
		super();
	}   
	
	public Turma(Integer id) {
		super();
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}   

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public List<AlunosTurma> getAlunosTurma() {
		return alunosTurma;
	}
	public void setAlunosTurma(List<AlunosTurma> alunosTurma) {
		this.alunosTurma = alunosTurma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getTipoTurma() {
		return tipoTurma;
	}

	public void setTipoTurma(String tipoTurma) {
		this.tipoTurma = tipoTurma;
	}

	public Date getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Date getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(Date horarioFim) {
		this.horarioFim = horarioFim;
	}

	public Turma(Integer id, String nome, Boolean segundaFeira, Boolean tercaFeira, Boolean quartaFeira,
			Boolean quintaFeira, Boolean sextaFeira, Boolean sabado, Boolean manha, Boolean tarde, Boolean noite,
			Curso curso, String tipoTurma, Date horarioInicio, Date horarioFim, Professor professor,
			List<AlunosTurma> alunosTurma) {
		super();
		this.id = id;
		this.nome = nome;
		this.segundaFeira = segundaFeira;
		this.tercaFeira = tercaFeira;
		this.quartaFeira = quartaFeira;
		this.quintaFeira = quintaFeira;
		this.sextaFeira = sextaFeira;
		this.sabado = sabado;
		this.manha = manha;
		this.tarde = tarde;
		this.noite = noite;
		this.curso = curso;
		this.tipoTurma = tipoTurma;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.professor = professor;
		this.alunosTurma = alunosTurma;
	}



	
}

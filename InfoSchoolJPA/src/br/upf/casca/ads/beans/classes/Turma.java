package br.upf.casca.ads.beans.classes;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

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
	
	
	private String[] turno;
	
	@ManyToOne
	@NotNull(message="O Curso nao pode estar vazio")
	private Curso curso;
	
	@ManyToOne(optional = false)
	@NotNull(message="O Tipo Turma nao pode estar vazio")
	private TipoTurma tipoTurma;
	
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

	public String[] getTurno() {
		return this.turno;
	}
	
	public String getTurnoString() {
		String ret = "", v = "";
		if (turno != null){
			for(int i=0; i<turno.length; i++){
	          ret += v+turno[i];
			  v = ", ";		
			}
		}
		return ret;
	}	

	public void setTurno(String[] turno) {
		this.turno = turno;
	}   
	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}   
	public TipoTurma getTipoTurma() {
		return this.tipoTurma;
	}

	public void setTipoTurma(TipoTurma tipoTurma) {
		this.tipoTurma = tipoTurma;
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

	public Turma(Integer id, String nome, Boolean segundaFeira, Boolean tercaFeira, Boolean quartaFeira,
			Boolean quintaFeira, Boolean sextaFeira, Boolean sabado, String[] turno, Curso curso, TipoTurma tipoTurma,
			Professor professor, List<AlunosTurma> alunosTurma) {
		super();
		this.id = id;
		this.nome = nome;
		this.segundaFeira = segundaFeira;
		this.tercaFeira = tercaFeira;
		this.quartaFeira = quartaFeira;
		this.quintaFeira = quintaFeira;
		this.sextaFeira = sextaFeira;
		this.sabado = sabado;
		this.turno = turno;
		this.curso = curso;
		this.tipoTurma = tipoTurma;
		this.professor = professor;
		this.alunosTurma = alunosTurma;
	}
	
}

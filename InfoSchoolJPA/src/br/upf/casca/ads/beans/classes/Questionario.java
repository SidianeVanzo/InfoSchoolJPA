package br.upf.casca.ads.beans.classes;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.upf.casca.ads.beans.classes.Professor;
import br.upf.casca.ads.beans.constraints.TipoQuestionarioValido;

/**
 * Entity implementation class for Entity: Questionario
 *
 */
@Entity

public class Questionario implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "QuestionarioId")
	@SequenceGenerator(name = "QuestionarioId", sequenceName = "QuestionarioId", allocationSize = 1)
	private Integer id;
	
	@Length(max=20, message="O tamanho máximo do Tipo Questionário deve ser de {max} caracteres!")
	@NotEmpty(message="O Tipo Questionário não pode estar vazio!")
	@TipoQuestionarioValido(message="O Tipo Questionário deve ser válido", opcoes={"Durante o Curso", "Final do Curso"})
	private String tipoQuestionario;
	
	@Length(max=200, message="O tamanho máximo da pergunta deve ser de {max} caracteres!")
	@NotEmpty(message="A pergunta não pode estar vazia!")
	private String pergunta;
	
	@Length(max=600, message="O tamanho máximo da resposta deve ser de {max} caracteres!")
	@NotEmpty(message="A resposta não pode estar vazia!")
	private String resposta;
	
	@ManyToOne(optional = false)
	@NotNull(message="O Professor nao pode estar vazio")
	private Professor professor;
	
	@ManyToOne(optional = false)
	@NotNull(message="O Curso nao pode estar vazio")
	private Curso curso;
	
	@ManyToOne(optional = false)
	@NotNull(message="O Aluno nao pode estar vazio")
	private Alunos aluno;
	private static final long serialVersionUID = 1L;

	public Questionario() {
		super();
	}  
	
	public Questionario(Integer id) {
		super();
		this.id = id;
	}

	public Questionario(Integer id, String tipoQuestionario, String pergunta, String resposta, Professor professor,
			Curso curso, Alunos aluno) {
		super();
		this.id = id;
		this.tipoQuestionario = tipoQuestionario;
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.professor = professor;
		this.curso = curso;
		this.aluno = aluno;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getTipoQuestionario() {
		return this.tipoQuestionario;
	}

	public void setTipoQuestionario(String tipoQuestionario) {
		this.tipoQuestionario = tipoQuestionario;
	}   
	public String getPergunta() {
		return this.pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}   
	public String getResposta() {
		return this.resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}   
	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}   
	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}   
	public Alunos getAluno() {
		return this.aluno;
	}

	public void setAluno(Alunos aluno) {
		this.aluno = aluno;
	}
   
}

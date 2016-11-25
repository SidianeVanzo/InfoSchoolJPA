package br.upf.casca.ads.beans.classes;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.DATE;

/**
 * Entity implementation class for Entity: AlunosTurma
 *
 */
@Entity
public class AlunosTurma implements Serializable {
	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "AlunosTurmaId")
	@SequenceGenerator(name = "AlunosTurmaId", sequenceName = "AlunosTurmaId", allocationSize = 1)
	private Integer id;
	
	@NotNull(message="A data de inserção dos alunos a turma nao deve ser nula")
	@Temporal(DATE)
	private Date dataInsercaoAlunosTurma;
	
	@ManyToOne(cascade = ALL, optional = false)
	@JoinColumn(name = "alunos_id", referencedColumnName = "id")
	@NotNull(message="O campo Alunos nao pode estar vazio")
	private Alunos alunos;
	
	@ManyToOne(cascade = ALL, optional = false)
	@JoinColumn(name = "turma_codigo", referencedColumnName = "id")
	@NotNull(message="O campo Turma nao pode estar vazio")
	private Turma turma;
	
	private static final long serialVersionUID = 1L;

	public AlunosTurma() {
		super();
		//com a linha abaixo, na hora de escolher os alunos para a turma, a data ja estará com a data de hoje, mas é possível modificá-la
		dataInsercaoAlunosTurma = new Date();
	}
	
	public AlunosTurma(Integer id) {
		super();
		this.id = id;
	}

	public AlunosTurma(Integer id, Date dataInsercaoAlunosTurma, Alunos alunos, Turma turma) {
		super();
		this.id = id;
		this.dataInsercaoAlunosTurma = dataInsercaoAlunosTurma;
		this.alunos = alunos;
		this.turma = turma;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Date getDataInsercaoAlunosTurma() {
		return this.dataInsercaoAlunosTurma;
	}

	public void setDataInsercaoAlunosTurma(Date dataInsercaoAlunosTurma) {
		this.dataInsercaoAlunosTurma = dataInsercaoAlunosTurma;
	}   
	public Alunos getAlunos() {
		return this.alunos;
	}

	public void setAlunos(Alunos alunos) {
		this.alunos = alunos;
	}   
	public Turma getTurma() {
		return this.turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}   
}

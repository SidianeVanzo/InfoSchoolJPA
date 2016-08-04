package br.upf.casca.ads.beans.classes;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * Entity implementation class for Entity: TipoAluno
 *
 */
@Entity

public class TipoAluno implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "TipoAlunoId")
	@SequenceGenerator(name = "TipoAlunoId", sequenceName = "TipoAlunoId", allocationSize = 1)
	private Integer id;
	
	@Length(max=20, message="O tamanho máximo da descricao do TipoAluno deve ser de {max} caracteres!")
	@NotEmpty(message="A descrição do tipo de aluno não pode estar vazio!")
	private String descricao;
	
	private static final long serialVersionUID = 1L;

	public TipoAluno() {
		super();
	}  
	
	public TipoAluno(Integer id) {
		super();
		this.id = id;
	}

	public TipoAluno(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}   
   
}

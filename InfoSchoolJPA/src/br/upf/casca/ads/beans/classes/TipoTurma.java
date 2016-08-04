package br.upf.casca.ads.beans.classes;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: TipoTurma
 *
 */
@Entity

public class TipoTurma implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "TipoTurmaId")
	@SequenceGenerator(name = "TipoTurmaId", sequenceName = "TipoTurmaId", allocationSize = 1)
	private Integer id;
	
	@Length(max=30, message="O tamanho máximo da descricao do TipoTurma deve ser de {max} caracteres!")
	@NotEmpty(message="A descrição do tipo de turma não pode estar vazio!")
	private String descricao;
	private static final long serialVersionUID = 1L;

	public TipoTurma() {
		super();
	}   
	
	public TipoTurma(Integer id) {
		super();
		this.id = id;
	}

	public TipoTurma(Integer id, String descricao) {
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

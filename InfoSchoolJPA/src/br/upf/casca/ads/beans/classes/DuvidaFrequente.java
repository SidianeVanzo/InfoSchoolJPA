package br.upf.casca.ads.beans.classes;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Alunos
 *
 */
@Entity

public class DuvidaFrequente implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "AlunosId")
	@SequenceGenerator(name = "AlunosId", sequenceName = "AlunosId", allocationSize = 1)
	private Integer id;
	
	@Length(max=200, message="O tamanho máximo da pergunta deve ser de {max} caracteres!")
	@NotEmpty(message="A pergunta não pode estar vazia!")
	private String pergunta;
	
	@NotEmpty(message="A resposta não pode estar vazia")
	@Length(max=400, message="O tamanho máximo da resposta é {max} caracteres")
	private String resposta;
	
	
	private static final long serialVersionUID = 1L;

	public DuvidaFrequente() {
		super();
	}  
	
	public DuvidaFrequente(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public DuvidaFrequente(Integer id, String pergunta, String resposta) {
		super();
		this.id = id;
		this.pergunta = pergunta;
		this.resposta = resposta;
	}   
	
	
}

package br.upf.casca.ads.beans.classes;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class PergRespQuest {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "PergRespQuestId")
	@SequenceGenerator(name = "PergRespQuestId", sequenceName = "PergRespQuestId", allocationSize = 1)
	private Integer id;
	
	@Length(max=200, message="O tamanho máximo da pergunta deve ser de {max} caracteres!")
	@NotEmpty(message="A pergunta não pode estar vazia!")
	private String pergunta;
	
	@Length(max=600, message="O tamanho máximo da resposta deve ser de {max} caracteres!")
	@NotEmpty(message="A resposta não pode estar vazia!")
	private String resposta;
	
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

	public PergRespQuest(Integer id, String pergunta, String resposta) {
		super();
		this.id = id;
		this.pergunta = pergunta;
		this.resposta = resposta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PergRespQuest() {
		super();
	}

	public PergRespQuest(Integer id) {
		super();
		this.id = id;
	}
	
	
}

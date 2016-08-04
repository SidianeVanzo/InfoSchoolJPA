package br.upf.casca.ads.beans.classes;

import java.io.Serializable;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Secretaria extends Pessoa implements Serializable{

	@Length(max=20, message="O tamanho máximo do horario do expediente deve ser de {max} caracteres!")
	@NotEmpty(message="O horario de expediente não pode estar vazio!")
	private String horarioExpediente;
	
	@Length(max=40, message="O tamanho máximo da formação deve ser de {max} caracteres!")
	@NotEmpty(message="A formação não pode estar vazia!")
	private String formacao;
	
	private static final long serialVersionUID = 1L;

	public Secretaria(Integer id) {
		super(id);
	}

	public Secretaria() {
		super();
	}

	public Secretaria(Integer id, String nome, String telefone, String email, String endereco, String usuario,
			String senha, String horarioExpediente, String formacao) {
		super(id, nome, telefone, email, endereco, usuario, senha);
		this.horarioExpediente = horarioExpediente;
		this.formacao = formacao;
	}

	public String getHorarioExpediente() {
		return horarioExpediente;
	}

	public void setHorarioExpediente(String horarioExpediente) {
		this.horarioExpediente = horarioExpediente;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	
	
}

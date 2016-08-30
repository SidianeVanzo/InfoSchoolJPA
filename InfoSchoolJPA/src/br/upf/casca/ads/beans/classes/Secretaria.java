package br.upf.casca.ads.beans.classes;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Secretaria extends Pessoa implements Serializable{

	@NotNull(message="O horário de inicio doexpediente não pode estar vazio!")
	@Temporal(TemporalType.TIME)
	private Date horarioInicioExpediente;
	
	@NotNull(message="O horário de fim do expediente não pode estar vazio!")
	@Temporal(TemporalType.TIME)
	private Date horarioFimExpediente;
	
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

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public Date getHorarioInicioExpediente() {
		return horarioInicioExpediente;
	}

	public void setHorarioInicioExpediente(Date horarioInicioExpediente) {
		this.horarioInicioExpediente = horarioInicioExpediente;
	}

	public Date getHorarioFimExpediente() {
		return horarioFimExpediente;
	}

	public void setHorarioFimExpediente(Date horarioFimExpediente) {
		this.horarioFimExpediente = horarioFimExpediente;
	}

	public Secretaria(Date horarioInicioExpediente, Date horarioFimExpediente, String formacao) {
		super();
		this.horarioInicioExpediente = horarioInicioExpediente;
		this.horarioFimExpediente = horarioFimExpediente;
		this.formacao = formacao;
	}

	public Secretaria(Integer id, String nome, String telefone, String email, String endereco, String usuario,
			String senha, String tipo, Date horarioInicioExpediente, Date horarioFimExpediente, String formacao) {
		super(id, nome, telefone, email, endereco, usuario, senha, tipo);
		this.horarioInicioExpediente = horarioInicioExpediente;
		this.horarioFimExpediente = horarioFimExpediente;
		this.formacao = formacao;
	}
	
	
	
	
}

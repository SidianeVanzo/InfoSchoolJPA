package br.upf.casca.ads.beans.classes;

import br.upf.casca.ads.beans.classes.Pessoa;

import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: Administrador
 *
 */
@Entity

public class Administrador extends Pessoa implements Serializable {

	@NotNull(message="A data de cadastro nao pode ser nula")
	@Temporal(DATE)
	private Date dataCadastro;
	private static final long serialVersionUID = 1L;

	public Administrador() {
		super();		
	}

	public Administrador(Date dataCadastro) {
		super();
		this.dataCadastro = dataCadastro;
	}

	public Administrador(Integer id) {
		super(id);		
	}

	public Administrador(Integer id, String nome, String telefone, String email, String endereco, String usuario,
			String senha, String tipo, Date dataCadastro) {
		super(id, nome, telefone, email, endereco, usuario, senha, tipo);
		this.dataCadastro = dataCadastro;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}

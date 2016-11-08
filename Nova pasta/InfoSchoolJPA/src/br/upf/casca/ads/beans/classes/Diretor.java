package br.upf.casca.ads.beans.classes;

import br.upf.casca.ads.beans.classes.Pessoa;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: Diretor
 *
 */
@Entity

public class Diretor extends Pessoa implements Serializable {

	@Length(max=40, message="O tamanho máximo da formação deve ser de {max} caracteres!")
	@NotEmpty(message="A formação não pode estar vazia!")
	private String formacao;
	private static final long serialVersionUID = 1L;

	public Diretor() {
		super();
	}   
	
	public String getFormacao() {
		return this.formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public Diretor(Integer id, String formacao) {
		super(id);
		this.formacao = formacao;
	}

	public Diretor(Integer id, String nome, String telefone, String email, String endereco, String usuario,
			String senha, String tipo, String formacao) {
		super(id, nome, telefone, email, endereco, usuario, senha, tipo);
		this.formacao = formacao;
	}
	
	
	
   
	
}

package br.upf.casca.ads.beans.classes;

import br.upf.casca.ads.beans.classes.Pessoa;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: Administrador
 *
 */
@Entity

public class Administrador extends Pessoa implements Serializable {

	@Length(max=40, message="O tamanho máximo da formação deve ser de {max} caracteres!")
	@NotEmpty(message="A formação não pode estar vazia!")
	private String dataCadastro;
	private static final long serialVersionUID = 1L;

	public Administrador() {
		
		super();
		
	}

	public Administrador(String dataCadastro) {
		super();
		this.dataCadastro = dataCadastro;
	}

	public Administrador(Integer id) {
		super(id);
		
	}

	public Administrador(Integer id, String nome, String telefone, String email, String endereco, String usuario,
			String senha, String tipo, String dataCadastro) {
		super(id, nome, telefone, email, endereco, usuario, senha, tipo);
		tipo = "ADMINISTRADOR";
		this.dataCadastro = dataCadastro;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	  
	
	
	
	
	
}

package br.upf.casca.ads.beans.classes;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.InheritanceType.JOINED;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity
@Inheritance(strategy = JOINED)
public abstract class Pessoa implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "PessoaId")
	@SequenceGenerator(name = "PessoaId", sequenceName = "PessoaId", allocationSize = 1)
	private Integer id;
	
	@Length(max=60, message="O tamanho máximo do nome da Pessoa deve ser de {max} caracteres!")
	@NotEmpty(message="O nome da pessoa não pode estar vazio!")
	private String nome;
	
	@Length(max=12, message="O tamanho máximo do telefone deve ser de {max} caracteres!")
	@NotEmpty(message="O telefone não pode estar vazio!")
	private String telefone;
	
	@Length(max=80, message="O tamanho máximo do email é {max} caracteres")
	@Email
	private String email;
	
	@NotEmpty(message="O endereco não pode ser vazio")
	@Length(max=60, message="O tamanho máximo do endereco deve ser {max}")
	private String endereco;
	
	@Length(max=20, message="O tamanho máximo do usuario deve ser de {max} caracteres!")
	@NotEmpty(message="O usuário não pode estar vazio!")
	private String usuario;
	
	@Length(max=20, message="O tamanho máximo da senha deve ser de {max} caracteres!")
	@NotEmpty(message="A senha não pode estar vazia!")
	private String senha;
	
	private static final long serialVersionUID = 1L;

	public Pessoa() {
		super();
	}   
	
	public Pessoa(Integer id) {
		super();
		this.id = id;
	}

	public Pessoa(Integer id, String nome, String telefone, String email, String endereco, String usuario, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}   
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}   

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
   
	
}

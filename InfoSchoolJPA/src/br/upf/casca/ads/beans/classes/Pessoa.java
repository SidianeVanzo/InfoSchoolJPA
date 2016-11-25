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

import br.upf.casca.ads.beans.constraints.StringOptionsValid;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity
@Inheritance(strategy = JOINED)
//com essa linha, n�o ser� poss�vel cadastrar dois usu�rios ou e-mails iguais no bd
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"usuario", "email"})})
public abstract class Pessoa implements Serializable {
	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "PessoaId")
	@SequenceGenerator(name = "PessoaId", sequenceName = "PessoaId", allocationSize = 1)
	private Integer id;
	
	@Length(max=60, message="O tamanho m�ximo do nome da Pessoa deve ser de {max} caracteres!")
	@NotEmpty(message="O nome da pessoa n�o pode estar vazio!")
	private String nome;
	
	@Length(max=12, message="O tamanho m�ximo do telefone deve ser de {max} caracteres!")
	@NotEmpty(message="O telefone n�o pode estar vazio!")
	private String telefone;
	
	@Length(max=80, message="O tamanho m�ximo do email � {max} caracteres")
	@Email
	private String email;
	
	@NotEmpty(message="O endereco n�o pode ser vazio")
	@Length(max=60, message="O tamanho m�ximo do endereco deve ser {max}")
	private String endereco;
	
	@Length(max=20, message="O tamanho m�ximo do usuario deve ser de {max} caracteres!")
	@NotEmpty(message="O usu�rio n�o pode estar vazio!")
	private String usuario;
	
	@Length(max=20, message="O tamanho m�ximo da senha deve ser de {max} caracteres!")
	@NotEmpty(message="A senha n�o pode estar vazia!")
	private String senha;
	
	@Length(max=30)	
	//com a Constraint StringOptionsValid, o tipo s� poder� conter uma das op��es informadas abaixo, n�o poder� ser uma op��o diferente
	@StringOptionsValid(message="Op��o inv�lida no tipo!", opcoes={"ADMINISTRADOR", "SECRETARIA", "DIRETOR", "PROFESSOR"})
	private String tipo;
	
	private static final long serialVersionUID = 1L;

	public Pessoa() {
		super();
	}   
	
	public Pessoa(Integer id) {
		super();
		this.id = id;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pessoa(Integer id, String nome, String telefone, String email, String endereco, String usuario, String senha,
			String tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.usuario = usuario;
		this.senha = senha;
		this.tipo = tipo;
	}	
}

package br.upf.casca.ads.beans.classes;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import br.upf.casca.ads.beans.constraints.StringOptionsValid;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.DATE;

/**
 * Entity implementation class for Entity: Alunos
 *
 */
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"email", "cpf", "rg"})})
public class Alunos implements Serializable {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "AlunosId")
	@SequenceGenerator(name = "AlunosId", sequenceName = "AlunosId", allocationSize = 1)
	private Integer id;
	
	@Length(max=60, message="O tamanho m�ximo do nome do Aluno deve ser de {max} caracteres!")
	@NotEmpty(message="O nome do aluno n�o pode estar vazio!")
	private String nome;
	
	@NotEmpty(message="O cpf n�o pode estar vazio")
	@Length(max=14, message="O tamanho m�ximo do cpf � {max} caracteres")
	@CPF(message="O CPF � Inv�lido!")
	private String cpf;
	
	@Length(max=10, message="O tamanho m�ximo do rg � {max} caracteres")
	@NotEmpty(message="O rg n�o pode estar vazio!")
	private String rg;
	
	@Length(max=12, message="O tamanho m�ximo do telefone � {max} caracteres")
	@NotEmpty(message="O telefone n�o pode estar vazio!")
	private String telefone;
	
	@NotNull(message="A data de nascimento nao pode ser nula")
	@Past(message="A data deve estar no passado")
	@Temporal(DATE)
	private Date dataNascimento;
	
	@NotEmpty(message="O endereco n�o pode ser vazio")
	@Length(max=60, message="O tamanho m�ximo do endereco deve ser {max}")
	private String endereco;
	
	@Length(max=50, message="O tamanho m�ximo do{max email � } caracteres")
	@Email(message="E-mail inv�lido!")
	private String email;
	
	@ManyToOne(optional = false)
	@NotNull(message="A Cidade nao pode estar vazia")
	private Cidade cidade;
	
	@Length(max=30)	
	@StringOptionsValid(message="Op��o inv�lida no tipo!", opcoes={"EM ESPERA", "CURSANDO", "CONCLUINTE", "CANCELADO"})
	private String tipoAluno;
	

	private static final long serialVersionUID = 1L;

	public Alunos() {
		super();
	}  	
	
	public Alunos(Integer id) {
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
	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}   
	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}   
	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}    
	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}   
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	
  
	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}   

	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Alunos(Integer id, String nome, String cpf, String rg, String telefone, Date dataNascimento, String endereco,
			String email, Cidade cidade, String tipoAluno) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.email = email;
		this.cidade = cidade;
		this.tipoAluno = tipoAluno;
	}

	public String getTipoAluno() {
		return tipoAluno;
	}

	public void setTipoAluno(String tipoAluno) {
		this.tipoAluno = tipoAluno;
	}

  
}

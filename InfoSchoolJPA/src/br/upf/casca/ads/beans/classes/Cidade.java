package br.upf.casca.ads.beans.classes;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.upf.casca.ads.beans.constraints.UfValido;

/**
 * Entity implementation class for Entity: Cidade
 *
 */
@Entity

public class Cidade implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "CidadeId")
	@SequenceGenerator(name = "CidadeId", sequenceName = "CidadeId", allocationSize = 1)
	private Integer id;
	
	@NotEmpty(message="Deve informar o nome da cidade")
	@Length(max=60, message="O tamanho maximo do nome da cidade é de {max}")
	private String nome;
	
	@NotEmpty(message="a UF é obrigatória!")
	@Length(min=2, max=2, message="A UF deve ter dois caracteres!")
	@UfValido(message="A UF deve ser válida!", opcoes={"AC", "AL","AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", 
			"PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"})
	private String uf;
	
	
	private static final long serialVersionUID = 1L;

	public Cidade() {
		super();
	} 
	
	public Cidade(Integer id) {
		super();
		this.id = id;
	}

	public Cidade(Integer id, String nome, String uf) {
		super();
		this.id = id;
		this.nome = nome;
		this.uf = uf;
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
}

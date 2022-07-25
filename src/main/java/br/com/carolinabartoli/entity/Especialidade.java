package br.com.carolinabartoli.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_especialidade")
public class Especialidade {
	
	@Id
	@SequenceGenerator(name = "especialidade", sequenceName = "sq_tb_especialidade", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "especialidade")
	@Column(name = "id_especialidade")
	private int id;
	
	@Column(name="nm_especialidade", length = 40)
	private String nome;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Especialidade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Especialidade(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	

}

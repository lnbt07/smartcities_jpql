package br.com.carolinabartoli.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_paciente")
public class Paciente {

	@Id
	@SequenceGenerator(name = "paciente", sequenceName = "sq_tb_paciente", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente")
	@Column(name = "id_paciente")
	private int id;

	@Column(name = "nm_paciente", length = 80, nullable = false)
	private String nome;

	@Column(name = "ds_email_paciente", length = 80, nullable = false)
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nasc_paciente")
	private Calendar dataNasc;

	@Enumerated(EnumType.STRING)
	@Column(name = "ds_genero_paciente", columnDefinition = "CHAR")
	private Genero genero;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paciente(int id, String nome, String email, Calendar dataNasc, Genero genero) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataNasc = dataNasc;
		this.genero = genero;
	}

}

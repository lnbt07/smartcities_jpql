package br.com.carolinabartoli.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_consulta")
public class Consulta {

	@Id
	@SequenceGenerator(name = "consulta", sequenceName = "sq_tb_consulta", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consulta")
	@Column(name = "id_consulta")
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_consulta")
	private Calendar dataConsulta;

	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;

	@OneToOne
	@JoinColumn(name = "id_agendamento")
	private Agendamento agendamento;

	@ManyToOne
	@JoinColumn(name = "id_especialidade")
	private Especialidade especialidade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Calendar dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Consulta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consulta(int id, Calendar dataConsulta, Paciente paciente, Agendamento agendamento,
			Especialidade especialidade) {
		super();
		this.id = id;
		this.dataConsulta = dataConsulta;
		this.paciente = paciente;
		this.agendamento = agendamento;
		this.especialidade = especialidade;
	}

}

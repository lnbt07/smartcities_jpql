package br.com.carolinabartoli.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_agendamento")
public class Agendamento {

	@Id
	@SequenceGenerator(name = "agendamento", sequenceName = "sq_tb_agendamento", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agendamento")
	@Column(name = "id_agendamento")
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_agendamento")
	private Calendar dataAgendamento;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_consulta_prevista")
	private Calendar dataConsultaPrevista;

	@ManyToOne
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "id_especialidade")
	private Especialidade especialidade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Calendar dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Calendar getDataConsultaPrevista() {
		return dataConsultaPrevista;
	}

	public void setDataConsultaPrevista(Calendar dataConsultaPrevista) {
		this.dataConsultaPrevista = dataConsultaPrevista;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Agendamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agendamento(int id, Calendar dataAgendamento, Calendar dataConsultaPrevista, Paciente paciente,
			Especialidade especialidade) {
		super();
		this.id = id;
		this.dataAgendamento = dataAgendamento;
		this.dataConsultaPrevista = dataConsultaPrevista;
		this.paciente = paciente;
		this.especialidade = especialidade;
	}

}

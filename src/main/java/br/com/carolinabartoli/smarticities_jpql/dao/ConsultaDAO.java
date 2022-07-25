package br.com.carolinabartoli.smarticities_jpql.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.carolinabartoli.entity.Consulta;
import br.com.carolinabartoli.entity.Especialidade;

public class ConsultaDAO extends GenericDAO<Consulta, Integer> {

	public ConsultaDAO(EntityManager em) {
		super(em);
	}

	public List<Consulta> buscarPorEspecialidade(Especialidade esp) {
		return em.createQuery("from Consulta c where c.especialidade = :es", Consulta.class).setParameter("es", esp)
				.getResultList();
	}

	public List<Consulta> buscarPorData(Calendar inicio, Calendar fim) {
		return em.createQuery("from Consulta c where c.dataConsulta between :i and :f", Consulta.class)
				.setParameter("i", inicio).setParameter("f", fim).getResultList();
	}

	public List<Consulta> buscarPorEmailPaciente(String email) {
		return em.createQuery("from Consulta c where c.paciente.email = :email", Consulta.class)
				.setParameter("email", email).getResultList();
	}

}

package br.com.carolinabartoli.smarticities_jpql.dao;

import br.com.carolinabartoli.smarticities_jpql.dao.GenericDAO;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.carolinabartoli.entity.Agendamento;

public class AgendamentoDAO extends GenericDAO<Agendamento, Integer> {

	public AgendamentoDAO(EntityManager em) {
		super(em);
	}
	
	public int removerPorDataPrevista(Calendar data) {
		em.getTransaction().begin();
		int total = em.createQuery("delete Agendamento a where a.dataConsultaPrevista = :d").setParameter("d", data).executeUpdate();
		em.getTransaction().commit();
		return total;
	}

	public int atualizarDataPrevista(Calendar origem, Calendar nova) {
		em.getTransaction().begin();
		int total = em.createQuery("update Agendamento a set a.dataConsultaPrevista = :nova where a.dataConsultaPrevista = :origem")
				.setParameter("nova", nova).setParameter("origem", origem).executeUpdate();
		em.getTransaction().commit();
		return total;
	}

	public List<Agendamento> buscarPorData(Calendar data) {
		return em.createQuery("from Agendamento a where a.dataAgendamento = :data", Agendamento.class)
				.setParameter("data", data).getResultList();
	}

}

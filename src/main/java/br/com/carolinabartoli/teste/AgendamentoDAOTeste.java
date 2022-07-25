package br.com.carolinabartoli.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.carolinabartoli.entity.Agendamento;
import br.com.carolinabartoli.smarticities_jpql.dao.AgendamentoDAO;

public class AgendamentoDAOTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("smartcities_jpql");
		EntityManager em = fabrica.createEntityManager();

		AgendamentoDAO dao = new AgendamentoDAO(em);
		//Calendar origem = new GregorianCalendar(2017, Calendar.MARCH, 24);
		Calendar nova = new GregorianCalendar(2018, Calendar.MARCH, 24);
		//int total = dao.atualizarDataPrevista(origem, nova);
		int total = dao.removerPorDataPrevista(nova);
		System.out.println("Total "+total);

//		List<Agendamento> lista = dao.buscarPorData(new GregorianCalendar(2017, Calendar.MAY,16));
//		for (Agendamento agendamento : lista) {
//			System.out.println(agendamento.getDataAgendamento().getTime());
//			System.out.println(agendamento.getEspecialidade().getNome());
//			System.out.println(agendamento.getPaciente().getNome());
//		}

		fabrica.close();
		em.close();

	}

}

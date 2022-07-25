package br.com.carolinabartoli.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.carolinabartoli.entity.Consulta;
import br.com.carolinabartoli.entity.Especialidade;
import br.com.carolinabartoli.smarticities_jpql.dao.ConsultaDAO;
import br.com.carolinabartoli.smarticities_jpql.dao.EspecialidadeDAO;

public class ConsultaDAOTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("smartcities_jpql");
		EntityManager em = fabrica.createEntityManager();

		ConsultaDAO dao = new ConsultaDAO(em);
		EspecialidadeDAO espDao = new EspecialidadeDAO(em);
		Especialidade esp = espDao.buscar(1);

		Calendar inicio = new GregorianCalendar(2017, Calendar.MAY, 1);
		Calendar fim = new GregorianCalendar(2017, Calendar.AUGUST, 1);

		// List<Consulta> lista = dao.buscarPorEspecialidade(esp);
		//List<Consulta> lista = dao.buscarPorData(inicio, fim);
		List<Consulta> lista = dao.buscarPorEmailPaciente("pedro.lacerda.lima@yahoo.com.br");


		for (Consulta consulta : lista) {
			System.out.println(consulta.getEspecialidade().getNome());
			System.out.println(consulta.getDataConsulta().getTime());
			System.out.println(consulta.getPaciente().getNome());
		}

		fabrica.close();
		em.close();

	}

}

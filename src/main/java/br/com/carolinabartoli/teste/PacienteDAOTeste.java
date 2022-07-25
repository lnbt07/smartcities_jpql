package br.com.carolinabartoli.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.carolinabartoli.entity.Paciente;
import br.com.carolinabartoli.smarticities_jpql.dao.PacienteDAO;

public class PacienteDAOTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("smartcities_jpql");
		EntityManager em = fabrica.createEntityManager();

		PacienteDAO dao = new PacienteDAO(em);
		
		System.out.println("Quantidade de pacientes: "+dao.contar());

		List<Paciente> lista = dao.listar();
		//List<Paciente> lista = dao.listarPorNome(10,20);
		//List<Paciente> lista = dao.buscarPorNome("Amanda");
		//Paciente paciente = dao.buscarPorEmail("patricia.lima.ramos@usp.br");

		for (Paciente paciente : lista) {
			System.out.println(paciente.getEmail()+ " "+paciente.getNome());
		}

		fabrica.close();
		em.close();
	}

}

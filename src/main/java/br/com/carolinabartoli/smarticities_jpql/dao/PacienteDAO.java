package br.com.carolinabartoli.smarticities_jpql.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.carolinabartoli.entity.Paciente;

public class PacienteDAO extends GenericDAO<Paciente, Integer> {

	public PacienteDAO(EntityManager em) {
		super(em);
	}
	
	public long contar() {
		return em.createQuery("select count(p) from Paciente p",Long.class).getSingleResult();
	}
	
	public Paciente buscarPorEmail(String email) {
		return em.createQuery("from Paciente p where p.email = :e",Paciente.class).setParameter("e", email).getSingleResult();
	}
	
	public List<Paciente> listarPorNome(int inicio, int fim){
		return em.createQuery("from Paciente p order by nome",Paciente.class)
				.setFirstResult(inicio) //primeiro resultado do select
				.setMaxResults(fim) //serve para limitar a quantidade máxima de resultados
				.getResultList();
	}
	
	public List<Paciente> buscarPorNome(String nome){
		return em.createQuery("from Paciente p where p.nome like :nomePaciente ",Paciente.class).setParameter("nomePaciente", "%"+nome+"%").getResultList();
	}

}

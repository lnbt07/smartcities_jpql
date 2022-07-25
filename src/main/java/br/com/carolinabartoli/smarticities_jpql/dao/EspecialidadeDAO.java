package br.com.carolinabartoli.smarticities_jpql.dao;

import javax.persistence.EntityManager;

import br.com.carolinabartoli.entity.Especialidade;

public class EspecialidadeDAO extends GenericDAO<Especialidade, Integer> {

	public EspecialidadeDAO(EntityManager em) {
		super(em);
	}
	
}

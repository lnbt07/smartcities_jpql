package br.com.carolinabartoli.smarticities_jpql.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.carolinabartoli.entity.Paciente;

public class GenericDAO <T,K> {
	protected EntityManager em;

	private Class<T> clazz;

	public GenericDAO(EntityManager em) {
		this.em = em;
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void cadastrar(T entidade) {
		em.persist(entidade);
	}

	public void atualizar(T entidade) {
		em.merge(entidade);
	}

	public T buscar(K chave) {
		return em.find(clazz, chave);
	}

	public void remover(K chave) throws Exception {
		T entidade = buscar(chave);
		if (entidade == null) {
			throw new Exception("Entidade n�o encontrada");
		}
		em.remove(entidade);
	}

	public List<T> listar() {
		return em.createQuery("from " + clazz.getName(),clazz).getResultList();
	}

	public void commit(EntityManager em) throws Exception {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new Exception("erro no commit");
		}
	}
}

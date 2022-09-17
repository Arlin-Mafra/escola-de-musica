package escola.musica.dao;

import java.util.List;

import javax.persistence.EntityManager;

import escola.musica.modelo.Curso;

public class CursoDAO {

	public void salvar(Curso curso) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(curso);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public List<Curso> listarCursos() {
		EntityManager entityManager = JPAUtil.getEntityManager();

		return entityManager.createQuery("from Curso").getResultList();
	}

}

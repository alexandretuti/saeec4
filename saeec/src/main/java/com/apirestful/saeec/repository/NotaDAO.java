package com.apirestful.saeec.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.apirestful.saeec.models.Nota;

@Repository
public class NotaDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Nota> listarNotas(){
		
		Query query = manager.createNativeQuery("select n.id_nota, \n"
				+ "       concat (n.id_aluno, \"-\", a.nome ) as id_aluno,\n"
				+ "       concat (d.id_disciplina, \"-\", d.nome_disciplina) as id_disciplina,\n"
				+ "       n.nota from nota n\n"
				+ "inner join aluno a on a.id_aluno = n.id_aluno  \n"
				+ "inner join disciplina d on a.id_aluno = d.id_aluno" , Nota.class);
		
		return query.getResultList();
		
	}
	
}

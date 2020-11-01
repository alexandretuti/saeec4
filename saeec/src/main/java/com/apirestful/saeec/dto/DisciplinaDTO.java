package com.apirestful.saeec.dto;

import java.util.List;

import com.apirestful.saeec.models.Aluno;
import com.apirestful.saeec.models.Nota;

public class DisciplinaDTO {

	
	private Long idDisciplina;
	
	
	private String nomeDisciplina;
	
	private Aluno aluno;

	private List<Nota> nota;

	public Long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Nota> getNota() {
		return nota;
	}

	public void setNota(List<Nota> nota) {
		this.nota = nota;
	}
	
	
	
}

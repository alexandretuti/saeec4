package com.apirestful.saeec.dto;

import com.apirestful.saeec.models.Disciplina;

public class NotaDTO {
	
	private Long idNota; 
	
	private Long idAluno;
		
	private Long nota;
	
	private Long idDisciplina;
	
	public Long getIdNota() {
		return idNota;
	}

	public void setIdNota(Long idNota) {
		this.idNota = idNota;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public Long getNota() {
		return nota;
	}

	public void setNota(Long nota) {
		this.nota = nota;
	}

	public Long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	
	

}

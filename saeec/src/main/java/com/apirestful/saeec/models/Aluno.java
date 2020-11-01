package com.apirestful.saeec.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Aluno implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAluno; 
	
	@JsonInclude(Include.NON_NULL)
	private Long ra;
	
	@JsonInclude(Include.NON_NULL)
	private String nome;
		
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonInclude(Include.NON_NULL)
	private Date dataNascimento;
	
	
	@OneToMany(mappedBy = "aluno")
	private List<Disciplina> disciplina;
		

	public Aluno() {
		super();
	}


	public Long getIdAluno() {
		return idAluno;
	}


	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}


	public Long getRa() {
		return ra;
	}


	public void setRa(Long ra) {
		this.ra = ra;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public List<Disciplina> getDisciplina() {
		return disciplina;
	}


	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}


	
}

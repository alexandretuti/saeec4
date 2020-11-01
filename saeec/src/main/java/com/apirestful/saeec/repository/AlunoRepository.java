package com.apirestful.saeec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirestful.saeec.models.Aluno;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}

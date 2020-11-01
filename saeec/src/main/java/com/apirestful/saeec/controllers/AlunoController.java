package com.apirestful.saeec.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestful.saeec.dto.AlunoDTO;
import com.apirestful.saeec.models.Aluno;
import com.apirestful.saeec.services.AlunoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService; 
	


	@GetMapping("/alunos")
	@ApiOperation("Retorna todos os alunos")
	public ResponseEntity<List<AlunoDTO>> getAllAlunos() {

		List<AlunoDTO> lstAlunos = alunoService.findAll();
		if(lstAlunos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<AlunoDTO>>(lstAlunos, HttpStatus.OK);
		}
		
	}
	
	
	@GetMapping("/alunos/{id}")
	@ApiOperation(value="Retorna aluno especifico")
	public ResponseEntity<AlunoDTO> getOneAlunos(@PathVariable(value = "id") long id) {
		AlunoDTO alunoDto = alunoService.findById(id);
		if (alunoDto != null) {
			return new ResponseEntity<AlunoDTO>(alunoDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/alunos")
	@ApiOperation(value="Salvar aluno")
	public ResponseEntity<AlunoDTO> saveAlunos(@RequestBody @Valid AlunoDTO alunoDTO) {
		Aluno retModel = alunoService.save(alunoDTO);
		alunoDTO.setIdAluno(retModel.getIdAluno());
		return new ResponseEntity<AlunoDTO>(alunoDTO, HttpStatus.CREATED);
	}

	@PutMapping("/alunos")
	@ApiOperation(value="Atualizar aluno")
	public ResponseEntity<AlunoDTO> atualizarAluno(@RequestBody @Valid AlunoDTO alunoDTO) {
		Aluno retModel = alunoService.update(alunoDTO);
		alunoDTO.setIdAluno(retModel.getIdAluno());
		return new ResponseEntity<AlunoDTO>(alunoDTO, HttpStatus.OK);
	}

	@DeleteMapping("/alunos/{id}")
	@ApiOperation(value="Apagar aluno")
	public ResponseEntity<AlunoDTO> apagarAluno(@PathVariable(value = "id") long id) throws Exception {
		AlunoDTO alunoDto = alunoService.delete(id);
		if (alunoDto != null) {
			return new ResponseEntity<AlunoDTO>(alunoDto, HttpStatus.OK);
		} else {
			throw new Exception("Nenhum aluno Encontrado");
		}
	}
	
	
	
	
}

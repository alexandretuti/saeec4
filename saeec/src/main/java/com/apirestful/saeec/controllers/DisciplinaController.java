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

import com.apirestful.saeec.dto.DisciplinaDTO;
import com.apirestful.saeec.models.Disciplina;
import com.apirestful.saeec.services.DisciplinaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService disciplinaService; 
	
	@GetMapping("/disciplinas")
	@ApiOperation(value="Retorna todas as disciplinas")
	public ResponseEntity<List<DisciplinaDTO>> getAllDisciplinas() {
		List<DisciplinaDTO> lstDisciplina = disciplinaService.findAll();
		if (lstDisciplina.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<DisciplinaDTO>>(lstDisciplina, HttpStatus.OK);
		}
	}
	
	@PostMapping("/disciplinas")
	@ApiOperation(value="Salvar disciplina")
	public ResponseEntity<DisciplinaDTO> savedisciplinas(@RequestBody @Valid DisciplinaDTO DisciplinaDTO) {
		Disciplina retModel = disciplinaService.save(DisciplinaDTO);
		DisciplinaDTO.setIdDisciplina(retModel.getIdDisciplina());
		return new ResponseEntity<DisciplinaDTO>(DisciplinaDTO, HttpStatus.CREATED);
	}

	@PutMapping("/disciplinas")
	@ApiOperation(value="Atualizar disciplina")
	public ResponseEntity<DisciplinaDTO> atualizarDisciplina(@RequestBody @Valid DisciplinaDTO DisciplinaDTO) {
		Disciplina retModel = disciplinaService.update(DisciplinaDTO);
		DisciplinaDTO.setIdDisciplina(retModel.getIdDisciplina());
		return new ResponseEntity<DisciplinaDTO>(DisciplinaDTO, HttpStatus.OK);
	}

	@DeleteMapping("/disciplinas/{id}")
	@ApiOperation(value="Apagar disciplina")
	public ResponseEntity<DisciplinaDTO> apagarDisciplina(@PathVariable(value = "id") long id) throws Exception {
		DisciplinaDTO DisciplinaDTO = disciplinaService.delete(id);
		if (DisciplinaDTO != null) {
			return new ResponseEntity<DisciplinaDTO>(DisciplinaDTO, HttpStatus.OK);
		} else {
			throw new Exception("Nenhuma disciplina encontrada");
		}
	}

}

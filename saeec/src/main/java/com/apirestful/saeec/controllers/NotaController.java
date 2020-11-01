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
import org.springframework.web.bind.annotation.RestController;

import com.apirestful.saeec.dto.NotaDTO;
import com.apirestful.saeec.models.Nota;
import com.apirestful.saeec.services.NotaService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping(value = "/api")

public class NotaController {	
	
	@Autowired
	private NotaService notaService; 

	@GetMapping("/notas")
	@ApiOperation(value="Retorna todas as notas")
	public ResponseEntity<List<NotaDTO>> getAllNotas() {

		List<NotaDTO> lstNotas = notaService.findAll();
		if(lstNotas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<NotaDTO>>(lstNotas, HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/listaNotas")
	@ApiOperation(value="Retorna todas as notas")
	public ResponseEntity<List<Nota>> listarAllNotas() {

		List<Nota> lstNotas = notaService.listarNotas();
		if(lstNotas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Nota>>(lstNotas, HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/notas/{id}")
	@ApiOperation(value="Retorna nota especifica")
	public ResponseEntity<NotaDTO> getOneNota(@PathVariable(value = "id") long id) {
		NotaDTO notaDTO = notaService.findById(id);
		if (notaDTO != null) {
			return new ResponseEntity<NotaDTO>(notaDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/notas")
	@ApiOperation(value="Salvar nota")
	public ResponseEntity<NotaDTO> saveNota(@RequestBody @Valid NotaDTO notaDTO) {
		Nota retModel = notaService.save(notaDTO);
		notaDTO.setIdNota(retModel.getIdNota());
		return new ResponseEntity<NotaDTO>(notaDTO, HttpStatus.CREATED);
	}

	@PutMapping("/notas")
	@ApiOperation(value="Atualizar nota")
	public ResponseEntity<NotaDTO> atualizarNota(@RequestBody @Valid NotaDTO notaDTO) {
		Nota retModel = notaService.update(notaDTO);
		notaDTO.setIdNota(retModel.getIdNota());
		return new ResponseEntity<NotaDTO>(notaDTO, HttpStatus.OK);
	}

	@DeleteMapping("/notas/{id}")
	@ApiOperation(value="Apagar nota")
	public ResponseEntity<NotaDTO> apagarNota(@PathVariable(value = "id") long id) throws Exception {
		NotaDTO notaDTO = notaService.delete(id);
		if (notaDTO != null) {
			return new ResponseEntity<NotaDTO>(notaDTO, HttpStatus.OK);
		} else {
			throw new Exception("Nenhuma nota encontrada");
		}
	}
	
	
	
	
}

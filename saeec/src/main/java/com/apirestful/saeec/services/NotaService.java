package com.apirestful.saeec.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestful.saeec.dto.NotaDTO;
import com.apirestful.saeec.models.Nota;
import com.apirestful.saeec.repository.NotaDAO;
import com.apirestful.saeec.repository.NotaRepository;
 
@Service
public class NotaService {
	
	
	@Autowired
	private NotaRepository NotaRepository; 
	
	@Autowired
	private NotaDAO notaDao; 
	
	
	public List<NotaDTO> findAll(){
		
		List<Nota> lstNotas = NotaRepository.findAll();
		List<NotaDTO> notaDTO = new ArrayList<NotaDTO>();
		ModelMapper mapper = new ModelMapper();
		for (Nota nota : lstNotas) {
			notaDTO.add(mapper.map(nota, NotaDTO.class));
		}
		return notaDTO;
	}
	
	
	public List<Nota> listarNotas(){
		
		List<Nota> lstNotas = notaDao.listarNotas();
		return lstNotas; 
	}

	
	public NotaDTO findById(long id) {
		ModelMapper mapper = new ModelMapper();
		Optional<Nota> NotaModel = NotaRepository.findById(id);
		NotaDTO dto = null;
		if (NotaModel.isPresent()) {
			return dto = mapper.map(NotaModel.get(), NotaDTO.class);
		} else {
			return dto;
		}

	}

	public Nota save(NotaDTO notaDTO) {
		ModelMapper mapper = new ModelMapper();
		Nota nota = mapper.map(notaDTO, Nota.class);
		return NotaRepository.save(nota);
	}

	public Nota update(NotaDTO notaDTO) {
		ModelMapper mapper = new ModelMapper();
		Nota nota = mapper.map(notaDTO, Nota.class);
		return  NotaRepository.saveAndFlush(nota); 
	}

	public NotaDTO delete(long id) {
		Optional<Nota> NotaModel = NotaRepository.findById(id);
		NotaDTO nota = null;
		if (NotaModel.isPresent()) {
			NotaRepository.delete(NotaModel.get());
			ModelMapper mapper = new ModelMapper();
			nota = mapper.map(NotaModel.get(), NotaDTO.class);
		}
		return nota;

	}


}

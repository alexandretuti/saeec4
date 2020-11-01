package com.apirestful.saeec.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestful.saeec.dto.DisciplinaDTO;
import com.apirestful.saeec.models.Disciplina;
import com.apirestful.saeec.repository.DisciplinaRepository;
 
@Service
public class DisciplinaService {
	
	
	@Autowired
	private DisciplinaRepository disciplinaRepository; 
	
	
	public List<DisciplinaDTO> findAll(){
		
		List<Disciplina> lstDisciplinas = disciplinaRepository.findAll();
		List<DisciplinaDTO> disciplinaDTO = new ArrayList<DisciplinaDTO>();
		ModelMapper mapper = new ModelMapper();
		for (Disciplina disciplina : lstDisciplinas) {
			disciplinaDTO.add(mapper.map(disciplina, DisciplinaDTO.class));
		}
		return disciplinaDTO;
	}
	
	public DisciplinaDTO findById(long id) {
		ModelMapper mapper = new ModelMapper();
		Optional<Disciplina> DisciplinaModel = disciplinaRepository.findById(id);
		DisciplinaDTO dto = null;
		if (DisciplinaModel.isPresent()) {
			return dto = mapper.map(DisciplinaModel.get(), DisciplinaDTO.class);
		} else {
			return dto;
		}

	}

	public Disciplina save(DisciplinaDTO DisciplinaDTO) {
		ModelMapper mapper = new ModelMapper();
		Disciplina disciplina = mapper.map(DisciplinaDTO, Disciplina.class);
		return disciplinaRepository.save(disciplina);
	}

	public Disciplina update(DisciplinaDTO DisciplinaDTO) {
		ModelMapper mapper = new ModelMapper();
		Disciplina disciplina = mapper.map(DisciplinaDTO, Disciplina.class);
		return  disciplinaRepository.saveAndFlush(disciplina); 
	}

	public DisciplinaDTO delete(long id) {
		Optional<Disciplina> DisciplinaModel = disciplinaRepository.findById(id);
		DisciplinaDTO disciplina = null;
		if (DisciplinaModel.isPresent()) {
			disciplinaRepository.delete(DisciplinaModel.get());
			ModelMapper mapper = new ModelMapper();
			disciplina = mapper.map(DisciplinaModel.get(), DisciplinaDTO.class);
		}
		return disciplina;

	}
	

}

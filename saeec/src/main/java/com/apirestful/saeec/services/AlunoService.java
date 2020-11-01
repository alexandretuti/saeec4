package com.apirestful.saeec.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestful.saeec.dto.AlunoDTO;
import com.apirestful.saeec.models.Aluno;
import com.apirestful.saeec.repository.AlunoRepository;
 
@Service
public class AlunoService {
	
	
	@Autowired
	private AlunoRepository alunoRepository; 
	
	public List<AlunoDTO> findAll(){
		
		List<Aluno> lstAlunos = alunoRepository.findAll();
		List<AlunoDTO> alunoDTO = new ArrayList<AlunoDTO>();
		ModelMapper mapper = new ModelMapper();
		for (Aluno aluno : lstAlunos) {
			alunoDTO.add(mapper.map(aluno, AlunoDTO.class));
		}
		return alunoDTO;
	}
	
	
	public AlunoDTO findById(long id) {
		ModelMapper mapper = new ModelMapper();
		Optional<Aluno> alunoModel = alunoRepository.findById(id);
		AlunoDTO dto = null;
		if (alunoModel.isPresent()) {
			return dto = mapper.map(alunoModel.get(), AlunoDTO.class);
		} else {
			return dto;
		}

	}

	public Aluno save(AlunoDTO alunoDto) {
		ModelMapper mapper = new ModelMapper();
		Aluno aluno = mapper.map(alunoDto, Aluno.class);
		return alunoRepository.save(aluno);
	}

	public Aluno update(AlunoDTO alunoDto) {
		ModelMapper mapper = new ModelMapper();
		Aluno aluno = mapper.map(alunoDto, Aluno.class);
		return  alunoRepository.saveAndFlush(aluno); 
	}

	public AlunoDTO delete(long id) {
		Optional<Aluno> alunoModel = alunoRepository.findById(id);
		AlunoDTO aluno = null;
		if (alunoModel.isPresent()) {
			alunoRepository.delete(alunoModel.get());
			ModelMapper mapper = new ModelMapper();
			aluno = mapper.map(alunoModel.get(), AlunoDTO.class);
		}
		return aluno;

	}


}

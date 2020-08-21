package com.culysoft.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import com.culysoft.exception.SoldadoNotFoundException;
import com.culysoft.model.Soldado;
import com.culysoft.repository.SoldadoRepository;

@Service
public class SoldadoService {
	
	@Autowired
	private SoldadoRepository soldadoRepository;
	
	public List<Soldado> getAll() {
		List<Soldado> soldados = new ArrayList<>();
		
		for(Soldado soldado : soldadoRepository.findAll()) {
			soldado.add(Link.of("http://localhost:8080/soldados/soldado/" + soldado.getId()));
			soldados.add(soldado);
		}
		
		return soldados;
	}
	
	public Soldado getById(Long id) throws SoldadoNotFoundException {
		Soldado soldado = soldadoRepository.findById(id).orElseThrow(()-> new SoldadoNotFoundException("Soldado not found"));
		soldado.add(Link.of("http://localhost:8080/soldados"));
		return soldado;
	}

}

package com.culysoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.culysoft.exception.SoldadoNotFoundException;
import com.culysoft.model.Soldado;
import com.culysoft.service.SoldadoService;

@RestController
@RequestMapping("/soldados")
public class SoldadoController {
	
	@Autowired
	private SoldadoService soldadoService;
	
	@GetMapping
	public List<Soldado> getAll() {
		return soldadoService.getAll();
	}
	
	@GetMapping("/soldado/{id}")
	public Soldado getById(@PathVariable Long id) throws SoldadoNotFoundException{
		return soldadoService.getById(id);
	}

}

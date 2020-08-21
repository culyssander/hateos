package com.culysoft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.culysoft.model.Soldado;

@Repository
public interface SoldadoRepository extends CrudRepository<Soldado, Long>{

	List<Soldado> findAll();
}

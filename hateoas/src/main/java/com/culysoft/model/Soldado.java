package com.culysoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Soldado extends RepresentationModel<Soldado> {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String raca;
	private String arma;
	private String status;
}

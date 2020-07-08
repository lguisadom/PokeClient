package com.lagm.dto;

import java.util.List;

import lombok.Data;

@Data
public class Chain {
	private List<EvolutionDetail> evolution_details;
	private List<Chain> evolves_to;
	private Boolean is_baby;
	private Specie species;
}

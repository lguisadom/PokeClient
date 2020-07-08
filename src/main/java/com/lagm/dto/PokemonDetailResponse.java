package com.lagm.dto;

import java.util.List;

import lombok.Data;

@Data
public class PokemonDetailResponse {
	private int base_happiness;
	private int capture_rate;
	private Color color;
	private List<EggGroup> egg_groups;
	private EvolutionChain evolution_chain;
}

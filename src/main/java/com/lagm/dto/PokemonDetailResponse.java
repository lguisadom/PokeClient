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
	private Pokemon evolves_from_species;
	private List<FlavorTextEntrie> flavor_text_entries;
	private int gender_rate;
	private List<Genera> genera;
	private Generation generation;
	private GrowthRate growth_rate;
	private Boolean has_gender_differences;
	private int hatch_counter;
	private int id;
	private Boolean is_baby;
	private String name;
	private List<NamePokemon> names;
	private int order;
	private List<PokedexNumber> pokedex_numbers;
	private Shape shape;
	private List<Varietie> varieties;
}

package com.lagm.dto;

import java.util.List;

import lombok.Data;

@Data
public class PokemonListResponse {
	private int count;
	private String next;
	private String previous;
	private List<Pokemon> results;
}

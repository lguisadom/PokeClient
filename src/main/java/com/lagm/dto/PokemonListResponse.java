package com.lagm.dto;

import java.util.List;

import lombok.Data;

@Data
public class PokemonListResponse {
	private int count;
	private String next;
	private String previus;
	private List<Pokemon> results;
}

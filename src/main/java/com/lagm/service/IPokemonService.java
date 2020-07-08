package com.lagm.service;

import com.lagm.dto.PokemonListResponse;

public interface IPokemonService {
	public abstract PokemonListResponse listaPokemones(String url);
}

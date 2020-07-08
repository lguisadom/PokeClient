package com.lagm.client;

import com.lagm.dto.PokemonListResponse;

public interface IPokemonProxy {
	public abstract PokemonListResponse listaPokemones(String url);
}

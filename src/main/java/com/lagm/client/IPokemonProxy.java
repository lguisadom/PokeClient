package com.lagm.client;

import com.lagm.dto.PokemonDetailResponse;
import com.lagm.dto.PokemonListResponse;

public interface IPokemonProxy {
	public abstract PokemonListResponse listaPokemones(String url, String offset, String limit);
	public abstract PokemonDetailResponse detallePokemon(String url);
}

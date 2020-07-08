package com.lagm.service;

import java.util.List;

import com.lagm.dto.EvolutionChainDetail;
import com.lagm.dto.PokemonDetailResponse;
import com.lagm.dto.PokemonListResponse;

public interface IPokemonService {
	public abstract PokemonListResponse listaPokemones(String url, String offset, String limit);
	public abstract PokemonDetailResponse detallePokemon(String url);
	public abstract List<EvolutionChainDetail> cadenaEvolucion(String url);
}

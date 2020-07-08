package com.lagm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lagm.client.IPokemonProxy;
import com.lagm.dto.PokemonDetailResponse;
import com.lagm.dto.PokemonListResponse;

@Service
public class PokemonService implements IPokemonService {

	@Autowired
	IPokemonProxy pokemonProxy;
	
	@Override
	public PokemonListResponse listaPokemones(String url) {
		return pokemonProxy.listaPokemones(url);
	}

	@Override
	public PokemonDetailResponse detallePokemon(String url) {
		return pokemonProxy.detallePokemon(url);
	}

}

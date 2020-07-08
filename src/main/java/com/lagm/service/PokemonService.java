package com.lagm.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lagm.client.IPokemonProxy;
import com.lagm.client.PokemonProxy;
import com.lagm.dto.PokemonDetailResponse;
import com.lagm.dto.PokemonListResponse;
import com.lagm.util.Util;

@Service
public class PokemonService implements IPokemonService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PokemonProxy.class);
	
	@Autowired
	IPokemonProxy pokemonProxy;
	
	@Override
	public PokemonListResponse listaPokemones(String url, String offset, String limit) {
		PokemonListResponse response = null;
		
		response = pokemonProxy.listaPokemones(url, offset, limit);
		String preview = response.getPrevious();
		String next = response.getNext();
		
		// Se obtienen los parámetros previous y next
		Map<String, String> previewParameters = Util.getParameters(preview);
		Map<String, String> nextParameters = Util.getParameters(next);
		
		if (previewParameters != null) {
			 if (previewParameters.get("offset") != null) {
				 response.setPreviousOffset(previewParameters.get("offset"));
			 }
			 
			 if (previewParameters.get("limit") != null) {
				 response.setPreviousLimit(previewParameters.get("limit"));
			 }
		}
		
		if (nextParameters != null) {
			 if (nextParameters.get("offset") != null) {
				 response.setNextOffset(nextParameters.get("offset"));
			 }
			 
			 if (nextParameters.get("limit") != null) {
				 response.setNextLimit(nextParameters.get("limit"));
			 }
		}
		
		LOGGER.info("response: {}", response);
		return response;
	}

	@Override
	public PokemonDetailResponse detallePokemon(String url) {
		return pokemonProxy.detallePokemon(url);
	}

}

package com.lagm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lagm.client.IPokemonProxy;
import com.lagm.client.PokemonProxy;
import com.lagm.dto.Chain;
import com.lagm.dto.EvolutionChainDetail;
import com.lagm.dto.EvolutionChainResponse;
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

	@Override
	public List<EvolutionChainDetail> cadenaEvolucion(String url) {
		EvolutionChainResponse response = null;
		response = pokemonProxy.cadenaEvolucion(url);
		
		Chain chain = response.getChain();
		List<EvolutionChainDetail> listEvolutionChainDetail = new ArrayList<EvolutionChainDetail>();
		EvolutionChainDetail chainDetail = new EvolutionChainDetail();
		String speciesUrl = chain.getSpecies().getUrl();
		PokemonDetailResponse detailSpecies = this.detallePokemon(speciesUrl);
		
		chainDetail.setSpeciesName(chain.getSpecies().getName());
		chainDetail.setSpeciesUrl(speciesUrl);
		chainDetail.setSpeciesId(detailSpecies.getId());
		chainDetail.setMinLevel(1);
		listEvolutionChainDetail.add(chainDetail);
		
		while (chain.getEvolves_to().size() > 0) {
			chain = chain.getEvolves_to().get(0);
			speciesUrl = chain.getSpecies().getUrl();
			detailSpecies = this.detallePokemon(speciesUrl);
			
			chainDetail = new EvolutionChainDetail();
			chainDetail.setSpeciesName(chain.getSpecies().getName());
			chainDetail.setSpeciesUrl(speciesUrl);
			chainDetail.setSpeciesId(detailSpecies.getId());
			chainDetail.setMinLevel(chain.getEvolution_details().get(0).getMin_level());
			
			listEvolutionChainDetail.add(chainDetail);
		}
		
		LOGGER.info("listEvolutionChainDetail: {}", listEvolutionChainDetail);
		return listEvolutionChainDetail;
	}

}

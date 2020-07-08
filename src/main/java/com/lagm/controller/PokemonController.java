package com.lagm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lagm.dto.PokemonDetailResponse;
import com.lagm.dto.PokemonListResponse;
import com.lagm.service.IPokemonService;

@Controller
public class PokemonController {
	@Autowired
	IPokemonService pokemonService;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/listaPokemones")
	public String listaPokemones(@RequestParam(name="url", required=true) String url, 
			@RequestParam(name="offset", required=false) String offset,
			@RequestParam(name="limit", required=false) String limit,
			Model model) {
		PokemonListResponse response = pokemonService.listaPokemones(url, offset, limit);
		model.addAttribute("listaPokemones", response);
		model.addAttribute("recurso", url);
		return "pokemones";
	}
	
	@GetMapping("/detallePokemon")
	public String detallePokemon(@RequestParam(name="url", required=true) String url, Model model) {
		PokemonDetailResponse response = pokemonService.detallePokemon(url);
		model.addAttribute("detallePokemon", response);

		return "detalle-pokemon";
	}
}

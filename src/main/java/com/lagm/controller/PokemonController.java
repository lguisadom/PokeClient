package com.lagm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lagm.dto.PokemonListResponse;
import com.lagm.service.IPokemonService;

@Controller
public class PokemonController {
	@Autowired
	IPokemonService pokemonService;
	
	@GetMapping("/listaPokemones")
	public String listaPokemones(@RequestParam(name="url", required=true) String url, Model model) {
		PokemonListResponse response = pokemonService.listaPokemones(url);
		model.addAttribute("listaPokemones", response);

		return "index";
	}
}
package com.lagm.dto;

import lombok.Data;

@Data
public class EvolutionDetail {
	private int min_level;
	private Boolean needs_overworld_rain;
	private Trigger trigger;
	private Boolean turn_upside_down;
}

package io.tintin.ia.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class QueryToAlbert {
	private final String goal;
	private final String question;
	private final String contexte;
	private final String precision;
	private final String role;
}

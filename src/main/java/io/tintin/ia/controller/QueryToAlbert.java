package io.tintin.ia.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@Builder
public class QueryToAlbert {
	private final String question;

	    // Constructeur avec annotation Jackson
    @JsonCreator
    public QueryToAlbert(@JsonProperty("question") String question) {
        this.question = question;
    }
}

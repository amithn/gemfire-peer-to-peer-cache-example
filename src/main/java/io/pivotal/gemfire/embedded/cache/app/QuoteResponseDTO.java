package io.pivotal.gemfire.embedded.cache.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class QuoteResponseDTO {
	private Quote quote;
	private boolean isCacheHit;

	public QuoteResponseDTO(Quote quote, boolean isCacheHit) {
		this.quote = quote;
		this.isCacheHit = isCacheHit;
	}

	public Quote getQuote() {
		return quote;
	}

	public boolean isCacheHit() {
		return isCacheHit;
	}
}

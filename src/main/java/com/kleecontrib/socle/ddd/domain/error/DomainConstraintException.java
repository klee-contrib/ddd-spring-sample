package com.kleecontrib.socle.ddd.domain.error;

import java.util.HashMap;
import java.util.Map;

public class DomainConstraintException extends RuntimeException {

	private static final long serialVersionUID = -2928358379837700440L;
	/**
	 * Liste de parametre inclu dans le message
	 */
	private final Map<String, String> parameters = new HashMap<>();
	private final String code;

	public DomainConstraintException(String code, String message) {
		super(message);
		this.code = code;
	}

	public DomainConstraintException(String code, String message, Map<String, String> parameters) {
		super(message);
		this.parameters.putAll(parameters);
		this.code = code;
	}

	public DomainConstraintException(String code, String message, Throwable t) {
		super(message, t);
		this.code = code;
	}

	public DomainConstraintException(String code, String message, Throwable t, Map<String, String> parameters) {
		super(message, t);
		this.parameters.putAll(parameters);
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}
}

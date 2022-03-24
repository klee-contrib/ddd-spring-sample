package com.kleecontrib.socle.ddd.domain.common;

import java.util.UUID;

public class CommandeId {
	private final String value;

	public static CommandeId generate() {
		return new CommandeId(UUID.randomUUID().toString());
	}

	public static CommandeId hydrate(String value) {
		return new CommandeId(value);
	}

	private CommandeId(String value) {
		super();
		this.value = value;
	}

	public String value() {
		return value;
	}

}

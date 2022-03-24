package com.kleecontrib.socle.ddd.domain.common;

import java.util.UUID;

public class PromotionId {
	private final String value;

	public static PromotionId generate() {
		return new PromotionId(UUID.randomUUID().toString());
	}

	public static PromotionId hydrate(String value) {
		return new PromotionId(value);
	}

	private PromotionId(String value) {
		super();
		this.value = value;
	}

	public String value() {
		return value;
	}

}

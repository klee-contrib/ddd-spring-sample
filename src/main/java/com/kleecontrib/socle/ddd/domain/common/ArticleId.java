package com.kleecontrib.socle.ddd.domain.common;

public class ArticleId {
	private final long value;

	public static ArticleId hydrate(long value) {
		return new ArticleId(value);
	}

	private ArticleId(long value) {
		super();
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ArticleId other = (ArticleId) obj;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (value ^ (value >>> 32));
		return result;
	}

	public long value() {
		return value;
	}

}

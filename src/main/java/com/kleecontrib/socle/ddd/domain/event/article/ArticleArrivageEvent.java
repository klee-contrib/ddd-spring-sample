package com.kleecontrib.socle.ddd.domain.event.article;

import java.time.LocalDateTime;

import com.kleecontrib.socle.ddd.domain.article.event.ArticleEvent;
import com.kleecontrib.socle.ddd.domain.common.ArticleId;

public class ArticleArrivageEvent implements ArticleEvent {

	private final ArticleId id;
	private final LocalDateTime dateArrivage;
	private final long nombreRecu;

	public ArticleArrivageEvent(ArticleId id, LocalDateTime dateArrivage, long nombreRecu) {
		super();
		this.id = id;
		this.dateArrivage = dateArrivage;
		this.nombreRecu = nombreRecu;
	}

	public LocalDateTime getDateArrivage() {
		return dateArrivage;
	}

	public ArticleId getId() {
		return id;
	}

	public long getNombreRecu() {
		return nombreRecu;
	}

}

package com.kleecontrib.socle.ddd.port.db.article.adapters;

import java.math.BigDecimal;

import com.kleecontrib.socle.ddd.domain.article.Article;
import com.kleecontrib.socle.ddd.port.db.article.entity.ArticleEntity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArticleEntityAdapter {

	public static ArticleEntity fromDomainToEntity(Article domain) {
		return new ArticleEntity(domain.getId().value(), domain.getNom(), domain.getPrix().doubleValue());

	}

	public static Article fromEntityToDomain(ArticleEntity entity) {
		return Article.hydrate(entity.getArtId(), entity.getNom(), BigDecimal.valueOf(entity.getPrix()), 0, false);

	}

}

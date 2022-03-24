package com.kleecontrib.socle.ddd.application.article;

import org.springframework.beans.factory.annotation.Autowired;

import com.kleecontrib.socle.ddd.domain.article.Article;
import com.kleecontrib.socle.ddd.domain.article.repository.ArticleDomainRepository;
import com.kleecontrib.socle.ddd.domain.common.ArticleId;

public class RecupererArticle {

	@Autowired
	private ArticleDomainRepository articleStore;

	public Article execute(ArticleId id) {

		/// Ici on peut mettre un check de sécurité

		final Article article = articleStore.get(id);

		return article;
	}
}

package com.kleecontrib.socle.ddd.application.article;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kleecontrib.socle.ddd.domain.article.Article;
import com.kleecontrib.socle.ddd.domain.article.event.ArticleEventPublisher;
import com.kleecontrib.socle.ddd.domain.article.repository.ArticleDomainRepository;
import com.kleecontrib.socle.ddd.domain.common.ArticleId;
import com.kleecontrib.socle.ddd.domain.event.article.ArticleArrivageEvent;

@Component
public class ReceptionDArrivage {

	@Autowired
	private ArticleDomainRepository articleStore;
	@Autowired
	private ArticleEventPublisher articleEventPublisher;

	public void execute(ArticleId id, long nombre) {

		final Article article = articleStore.get(id);

		article.arrivage(nombre)//
				.ajouterAuCatalogue();

		articleStore.save(article);

		articleEventPublisher.publish(new ArticleArrivageEvent(article.getId(), LocalDateTime.now(), nombre));
	}

}

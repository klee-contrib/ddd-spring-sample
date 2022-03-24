package com.kleecontrib.socle.ddd.store.article.event;

import org.springframework.stereotype.Component;

import com.kleecontrib.socle.ddd.domain.article.event.ArticleEvent;
import com.kleecontrib.socle.ddd.domain.article.event.ArticleEventPublisher;

@Component
public class ArticleEventPublisherImpl implements ArticleEventPublisher {

	@Override
	public void publish(ArticleEvent event) {
		// TODO Auto-generated method stub

	}

}

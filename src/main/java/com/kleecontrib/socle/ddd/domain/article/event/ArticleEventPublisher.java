package com.kleecontrib.socle.ddd.domain.article.event;

public interface ArticleEventPublisher {

	void publish(ArticleEvent event);

}

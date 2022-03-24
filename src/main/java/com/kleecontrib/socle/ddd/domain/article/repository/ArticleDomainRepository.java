package com.kleecontrib.socle.ddd.domain.article.repository;

import java.util.List;

import com.kleecontrib.socle.ddd.domain.article.Article;
import com.kleecontrib.socle.ddd.domain.common.ArticleId;

public interface ArticleDomainRepository {

	public Article get(ArticleId id);

	public ArticleId save(Article article);

	public List<Article> search(Article criteria);

}

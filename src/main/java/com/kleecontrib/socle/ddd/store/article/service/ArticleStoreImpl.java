package com.kleecontrib.socle.ddd.store.article.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.kleecontrib.socle.ddd.domain.article.Article;
import com.kleecontrib.socle.ddd.domain.article.repository.ArticleDomainRepository;
import com.kleecontrib.socle.ddd.domain.common.ArticleId;
import com.kleecontrib.socle.ddd.port.db.article.adapters.ArticleEntityAdapter;
import com.kleecontrib.socle.ddd.port.db.article.entity.ArticleEntity;
import com.kleecontrib.socle.ddd.port.db.article.repository.ArticleEntityRepository;

@Component
public class ArticleStoreImpl implements ArticleDomainRepository {

	@Autowired
	private ArticleEntityRepository articleRepository;

	@Override
	public Article get(ArticleId id) {
		final ArticleEntity entity = articleRepository.getOne(id.value());
		return ArticleEntityAdapter.fromEntityToDomain(entity);
	}

	@Override
	@Transactional
	public ArticleId save(Article article) {
		final ArticleEntity entity = ArticleEntityAdapter.fromDomainToEntity(article);
		articleRepository.save(entity);
		return ArticleId.hydrate(entity.getArtId());
	}

	@Override
	public List<Article> search(Article criteria) {
		final ArticleEntity criteriaEntity = ArticleEntityAdapter.fromDomainToEntity(criteria);
		final var result = articleRepository.findAll(Example.of(criteriaEntity));
		return result.stream().map(ArticleEntityAdapter::fromEntityToDomain).collect(Collectors.toList());
	}

}

package com.kleecontrib.socle.ddd.port.db.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kleecontrib.socle.ddd.port.db.article.entity.ArticleEntity;

public interface ArticleEntityRepository extends JpaRepository<ArticleEntity, Long>, ArticleEntityRepositoryCustom {

}

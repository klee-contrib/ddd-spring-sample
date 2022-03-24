package com.kleecontrib.socle.ddd.port.db.article.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleEntityRepositoryCustom {

	@Modifying
	@Query(value = "" + //
			"delete from article    " + //
			"where nom like :nom  ", //
			nativeQuery = true)
	void deleteArticleByNom(@Param("nom") String nom);

}

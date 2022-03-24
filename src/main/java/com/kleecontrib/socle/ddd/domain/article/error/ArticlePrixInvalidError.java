package com.kleecontrib.socle.ddd.domain.article.error;

import com.kleecontrib.socle.ddd.domain.error.DomainConstraintException;

public class ArticlePrixInvalidError extends DomainConstraintException {

	private static final long serialVersionUID = 1L;
	public static final String CODE = "err_article_prix_invalid";
	public static final String DESCRIPTION_CODE = "On ne vend rien gratuitement!.";

	public ArticlePrixInvalidError() {
		super(CODE, DESCRIPTION_CODE);
	}
}
package com.kleecontrib.socle.ddd.domain.article.error;

import com.kleecontrib.socle.ddd.domain.error.DomainConstraintException;

public class ArticleModificationStockError extends DomainConstraintException {
	private static final long serialVersionUID = 1L;
	public static final String CODE = "err_article_modification_stock";
	public static final String DESCRIPTION_CODE = "On ne manipule pas les stock n'importe comment";

	public ArticleModificationStockError() {
		super(CODE, DESCRIPTION_CODE);
	}
}

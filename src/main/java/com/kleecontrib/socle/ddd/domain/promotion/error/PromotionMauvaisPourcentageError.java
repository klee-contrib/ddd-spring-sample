package com.kleecontrib.socle.ddd.domain.promotion.error;

import com.kleecontrib.socle.ddd.domain.error.DomainConstraintException;

public class PromotionMauvaisPourcentageError extends DomainConstraintException {
	private static final long serialVersionUID = 1L;
	public static final String CODE = "err_promotion_mauvais_pourcentage";
	public static final String DESCRIPTION_CODE = "Le pourcentage de promotion doit être compris entre 0 et 100";

	public PromotionMauvaisPourcentageError() {
		super(CODE, DESCRIPTION_CODE);
	}
}

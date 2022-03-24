package com.kleecontrib.socle.ddd.domain.promotion.repository;

import java.util.List;

import com.kleecontrib.socle.ddd.domain.common.PromotionId;
import com.kleecontrib.socle.ddd.domain.promotion.Promotion;

public interface PromotionDomainRepository {

	public Promotion get(PromotionId id);

	public PromotionId save(Promotion article);

	public List<Promotion> search(Promotion criteria);

}

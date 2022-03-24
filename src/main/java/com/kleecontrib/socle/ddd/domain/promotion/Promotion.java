package com.kleecontrib.socle.ddd.domain.promotion;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.kleecontrib.socle.ddd.domain.article.Article;
import com.kleecontrib.socle.ddd.domain.common.ArticleId;
import com.kleecontrib.socle.ddd.domain.common.PromotionId;
import com.kleecontrib.socle.ddd.domain.promotion.error.PromotionArticleError;
import com.kleecontrib.socle.ddd.domain.promotion.error.PromotionInactiveError;
import com.kleecontrib.socle.ddd.domain.promotion.error.PromotionMauvaisPourcentageError;
import com.kleecontrib.socle.ddd.domain.promotion.error.PromotionPeriodeError;

public class Promotion {

	private final PromotionId promotionId;
	private final List<ArticleId> articles;
	private final Integer pourcentageReduction;
	private final String nom;
	private final LocalDateTime dateDebut;
	private final LocalDateTime dateFin;
	private boolean active;
	private BigDecimal prix;

	public static Promotion creer(List<ArticleId> articles, Integer pourcentageReduction, String nom,
			LocalDateTime dateDebut, LocalDateTime dateFin, boolean active, BigDecimal prix) {

		if (pourcentageReduction < 0 || pourcentageReduction > 100) {
			throw new PromotionMauvaisPourcentageError();
		}
		return new Promotion(PromotionId.generate(), articles, pourcentageReduction, nom, dateDebut, dateFin, active,
				prix);
	}

	public static Promotion hydrate(PromotionId id, List<ArticleId> articles, Integer pourcentageReduction, String nom,
			LocalDateTime dateDebut, LocalDateTime dateFin, boolean active, BigDecimal prix) {
		return new Promotion(id, articles, pourcentageReduction, nom, dateDebut, dateFin, active, prix);
	}

	private Promotion(PromotionId promotionId, List<ArticleId> articles, Integer pourcentageReduction, String nom,
			LocalDateTime dateDebut, LocalDateTime dateFin, boolean active, BigDecimal prix) {
		this.promotionId = promotionId;
		this.articles = articles;
		this.pourcentageReduction = pourcentageReduction;
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.active = active;
		this.prix = prix;
	}

	public Promotion activer() {
		this.active = true;
		return this;
	}

	public Promotion appliquer(Article article) {
		if (!this.active) {
			throw new PromotionInactiveError();
		}
		final var now = LocalDateTime.now();
		if (now.isBefore(dateDebut) || now.isAfter(dateFin)) {
			throw new PromotionPeriodeError();
		}
		if (!articles.contains(article.getId())) {
			throw new PromotionArticleError();
		}
		this.prix = article.getPrix().min(
				article.getPrix().multiply(BigDecimal.valueOf(pourcentageReduction)).divide(BigDecimal.valueOf(100)));
		return this;
	}

	public List<ArticleId> articles() {
		return articles;
	}

	public LocalDateTime dateDebut() {
		return dateDebut;
	}

	public LocalDateTime dateFin() {
		return dateFin;
	}

	public Promotion desactiver() {
		this.active = false;
		return this;
	}

	public PromotionId id() {
		return promotionId;
	}

	public boolean isActive() {
		return active;
	}

	public String nom() {
		return nom;
	}

	public Integer pourcentageReduction() {
		return pourcentageReduction;
	}

	public BigDecimal prix() {
		return prix;
	}

}

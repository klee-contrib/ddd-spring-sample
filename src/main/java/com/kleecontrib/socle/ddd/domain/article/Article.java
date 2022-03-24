package com.kleecontrib.socle.ddd.domain.article;

import java.math.BigDecimal;

import com.kleecontrib.socle.ddd.domain.article.error.ArticlePrixInvalidError;
import com.kleecontrib.socle.ddd.domain.common.ArticleId;

public class Article {

	private final ArticleId id;

	private final String nom;
	private final BigDecimal prix;
	private Stock stock;
	private boolean isAuCatalogue;

	public static Article creer(String nom, BigDecimal prix) {
		if (prix.doubleValue() <= 0) {
			throw new ArticlePrixInvalidError();
		}

		return new Article(null, nom, prix, Stock.vide(), false);
	}

	public static Article hydrate(long id, String nom, BigDecimal prix, long nbRestant, boolean isAuCatalogue) {
		return new Article(ArticleId.hydrate(id), nom, prix, Stock.hydrate(nbRestant), isAuCatalogue);
	}

	private Article(ArticleId id, String nom, BigDecimal prix, Stock stock, boolean isAuCatalogue) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
		this.isAuCatalogue = isAuCatalogue;
	}

	public Article ajouterAuCatalogue() {
		if (!this.stock.isEmpty()) {
			this.isAuCatalogue = true;
		}
		return this;
	}

	public Article arrivage(long nombre) {
		stock = stock.ajouter(nombre);
		return this;
	}

	public ArticleId getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public BigDecimal getPrix() {

		return prix;
	}

	public boolean isAuCatalogue() {
		return isAuCatalogue;
	}

}

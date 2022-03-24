package com.kleecontrib.socle.ddd.domain.article;

import com.kleecontrib.socle.ddd.domain.article.error.ArticleCapaciteMaximaleAtteinteError;
import com.kleecontrib.socle.ddd.domain.article.error.ArticleModificationStockError;

public class Stock {

	private static final long CAPACITE_MAX = 10;

	private final long nombreRestant;

	public static Stock hydrate(long nbRestant) {
		return new Stock(nbRestant);
	}

	public static Stock vide() {
		return new Stock(0);
	}

	private Stock(long nombreRestant) {
		this.nombreRestant = nombreRestant;
	}

	public Stock ajouter(long nombre) {
		if (nombre <= 0) {
			throw new ArticleModificationStockError();
		}
		if (nombre + nombreRestant > CAPACITE_MAX) {
			throw new ArticleCapaciteMaximaleAtteinteError();
		}
		return new Stock(nombreRestant + nombre);
	}

	public long getNombreRestant() {
		return nombreRestant;
	}

	public boolean isEmpty() {
		return this.nombreRestant == 0;
	}

}

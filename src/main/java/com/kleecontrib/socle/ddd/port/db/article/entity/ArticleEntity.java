package com.kleecontrib.socle.ddd.port.db.article.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "article")
@NamedQuery(name = "ArticleEntity.findAll", query = "SELECT a FROM ArticleEntity a")
public class ArticleEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "art_id")
	@Getter
	@Setter
	private Long artId;

	@Column(name = "nom")
	@Getter
	@Setter
	private String nom;

	@Column(name = "prix")
	@Getter
	@Setter
	private Double prix;

}

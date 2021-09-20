package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Poste implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPost;
	@Column(length = 7, unique = true)
	private String codPost;
	private String libPost;

	public Poste() {
		// TODO Auto-generated constructor stub
	}

	public Poste(String codPost, String libPost) {
		super();
		this.codPost = codPost;
		this.libPost = libPost;
	}

	public Long getIdPost() {
		return idPost;
	}

	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}

	public String getCodPost() {
		return codPost;
	}

	public void setCodPost(String codPost) {
		this.codPost = codPost;
	}

	public String getLibPost() {
		return libPost;
	}

	public void setLibPost(String libPost) {
		this.libPost = libPost;
	}

	@Override
	public String toString() {
		return "Poste [idPost=" + idPost + ", codPost=" + codPost + ", libPost=" + libPost + "]";
	}

}

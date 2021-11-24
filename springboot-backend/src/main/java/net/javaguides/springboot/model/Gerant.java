package net.javaguides.springboot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gerant")
public class Gerant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gerant")
	private long id;
	
	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "presentation")
	private String presentation;
	

	public Gerant() {
		super();
	}

	public Gerant(long id, String nom, String prenom, String presentation, Fond fond) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.presentation = presentation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	
}

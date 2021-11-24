package net.javaguides.springboot.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contrat")
public class Contrat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contrat")
	private long id;
	
	@Column(name = "nom_etablissement")
	private String nomEtablissement;

	@Column(name = "nom")
	private String nom;
	
	@Column(name = "devise")
	private String devise;
	
	@Column(name = "montant_ouverture")
	private Integer montantOuverture;
	
	@Column(name = "date_ouverture")
	private String dateOuverture;
	
	@Column(name = "allocation")
	private String allocation;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name="id_client", nullable = false)
	private Client client;	
	
	public Contrat() {
		super();
	}


	public Contrat(long id, String nomEtablissement, String nom, String devise, Integer montantOuverture,
			String dateOuverture, String allocation, Client client) {
		super();
		this.id = id;
		this.nomEtablissement = nomEtablissement;
		this.nom = nom;
		this.devise = devise;
		this.montantOuverture = montantOuverture;
		this.dateOuverture = dateOuverture;
		this.allocation = allocation;
		this.client = client;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomEtablissement() {
		return nomEtablissement;
	}

	public void setNomEtablissement(String nomEtablissement) {
		this.nomEtablissement = nomEtablissement;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public Integer getMontantOuverture() {
		return montantOuverture;
	}

	public void setMontantOuverture(Integer montantOuverture) {
		this.montantOuverture = montantOuverture;
	}

	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public String getAllocation() {
		return allocation;
	}


	public void setAllocation(String allocation) {
		this.allocation = allocation;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}

}

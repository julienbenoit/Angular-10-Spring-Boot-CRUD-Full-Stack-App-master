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
@Table(name = "fond")
public class Fond {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fond")
	private long id;
	
	@Column(name = "code_etablissement")
	private String codeEtablissement;

	@Column(name = "nom")
	private String nom;
	
	@Column(name = "code_usi")
	private String codeUsi;
	
	@Column(name = "montant_ouverture")
	private Integer montantOuverture;
	
	@Column(name = "date_creation")
	private String dateCreation;
	
	@Column(name = "allocation")
	private Integer allocation;
	

	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name="id_gerant", nullable = false)
	private Gerant gerant;
	
	@ManyToOne  (cascade = CascadeType.MERGE)
	@JoinColumn (name="id_contrat", nullable = false)
	private Contrat contrat;

	public Fond() {
		super();
	}

	public Fond(long id, String codeEtablissement, String nom, String codeUsi, Integer montantOuverture,
			String dateCreation, Integer allocation, Gerant gerant, Contrat contrat) {
		super();
		this.id = id;
		this.codeEtablissement = codeEtablissement;
		this.nom = nom;
		this.codeUsi = codeUsi;
		this.montantOuverture = montantOuverture;
		this.dateCreation = dateCreation;
		this.allocation = allocation;
		this.gerant = gerant;
		this.contrat = contrat;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodeEtablissement() {
		return codeEtablissement;
	}

	public void setCodeEtablissement(String codeEtablissement) {
		this.codeEtablissement = codeEtablissement;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodeUsi() {
		return codeUsi;
	}

	public void setCodeUsi(String codeUsi) {
		this.codeUsi = codeUsi;
	}

	public Integer getMontantOuverture() {
		return montantOuverture;
	}

	public void setMontantOuverture(Integer montantOuverture) {
		this.montantOuverture = montantOuverture;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Integer getAllocation() {
		return allocation;
	}

	public void setAllocation(Integer allocation) {
		this.allocation = allocation;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

}

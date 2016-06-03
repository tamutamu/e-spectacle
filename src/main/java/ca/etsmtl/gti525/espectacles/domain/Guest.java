package ca.etsmtl.gti525.espectacles.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name="Guests")
@Component
@Scope("session")
public class Guest {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String nom;

	private String addresseLivraison;
	private String addresseFacturation;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Facture> factureList = new ArrayList<Facture>();
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Panier panier;

	private String email;
	 
	public Guest(){
		
	}
	

	public String getAddresseLivraison() {
		return addresseLivraison;
	}

	public void setAddresseLivraison(String addresseLivraison) {
		this.addresseLivraison = addresseLivraison;
	}

	public String getAddresseFacturation() {
		return addresseFacturation;
	}

	public void setAddresseFacturation(String addresseFacturation) {
		this.addresseFacturation = addresseFacturation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail(){
		return email;
	}
	
}

package meuble.com.tn.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Admin extends User {
	
	/*@JsonIgnore
	@OneToMany(mappedBy = "admin", cascade =   CascadeType.ALL)
	private List<Produit> produit ;

	public List<Produit> getProduit() {
		return produit;
	}

	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	} */


}

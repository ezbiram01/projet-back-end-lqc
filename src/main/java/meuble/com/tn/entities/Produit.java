package meuble.com.tn.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity

public class Produit {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 

	@Temporal(TemporalType.DATE)
	private Date date;
	private String title; 
	
	private String source;

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	

	@ManyToOne
	@JoinColumn(name="admin_id")
	private Admin admin ; 
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}





	@ManyToOne
	@JoinColumn(name="categorie_id")
	private Categorie categ ; 
	
	public Categorie getCateg() {
		return categ;
	}
	public void setCateg(Categorie categ) {
		this.categ = categ;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
    
	
	/*
	@JsonIgnore
	@OneToMany(mappedBy = "categ" ,cascade = CascadeType.ALL )
	private List<Produit> produit ;
	
	
	
	public List<Produit> getTablie() {
		return produit;
	}
	public void setTablie(List<Produit> produit) {
		this.produit = produit;
	}*/
    

}



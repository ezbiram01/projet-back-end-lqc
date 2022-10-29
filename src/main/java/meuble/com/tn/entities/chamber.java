package meuble.com.tn.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class chamber {
	
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 

	@Temporal(TemporalType.DATE)
	private Date date;
	private String title; 
	
	private String source;
	private String source1;
	private String source2;
	private String source3;




	public String getSource1() {
		return source1;
	}
	public void setSource1(String source1) {
		this.source1 = source1;
	}
	public String getSource2() {
		return source2;
	}
	public void setSource2(String source2) {
		this.source2 = source2;
	}
	public String getSource3() {
		return source3;
	}
	public void setSource3(String source3) {
		this.source3 = source3;
	}
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
    
	
	

}

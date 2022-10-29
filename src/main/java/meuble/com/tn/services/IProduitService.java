package meuble.com.tn.services;

import java.util.List;

import meuble.com.tn.entities.Produit;


public interface IProduitService {
	
public void addProduit(String title , String source, int categorie, int admin );
	
	public void editProduit(int id ,String title, String source, int categorie);
	public void deleteProduit(int id);
	public Produit getProduitById(int id);
	public List<Produit> getAllProduit();
	public List<Produit> getAllProduitByAdmin(int id);

	public void edittProduit(int id, String title, String source, int categorie);

}

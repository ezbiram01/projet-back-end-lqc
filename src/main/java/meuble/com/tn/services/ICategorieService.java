package meuble.com.tn.services;

import java.util.List;

import meuble.com.tn.entities.Categorie;


public interface ICategorieService {
	
	public void addCategorie(String designation);
	public void editCategorie(  int id ,String designation);
	public void deleteCategorie(int id);
	public Categorie getCategorieById(int id);
	public List<Categorie> getAllCategories();
	public int checkCategorieIfExist(String designation) ; 


	
	

}

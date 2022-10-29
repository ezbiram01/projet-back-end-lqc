package meuble.com.tn.services;

import java.util.List;

import meuble.com.tn.entities.chamber;

public interface IChamberService {
	
	
public void addProduit(String title , String source,String source1,String source2,String source3, int categorie, int admin );
	
	public void editProduit(int id ,String title,  String source,String source1,String source2,String source3, int categorie);
	public void deleteProduit(int id);
	public chamber getProduitById(int id);
	public List<chamber> getAllProduit();
	public List<chamber> getAllProduitByAdmin(int id);

	public void edittProduit(int id, String title,  String source,String source1,String source2,String source3, int categorie);


}

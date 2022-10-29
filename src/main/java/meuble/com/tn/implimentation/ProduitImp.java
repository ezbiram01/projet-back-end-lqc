package meuble.com.tn.implimentation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuble.com.tn.dao.IAdmindao;
import meuble.com.tn.dao.ICategoriedao;
import meuble.com.tn.dao.IProduitdao;
import meuble.com.tn.entities.Produit;
import meuble.com.tn.services.IProduitService;

@Service
public class ProduitImp implements IProduitService{
	
	@Autowired
	IProduitdao produitDAO;
	@Autowired
	IAdmindao adminDao;
	@Autowired 
	ICategoriedao categDAO;
	

	@Override
	public void addProduit(String title, String source, int categorie , int admin ) {
		// TODO Auto-generated method stub
				Produit c = new Produit();
				
				c.setTitle(title);
				c.setSource(source);
				c.setDate(new Date());
				c.setCateg(categDAO.getById(categorie)); // cle etranger
				c.setAdmin(adminDao.getById(admin));


				produitDAO.save(c); 
		
	}

	@Override
	public void editProduit(int id,String title, String source, int categorie) {
		// TODO Auto-generated method stub
		Produit c = produitDAO.getById(id); 
		c.setTitle(title); 
		c.setSource(source);
		c.setCateg(categDAO.getById(categorie)); // cle etranger

		produitDAO.save(c);
		
	}

	@Override
	public void deleteProduit(int id) {
		// TODO Auto-generated method stub
		produitDAO.deleteById(id);
	}

	@Override
	public Produit getProduitById(int id) {
		return produitDAO.findById(id).get();

	}

	@Override
	public List<Produit> getAllProduit() {
		// TODO Auto-generated method stub
		return produitDAO.findAll();
	}

	@Override
	public List<Produit> getAllProduitByAdmin(int id) {
		List<Produit> all =  produitDAO.findAll();
		List<Produit> crs = new ArrayList<Produit>();
		
		return crs;
	}

	@Override
	public void edittProduit(int id, String title, String source, int categorie) {
		// TODO Auto-generated method stub
		Produit c = produitDAO.getById(id);
		 
		c.setTitle(title); 
		c.setSource(source);
		c.setCateg(categDAO.getById(categorie)); // cle etranger

		produitDAO.save(c);
		
	}

	

}

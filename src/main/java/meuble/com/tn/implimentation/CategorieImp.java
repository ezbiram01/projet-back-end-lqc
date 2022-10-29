package meuble.com.tn.implimentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuble.com.tn.dao.ICategoriedao;
import meuble.com.tn.entities.Categorie;
import meuble.com.tn.services.ICategorieService;

@Service
public class CategorieImp implements ICategorieService {
	
	@Autowired
	ICategoriedao categDAO;
	
	@Override
	public void addCategorie(String designation) {
		// TODO Auto-generated method stub
		Categorie c = new Categorie();
		c.setDesignation(designation);
		categDAO.save(c);
	}

	@Override
	public void editCategorie(int id, String designation) {
		// TODO Auto-generated method stub
		Categorie c = categDAO.getById(id);
		c.setDesignation(designation);
		categDAO.save(c);
	}

	@Override
	public void deleteCategorie(int id) {
		// TODO Auto-generated method stub
		categDAO.deleteById(id);
	}

	@Override
	public Categorie getCategorieById(int id) {
		// TODO Auto-generated method stub
		return categDAO.findById(id).get();
	}

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		return categDAO.findAll();
	}

	@Override
	public int checkCategorieIfExist(String designation) {
		List<Categorie>  all = categDAO.findAll();
		int nbr = 0;
		for(int i=0; i<all.size(); i++) {
			if(all.get(i).getDesignation().equals(designation)) {
				nbr = nbr+1 ;
			}
		}
		return nbr;
	}


}

package meuble.com.tn.implimentation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuble.com.tn.dao.IAdmindao;
import meuble.com.tn.dao.ICategoriedao;
import meuble.com.tn.dao.IChamberdao;
import meuble.com.tn.dao.IProduitdao;
import meuble.com.tn.entities.Produit;
import meuble.com.tn.entities.chamber;
import meuble.com.tn.services.IChamberService;

@Service
public class ChamberImp implements IChamberService{
	
	@Autowired
	IChamberdao chamberDao;
	@Autowired
	IAdmindao adminDao;
	@Autowired 
	ICategoriedao categDAO;
	
	

	@Override
	public void addProduit(String title, String source,String source1,String source2,String source3, int categorie , int admin ) {
		// TODO Auto-generated method stub
				chamber c = new chamber();
				
				c.setTitle(title);
				c.setSource(source);
				c.setSource1(source1);
				c.setSource2(source2);
				c.setSource3(source3);

				c.setDate(new Date());
				c.setCateg(categDAO.getById(categorie)); // cle etranger
				c.setAdmin(adminDao.getById(admin));


				chamberDao.save(c); 
		
	}

	@Override
	public void editProduit(int id,String title, String source,String source1,String source2,String source3, int categorie) {
		// TODO Auto-generated method stub
		chamber c = chamberDao.getById(id); 
		c.setTitle(title); 
		c.setSource(source);
		c.setSource1(source1);
		c.setSource2(source2);
		c.setSource3(source3);
		c.setCateg(categDAO.getById(categorie)); // cle etranger

		chamberDao.save(c);
		
	}

	@Override
	public void deleteProduit(int id) {
		// TODO Auto-generated method stub
		chamberDao.deleteById(id);
	}

	@Override
	public chamber getProduitById(int id) {
		return chamberDao.findById(id).get();

	}

	@Override
	public List<chamber> getAllProduit() {
		// TODO Auto-generated method stub
		return chamberDao.findAll();
	}

	@Override
	public List<chamber> getAllProduitByAdmin(int id) {
		List<chamber> all =  chamberDao.findAll();
		List<chamber> crs = new ArrayList<chamber>();
		
		return crs;
	}

	@Override
	public void edittProduit(int id, String title, String source,String source1,String source2,String source3, int categorie) {
		// TODO Auto-generated method stub
		chamber c = chamberDao.getById(id);
		 
		c.setTitle(title); 
		c.setSource(source);
		c.setSource1(source1);
		c.setSource2(source2);
		c.setSource3(source3);
		c.setCateg(categDAO.getById(categorie)); // cle etranger

		chamberDao.save(c);
		
	}

	

}

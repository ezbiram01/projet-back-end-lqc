package meuble.com.tn.implimentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuble.com.tn.dao.IAdmindao;
import meuble.com.tn.entities.Admin;
import meuble.com.tn.entities.User;
import meuble.com.tn.services.IAdminService;

@Service
public class AdminImp implements IAdminService {
	
	@Autowired
	IAdmindao admDao;

	@Override
	public void addAdmin( String firstName, String lastName, String gender, String country, String region, int tel,
			String email, String password , String role) {
		// TODO Auto-generated method stub 
		Admin c = new Admin();
		c.setFirstName(firstName);
		c.setLastName(lastName);
		c.setGender(gender);
		c.setCountry(country);
		c.setRegion(region);
		c.setTel(tel);
		c.setEmail(email); 
		c.setPassword(password);
		c.setRole(role);
		admDao.save(c);
		
	}
	
/*
	@Override
	public void addAdmin(Admin x) {
		// TODO Auto-generated method stub
		admDao.save(x);
	}*/
 
	@Override
	public void deleteAdmin(int idUser) {
		// TODO Auto-generated method stub
		admDao.deleteById(idUser);
		
	}

	@Override
	public Admin getAdminById(int idUser) {
		// TODO Auto-generated method stub
		return admDao.findById(idUser).get();
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return admDao.findAll();
	}

	@Override
	public void editAdmin(Admin x) {
		// TODO Auto-generated method stub
		admDao.save(x);
	}

	@Override
	public int checkAdminIfExist(String email) {
		List<Admin>  all = admDao.findAll();
		int nbr = 0;
		for(int i=0; i<all.size(); i++) {
			if(all.get(i).getEmail().equals(email)) {
				nbr = nbr+1 ;
			}
		}
		return nbr;
	}
	
	
	@Override
	public User checkuser( String password) {
		List<Admin> all = admDao.findAll(); 
		User u = null ;  
		for(int i =0; i<all.size(); i++) {  
			if( all.get(i).getPassword().equals(password.trim()) ) {
				System.out.println("existeeeeeeeeeeeeeeeeeeee"); 
				u = all.get(i);
			}
		}
		// TODO Auto-generated method stub
		return u;
	}
	
	
	
	
	
	
}

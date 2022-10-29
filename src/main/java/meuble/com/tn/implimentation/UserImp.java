package meuble.com.tn.implimentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuble.com.tn.dao.IUserdao;
import meuble.com.tn.entities.User;
import meuble.com.tn.services.IUserService;

@Service
public class UserImp implements IUserService  {

	

	@Autowired
	IUserdao userDao;
	@Override
	public User checkuser(String email, String password) {
		List<User> all = userDao.findAll(); 
		User u = null ;  
		for(int i =0; i<all.size(); i++) {  
			if(all.get(i).getEmail().equals(email) && all.get(i).getPassword().equals(password.trim()) ) {
				System.out.println("existeeeeeeeeeeeeeeeeeeee"); 
				u = all.get(i);
			}
		}
		// TODO Auto-generated method stub
		return u;
	}
	
	@Override
	public User getUserInfo(String email) {
		List<User> all = userDao.findAll(); 
		User u = null ; 
		for(int i =0; i<all.size(); i++) {
			if(all.get(i).getEmail().equals(email)) { 
				u = all.get(i);
			}
		}
		// TODO Auto-generated method stub
		return u;
	}

	@Override
	public void editPassword(int id, String password) {
		// TODO Auto-generated method stub
		User u = userDao.getById(id); 
		u.setPassword(password);
		userDao.save(u);
	}
	 
	
	   
	 

	 
    
}

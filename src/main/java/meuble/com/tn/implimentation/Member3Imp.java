package meuble.com.tn.implimentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuble.com.tn.dao.IMemberN3;
import meuble.com.tn.entities.MemberN3;
import meuble.com.tn.entities.User;
import meuble.com.tn.services.IMember3Service;


@Service
public class Member3Imp implements IMember3Service {
	
	@Autowired
    IMemberN3 m3Dao;
	
	

	@Override
	public void editMemberN3(MemberN3 a ) {  
		m3Dao.save(a);
	}

	@Override
	public void deleteMemberN3(int idUser) {
		// TODO Auto-generated method stub
		m3Dao.deleteById(idUser);
		
	}

	@Override
	public MemberN3 getMemberN3ById(int idUser) {
		// TODO Auto-generated method stub
		return m3Dao.findById(idUser).get();
	}

	@Override
	public List<MemberN3> getAllMemberN3() {
		// TODO Auto-generated method stub
		return m3Dao.findAll();
	}

	@Override
	public void addMemberN3(String firstName, String lastName, String gender, String country, String region, int tel,
			String email, String password, String role) {
		MemberN3 c = new MemberN3();
		c.setFirstName(firstName);
		c.setLastName(lastName);
		c.setGender(gender);
		c.setCountry(country);
		c.setRegion(region);
		c.setTel(tel);
		c.setEmail(email); 
		c.setPassword(password);
		c.setRole(role);
		m3Dao.save(c);
	}

	@Override
	public int checkMemberN3Exist(String email) {
		List<MemberN3>  all = m3Dao.findAll();
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
		List<MemberN3> all = m3Dao.findAll(); 
		User u = null ;  
		for(int i =0; i<all.size(); i++) {  
			if( all.get(i).getPassword().equals(password.trim()) ) {
				System.out.println("existe"); 
				u = all.get(i);
			}
		}
		// TODO Auto-generated method stub
		return u;
	}

	
	
	


}





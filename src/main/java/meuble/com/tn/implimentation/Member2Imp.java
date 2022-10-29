package meuble.com.tn.implimentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuble.com.tn.dao.IMemberN2;
import meuble.com.tn.entities.MemberN2;
import meuble.com.tn.entities.User;
import meuble.com.tn.services.IMember2Service;

@Service
public class Member2Imp implements IMember2Service {
	
	

	@Autowired
	IMemberN2 m2Dao;


	@Override
	public void editMemberN2(MemberN2 a ) {  
		m2Dao.save(a);
	}

	@Override
	public void deleteMemberN2(int idUser) {
		// TODO Auto-generated method stub
		m2Dao.deleteById(idUser);
		
	}

	@Override
	public MemberN2 getMemberN2ById(int idUser) {
		// TODO Auto-generated method stub
		return m2Dao.findById(idUser).get();
	}

	@Override
	public List<MemberN2> getAllMemberN2() {
		// TODO Auto-generated method stub
		return m2Dao.findAll();
	}

	@Override
	public void addMemberN2(String firstName, String lastName, String gender, String country, String region, int tel,
			String email, String password, String role) {
		MemberN2 c = new MemberN2();
		c.setFirstName(firstName);
		c.setLastName(lastName);
		c.setGender(gender);
		c.setCountry(country);
		c.setRegion(region);
		c.setTel(tel);
		c.setEmail(email); 
		c.setPassword(password);
		c.setRole(role);
		m2Dao.save(c);
	}

	@Override
	public int checkMemberN2Exist(String email) {
		List<MemberN2>  all = m2Dao.findAll();
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
		List<MemberN2> all = m2Dao.findAll(); 
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

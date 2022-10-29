package meuble.com.tn.implimentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meuble.com.tn.dao.IMemberN1;
import meuble.com.tn.entities.MemberN1;
import meuble.com.tn.entities.User;
import meuble.com.tn.services.IMember1Service;

@Service
public class Member1Imp implements IMember1Service{
	
	
	@Autowired
	IMemberN1 m1Dao;


	@Override
	public void editMemberN1(MemberN1 a ) {  
		m1Dao.save(a);
	}

	@Override
	public void deleteMemberN1(int idUser) {
		// TODO Auto-generated method stub
		m1Dao.deleteById(idUser);
		
	}

	@Override
	public MemberN1 getMemberN1ById(int idUser) {
		// TODO Auto-generated method stub
		return m1Dao.findById(idUser).get();
	}

	@Override
	public List<MemberN1> getAllMemberN1() {
		// TODO Auto-generated method stub
		return m1Dao.findAll();
	}

	@Override
	public void addMemberN1(String firstName, String lastName, String gender, String country, String region, int tel,
			String email, String password, String role) {
		MemberN1 c = new MemberN1();
		c.setFirstName(firstName);
		c.setLastName(lastName);
		c.setGender(gender);
		c.setCountry(country);
		c.setRegion(region);
		c.setTel(tel);
		c.setEmail(email); 
		c.setPassword(password);
		c.setRole(role);
		m1Dao.save(c);
	}

	@Override
	public int checkMemberN1Exist(String email) {
		List<MemberN1>  all = m1Dao.findAll();
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
		List<MemberN1> all = m1Dao.findAll(); 
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

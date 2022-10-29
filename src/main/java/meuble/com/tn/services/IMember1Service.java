package meuble.com.tn.services;

import java.util.List;

import meuble.com.tn.entities.MemberN1;
import meuble.com.tn.entities.User;


public interface IMember1Service {
	
	public void addMemberN1(String firstName, String lastName, String gender, String country, String region, int tel,
			String email, String password, String role);
	public int checkMemberN1Exist(String email) ; 
	
	public void editMemberN1(MemberN1 a );
	public void deleteMemberN1(int idUser);
	public MemberN1 getMemberN1ById(int idUser);
	public List<MemberN1> getAllMemberN1();
	public User checkuser( String password);


}

package meuble.com.tn.services;

import java.util.List;

import meuble.com.tn.entities.MemberN3;
import meuble.com.tn.entities.User;

public interface IMember3Service {
	

	public void addMemberN3( String firstName, String lastName, String gender, String country, String region, int tel,
			String email, String password ,String role);
	public int checkMemberN3Exist(String email) ; 
	
	public void editMemberN3(MemberN3 a );
	public void deleteMemberN3(int idUser);
	public MemberN3 getMemberN3ById(int idUser);
	public List<MemberN3> getAllMemberN3();
	public User checkuser( String password);



}

package meuble.com.tn.services;

import java.util.List;

import meuble.com.tn.entities.MemberN2;
import meuble.com.tn.entities.User;

public interface IMember2Service {
	

	public void addMemberN2(String firstName, String lastName, String gender, String country, String region, int tel,
			String email, String password, String role);
	public int checkMemberN2Exist(String email) ; 
	
	public void editMemberN2(MemberN2 a );
	public void deleteMemberN2(int idUser);
	public MemberN2 getMemberN2ById(int idUser);
	public List<MemberN2> getAllMemberN2();
	public User checkuser( String password);


}

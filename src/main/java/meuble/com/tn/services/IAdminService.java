package meuble.com.tn.services;

import java.util.List;

import meuble.com.tn.entities.Admin;
import meuble.com.tn.entities.User;

public interface IAdminService {
	
	public void editAdmin (Admin x);  
	public void deleteAdmin(int idUser);
	public Admin getAdminById(int idUser);
	public List<Admin> getAllAdmin();
	public User checkuser( String password);

	
	public int checkAdminIfExist(String email) ; 

	
	public void addAdmin( String firstName, String lastName, String gender, String country, String region, int tel,
			String email, String password , String role);


}

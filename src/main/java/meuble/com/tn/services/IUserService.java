package meuble.com.tn.services;

import meuble.com.tn.entities.User;

public interface IUserService {
	public User checkuser(String email, String password);
	public User getUserInfo(String email);
	public void editPassword(int id, String password );


}

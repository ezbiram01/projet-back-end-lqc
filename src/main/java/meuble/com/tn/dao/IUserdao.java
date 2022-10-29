package meuble.com.tn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import meuble.com.tn.entities.User;

public interface IUserdao extends JpaRepository<User, Integer> {

}

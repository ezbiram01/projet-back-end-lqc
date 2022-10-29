package meuble.com.tn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import meuble.com.tn.entities.Admin;

public interface IAdmindao extends JpaRepository<Admin, Integer> {

}

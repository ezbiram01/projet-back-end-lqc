package meuble.com.tn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import meuble.com.tn.entities.chamber;

public interface IChamberdao extends JpaRepository<chamber, Integer> {

}

package meuble.com.tn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import meuble.com.tn.entities.Categorie;

public interface ICategoriedao extends JpaRepository<Categorie, Integer> {

}

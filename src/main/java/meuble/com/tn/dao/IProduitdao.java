package meuble.com.tn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import meuble.com.tn.entities.Produit;

public interface IProduitdao extends JpaRepository<Produit, Integer> {

}

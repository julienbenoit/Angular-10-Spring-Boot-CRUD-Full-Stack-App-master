package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Client;
import net.javaguides.springboot.model.Contrat;
import net.javaguides.springboot.model.Fond;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	  @Query(value ="select * from Client c where c.nom = ?1", nativeQuery = true)
	  List<Client> trouverClientParNom(String name);
}

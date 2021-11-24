package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Contrat;
import net.javaguides.springboot.model.Fond;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long>{
	  @Query(value ="select * from Contrat c where c.nom = ?1", nativeQuery = true)
	  List<Contrat> trouverContratParNom(String name);
	  
	  
	  @Query(value ="select * from Contrat c where c.id = ?1", nativeQuery = true)
	  Contrat trouverContratParId(Long name);
	  
	  @Query(value ="select * from Contrat c where c.id_client = ?1", nativeQuery = true)
	  Contrat trouverContratParIdClient(Long name);
}

package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Contrat;
import net.javaguides.springboot.model.Fond;

@Repository
public interface FondRepository extends JpaRepository<Fond, Long>{
	  
 
	  @Query(value = "select * from Fond f where f.id_contrat = ?1", nativeQuery = true)
	  List<Fond> findFondByIdContrat(Long idContrat);
	  
	  @Query(value ="select * from Fond f where f.nom = ?1", nativeQuery = true)
	  List<Fond> trouverFondParNom(String name);
	  
	  @Query(value ="select * from Fond f where f.id_gerant = ?1", nativeQuery = true)
	  List<Fond> trouverFondParGerant(Long idGerant);
	  

}

package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Fond;
import net.javaguides.springboot.model.Gerant;

@Repository
public interface GerantRepository extends JpaRepository<Gerant, Long>{
	  @Query(value ="select * from Gerant g where g.nom = ?1", nativeQuery = true)
	  List<Gerant> trouverGerantParNom(String name);
}

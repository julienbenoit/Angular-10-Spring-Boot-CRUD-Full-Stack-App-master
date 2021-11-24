package net.javaguides.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Contrat;
import net.javaguides.springboot.model.Fond;
import net.javaguides.springboot.repository.FondRepository;

@Service
public class FondService {
	@Autowired  
	FondRepository fondRepository;  

  
	public Fond saveFond(Fond fond){  
		fondRepository.save(fond);  
	return fond;  
	} 
	
	public Optional<Fond> trouverUnFond(Long idFond){  
	Optional<Fond> fond =	fondRepository.findById(idFond);  
	 return fond;  
	} 
	public void supprimerFond(Fond fond){  
		fondRepository.delete(fond);  
	} 
	
}

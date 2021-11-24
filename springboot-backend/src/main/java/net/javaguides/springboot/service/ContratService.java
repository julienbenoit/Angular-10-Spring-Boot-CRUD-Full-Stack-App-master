package net.javaguides.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Client;
import net.javaguides.springboot.model.Contrat;
import net.javaguides.springboot.model.Fond;
import net.javaguides.springboot.model.Gerant;
import net.javaguides.springboot.repository.ClientRepository;
import net.javaguides.springboot.repository.ContratRepository;
import net.javaguides.springboot.repository.FondRepository;
import net.javaguides.springboot.repository.GerantRepository;

@Service
public class ContratService {
	@Autowired  
	ContratRepository contratRepository;  
	
	@Autowired  
	FondRepository fondRepository;  
	
	@Autowired  
	ClientRepository clientRepository;  
	
	@Autowired  
	GerantRepository gerantRepository;  
	
	public List<Contrat> getAllContrat(){  
	List<Contrat> contrats = new ArrayList<Contrat>();  
	contrats = contratRepository.findAll();  
	return contrats;  
	}  
	public List<Fond> getAllFond(Long idContrat){  
		List<Fond> fonds = new ArrayList<Fond>(); 
		List<Fond> fondValorises = new ArrayList<Fond>(); 
		Optional<Contrat> contrat =	contratRepository.findById(idContrat);  

		fonds = fondRepository.findFondByIdContrat(idContrat);
		fonds.forEach(fond ->{
			
			fond.setMontantOuverture(fond.getAllocation()*contrat.get().getMontantOuverture());
			fondValorises.add(fond);
		});
		
		return fondValorises;  
		
		} 
	
	public Contrat saveContrat(Contrat contrat){  

	contratRepository.save(contrat);  
	return contrat;  
	}  
	public List<Contrat> trouverContrat(String name){  
		List<Contrat> contrats =	contratRepository.trouverContratParNom(name); 
		
		List<Fond> fonds = fondRepository.trouverFondParNom(name);
		fonds.forEach(fond ->{
			contrats.add(contratRepository.trouverContratParId(fond.getContrat().getId()));
		});
		
		List<Client> clients = clientRepository.trouverClientParNom(name);
		clients.forEach(client ->{
			contrats.add(contratRepository.trouverContratParIdClient(client.getId()));
		});
		
		List<Gerant> gerants = gerantRepository.trouverGerantParNom(name);
		gerants.forEach(gerant ->{
			fondRepository.trouverFondParGerant(gerant.getId()).forEach(fond ->{
				contrats.add(contratRepository.trouverContratParId(fond.getContrat().getId()));
			});
		});
		 return contrats;  
		}
	
	public Optional<Contrat> trouverUnContrat(Long idContrat){  
	Optional<Contrat> contrat =	contratRepository.findById(idContrat);  
	 return contrat;  
	} 
	
	public void supprimerContrat(Contrat contrat){  
		contratRepository.delete(contrat);  
	}
}

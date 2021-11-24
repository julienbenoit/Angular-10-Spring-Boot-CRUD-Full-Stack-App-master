package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Contrat;
import net.javaguides.springboot.model.Fond;
import net.javaguides.springboot.service.ContratService;
import net.javaguides.springboot.service.FondService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ContratController {

	@Autowired
	private ContratService contratService;

	@GetMapping("/contrats")
	public ResponseEntity<List<Contrat>> getAllContrat(){
		return ResponseEntity.ok(contratService.getAllContrat());
	}		
	@GetMapping("/contrat/{id}")
	public ResponseEntity<Contrat> getContrat(@PathVariable Long id){
		Contrat contratTrouve = contratService.trouverUnContrat(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contrat not exist with id :" + id));
		
		return ResponseEntity.ok(contratTrouve);
	}
	@GetMapping("/contrats/{id}")
	public ResponseEntity<List<Fond>> getAllFond(@PathVariable Long id){
		
		return ResponseEntity.ok(contratService.getAllFond(id));
	}
	
	@GetMapping("/contrat")
	public ResponseEntity<List<Contrat>> findContrat(@RequestParam String name){
		
		return ResponseEntity.ok(contratService.trouverContrat(name));
	}

	@PostMapping("/create/contrat")
	public ResponseEntity<Contrat> createContrat(@RequestBody Contrat contrat) {
		return ResponseEntity.ok(contratService.saveContrat(contrat));
	}
	
	@PutMapping("/contrat/{id}")
	public ResponseEntity<Contrat> updateContrat(@PathVariable Long id, @RequestBody Contrat contrat){
		Contrat contratUpdate = contratService.trouverUnContrat(id)
				
				.orElseThrow(() -> new ResourceNotFoundException("Contrat not exist with id :" + id));
		
		contratUpdate.setNom(contrat.getNom());
		contratUpdate.setNomEtablissement(contrat.getNomEtablissement());
		contratUpdate.setDevise(contrat.getDevise());
		contratUpdate.setMontantOuverture(contrat.getMontantOuverture());
		contratUpdate.setDateOuverture(contrat.getDateOuverture());
		contratUpdate.setAllocation(contrat.getAllocation());
		contratUpdate.setClient(contrat.getClient());
		
		Contrat fondEnregi = contratService.saveContrat(contratUpdate);
		return ResponseEntity.ok(fondEnregi);
	}
	
	@DeleteMapping("/contrat/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteContrat(@PathVariable Long id){
		Contrat contratUpdate = contratService.trouverUnContrat(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contrat not exist with id :" + id));
		contratService.supprimerContrat(contratUpdate);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}

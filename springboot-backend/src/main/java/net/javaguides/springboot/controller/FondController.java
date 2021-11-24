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
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Contrat;
import net.javaguides.springboot.model.Fond;
import net.javaguides.springboot.service.FondService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class FondController {

	@Autowired
	private FondService fondService;
	
	@GetMapping("/fond/{id}")
	public ResponseEntity<Fond> getContrat(@PathVariable Long id){
		Fond fondTrouve = fondService.trouverUnFond(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contrat not exist with id :" + id));
		
		return ResponseEntity.ok(fondTrouve);
	}
	@PostMapping("/create/fond")
	public ResponseEntity<Fond> createFond(@RequestBody Fond fond) {		
		Fond fondSave = fondService.saveFond(fond);				
		return ResponseEntity.ok(fondSave);	
	}
	
	@PutMapping("/fond/{id}")
	public ResponseEntity<Fond> updateEmployee(@PathVariable Long id, @RequestBody Fond fond){
		Fond fondUpdate = fondService.trouverUnFond(id)
				.orElseThrow(() -> new ResourceNotFoundException("Fond not exist with id :" + id));
		
		fondUpdate.setNom(fond.getNom());
		fondUpdate.setCodeEtablissement(fond.getCodeEtablissement());
		fondUpdate.setMontantOuverture(fond.getMontantOuverture());
		fondUpdate.setCodeUsi(fond.getCodeUsi());
		fondUpdate.setDateCreation(fond.getDateCreation());
		fondUpdate.setAllocation(fond.getAllocation());
		fondUpdate.setContrat(fond.getContrat());
		fondUpdate.setGerant(fond.getGerant());
		
		Fond fondEnregi = fondService.saveFond(fondUpdate);
		return ResponseEntity.ok(fondEnregi);
	}
	
	@DeleteMapping("/fond/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Fond fondUpdate = fondService.trouverUnFond(id)
				.orElseThrow(() -> new ResourceNotFoundException("Fond not exist with id :" + id));
		fondService.supprimerFond(fondUpdate);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}

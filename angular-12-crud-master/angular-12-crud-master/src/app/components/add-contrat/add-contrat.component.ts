import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/models/client.model';
import { Contrat } from 'src/app/models/contrat.model';
import { ContratService } from 'src/app/services/contrat.service';

@Component({
  selector: 'app-add-contrat',
  templateUrl: './add-contrat.component.html',
  styleUrls: ['./add-contrat.component.css']
})
export class AddContratComponent implements OnInit {

  contrat: Contrat = {
    nom: '',
    nomEtablissement: '',
    devise: '',
    montantOuverture: 0,
    dateOuverture: '',
    allocation: '',
    client: {
      nom: '',
      prenom: '',
      email: '',
    }
  };
  submitted = false;

  constructor(private contratService: ContratService) { }

  ngOnInit(): void {
  }

  saveContrat(): void {
    const data = {
      nom: this.contrat.nom,
      nomEtablissement: this.contrat.nomEtablissement,
      devise: this.contrat.devise,
      montantOuverture: this.contrat.montantOuverture,
      dateOuverture: this.contrat.dateOuverture,
      allocation: this.contrat.allocation,
      client: {
        nom: this.contrat.client?.nom,
        prenom: this.contrat.client?.prenom,
        email: this.contrat.client?.email,
      }
    };

    this.contratService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }


}

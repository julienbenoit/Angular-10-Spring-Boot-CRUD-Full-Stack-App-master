import { Component, OnInit } from '@angular/core';
import { ContratService } from 'src/app/services/contrat.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Contrat } from 'src/app/models/contrat.model';

@Component({
  selector: 'app-contrat-details',
  templateUrl: './contrat-details.component.html',
  styleUrls: ['./contrat-details.component.css']
})
export class ContratDetailsComponent implements OnInit {

  currentContrat: Contrat = {
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

  message = '';

  constructor(
    private contratService: ContratService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getContrat(this.route.snapshot.params.id);
  }

  getContrat(id: string): void {
    this.contratService.get(id)
      .subscribe(
        data => {
          this.currentContrat = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  updatePublished(status: boolean): void {
    const data = {
      nom: this.currentContrat.nom,
      nomEtablissement: this.currentContrat.nomEtablissement,
      devise: this.currentContrat.devise,
      montantOuverture: this.currentContrat.montantOuverture,
      dateOuverture: this.currentContrat.dateOuverture,
      allocation: this.currentContrat.allocation,
      client: {
        nom: this.currentContrat.client?.nom,
        prenom: this.currentContrat.client?.prenom,
        email: this.currentContrat.client?.email,
      }
    };

    this.message = '';

    this.contratService.update(this.currentContrat.id, data)
      .subscribe(
        response => {
          //this.currentContrat.published = status;
          console.log(response);
          this.message = response.message ? response.message : 'The status was updated successfully!';
        },
        error => {
          console.log(error);
        });
  }

  updateContrat(): void {
    this.message = '';
    const data = {
      nom: this.currentContrat.nom,
      nomEtablissement: this.currentContrat.nomEtablissement,
      devise: this.currentContrat.devise,
      montantOuverture: this.currentContrat.montantOuverture,
      dateOuverture: this.currentContrat.dateOuverture,
      allocation: this.currentContrat.allocation,
      client: {
        nom: this.currentContrat.client?.nom,
        prenom: this.currentContrat.client?.prenom,
        email: this.currentContrat.client?.email,
      }
    };
    this.contratService.update(this.currentContrat.id, data)
      .subscribe(
        response => {
          console.log(response);
          this.message = response.message ? response.message : 'This contrat was updated successfully!';
        },
        error => {
          console.log(error);
        });
  }

  deleteContrat(): void {
    this.contratService.delete(this.currentContrat.id)
      .subscribe(
        response => {
          console.log(response);
          this.router.navigate(['/contrats']);
        },
        error => {
          console.log(error);
        });
  }

}

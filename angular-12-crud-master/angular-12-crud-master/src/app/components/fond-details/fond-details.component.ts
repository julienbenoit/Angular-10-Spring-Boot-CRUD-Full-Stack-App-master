import { Component, OnInit } from '@angular/core';
import { ContratService } from 'src/app/services/contrat.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Contrat } from 'src/app/models/contrat.model';
import { Fond } from 'src/app/models/fond.model';
import { FondService } from 'src/app/services/fond.service';

@Component({
  selector: 'app-fond-details',
  templateUrl: './fond-details.component.html',
  styleUrls: ['./fond-details.component.css']
})
export class FondlDetailsComponent implements OnInit {

  currentFond: Fond = { };
  currentContrat: Contrat = { };
  message = '';
  currentIndex = -1;
  contrats?: Contrat[];
  constructor(
    private fondService: FondService,
    private contratService: ContratService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getFond(this.route.snapshot.params.id);
    this.retrieveContrats();
  }
  retrieveContrats(): void {
    this.contratService.getAll()
      .subscribe(
        data => {
          this.contrats = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
  getFond(id: string): void {
    this.fondService.get(id)
      .subscribe(
        data => {
          this.currentFond = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  setActiveContrat(contrat: Contrat, index: number): void {

        this.currentContrat = contrat;
        this.currentIndex = index;
      

  }
  updateFond(): void {
    const data = {
      codeUsi: this.currentFond.codeUsi,
      codeEtablissement: this.currentFond.codeEtablissement,
      montantOuverture: this.currentFond.montantOuverture,
      dateCreation: this.currentFond.dateCreation,
      allocation: this.currentFond.allocation,
      gerant: {
        nom: this.currentFond.gerant?.nom,
        prenom: this.currentFond.gerant?.prenom,
        email: this.currentFond.gerant?.presentation,
      },
      contrat: this.currentContrat
      
    };

    this.fondService.update(this.currentFond.id, this.currentFond)
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
    this.fondService.delete(this.currentFond.id)
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

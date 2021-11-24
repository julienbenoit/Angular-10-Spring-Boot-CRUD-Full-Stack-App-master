import { Component, OnInit } from '@angular/core';
import { Contrat } from 'src/app/models/contrat.model';
import { Fond } from 'src/app/models/fond.model';
import { FondService } from 'src/app/services/fond.service';
import { ContratService } from 'src/app/services/contrat.service';

@Component({
  selector: 'app-add-fond',
  templateUrl: './add-fond.component.html',
  styleUrls: ['./add-fond.component.css']
})
export class AddFondComponent implements OnInit {

  fond: Fond = {
    codeUsi: '',
    codeEtablissement: '',
    montantOuverture: 0,
    dateCreation: '',
    allocation: 0,
    gerant: {
      nom: '',
      prenom: '',
      presentation: '',
    },
    contrat:{
      id:''
    }
  };
  contrats?: Contrat[];
  currentContrat: Contrat = {};
  currentIndex = -1;
  submitted = false;

  constructor(private fondService: FondService, private contratService: ContratService) { }

  ngOnInit(): void {
    this.retrieveContrats();
  }

  saveFond(): void {
    const data = {
      codeUsi: this.fond.codeUsi,
      codeEtablissement: this.fond.codeEtablissement,
      montantOuverture: this.fond.montantOuverture,
      dateCreation: this.fond.dateCreation,
      allocation: this.fond.allocation,
      gerant: {
        nom: this.fond.gerant?.nom,
        prenom: this.fond.gerant?.prenom,
        email: this.fond.gerant?.presentation,
      },
      contrat: this.currentContrat
      
    };

    this.fondService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }


  setActiveContrat(contrat: Contrat, index: number): void {
    this.currentContrat = contrat;
    this.currentIndex = index;
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

}

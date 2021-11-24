import { Component, OnInit } from '@angular/core';
import { Contrat } from 'src/app/models/contrat.model';
import { Fond } from 'src/app/models/fond.model';
import { ContratService } from 'src/app/services/contrat.service';

@Component({
  selector: 'app-contrat-list',
  templateUrl: './contrat-list.component.html',
  styleUrls: ['./contrat-list.component.css']
})
export class ContratsListComponent implements OnInit {

  contrats?: Contrat[];
  fonds?: Fond[];
  fondsMontantPart?: Fond[];
  currentContrat?: Contrat = {};
  currentFond: Fond = {};
  currentIndex = -1;
  currentIndexFond = -1;
  name = '';
  fondPartiel?: number;
  constructor(private contratService: ContratService) { }

  ngOnInit(): void {
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

  refreshList(): void {
    this.retrieveContrats();
    this.currentContrat = {};
    this.currentIndex = -1;
  }

  setActiveFond(fond: Fond, index: number): void {
    this.currentFond = fond;
    this.currentIndexFond = index;
  }

  setActiveContrat(contrat: Contrat, index: number): void {
    
    this.contratService.getAllFond(contrat.id)
    .subscribe(
      data => {
        this.fonds = data;
        console.log(data);
      },
      error => {
        console.log(error);
      });
    this.currentContrat = contrat;
    this.currentIndex = index;
  }

  searchContrat(): void {
    this.currentContrat = {};
    this.currentIndex = -1;

    this.contratService.findByName(this.name)
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

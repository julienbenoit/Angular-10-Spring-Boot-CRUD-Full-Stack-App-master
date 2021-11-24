import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContratsListComponent } from './components/contrat-list/contrat-list.component';
import { ContratDetailsComponent } from './components/contrat-details/contrat-details.component';
import { AddContratComponent } from './components/add-contrat/add-contrat.component';
import { AddFondComponent } from './components/add-Fond/add-fond.component';
import { FondlDetailsComponent } from './components/fond-details/fond-details.component';

const routes: Routes = [
  { path: '', redirectTo: 'contrats', pathMatch: 'full' },
  { path: 'contrats', component: ContratsListComponent },
  { path: 'contrats/:id', component: ContratDetailsComponent },
  { path: 'fond/:id', component: FondlDetailsComponent },
  { path: 'add', component: AddContratComponent },
  { path: 'addFond', component: AddFondComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

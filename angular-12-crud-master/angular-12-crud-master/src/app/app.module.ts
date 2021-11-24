import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddContratComponent } from './components/add-contrat/add-contrat.component';
import { ContratDetailsComponent } from './components/contrat-details/contrat-details.component';
import { ContratsListComponent } from './components/contrat-list/contrat-list.component';
import { AddFondComponent } from './components/add-Fond/add-fond.component';
import { FondlDetailsComponent } from './components/fond-details/fond-details.component';

@NgModule({
  declarations: [
    AppComponent,
    AddContratComponent,
    ContratDetailsComponent,
    FondlDetailsComponent,
    AddFondComponent,
    ContratsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

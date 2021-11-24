import { Client } from "./client.model";

export class Contrat {
  id?: any;
  nom?: string;
  nomEtablissement?: string;
  devise?: string;
  montantOuverture?: number;
  dateOuverture?: string;
  allocation?: string;
  client?: Client;
}

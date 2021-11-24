import { Contrat } from "./contrat.model";
import { Gerant } from "./gerant.model";

export class Fond {
  id?: any;
  codeUsi?: string;
  nom?: string;
  codeEtablissement?: string;
  montantOuverture?: number;
  dateCreation?: string;
  allocation?: number;
  gerant?: Gerant;
  contrat?: Contrat;
}

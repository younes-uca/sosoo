import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {RueCriteria} from './RueCriteria.model';
import {CategorieLocaleCriteria} from '../taxe/CategorieLocaleCriteria.model';

export class LocaleCriteria  extends BaseCriteria  {

    public id: number;
    public ref: string;
    public refLike: string;
    public libelle: string;
    public libelleLike: string;
    public complementAdresse: string;
    public complementAdresseLike: string;
     public dernierAnneeDePaiement: number;
     public dernierAnneeDePaiementMin: number;
     public dernierAnneeDePaiementMax: number;
     public dernierTrimestre: number;
     public dernierTrimestreMin: number;
     public dernierTrimestreMax: number;
     public superficie: number;
     public superficieMin: number;
     public superficieMax: number;
  public rue: RueCriteria ;
  public rues: Array<RueCriteria> ;

}

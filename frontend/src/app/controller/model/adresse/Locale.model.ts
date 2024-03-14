import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {RueDto} from './Rue.model';
import {CategorieLocaleDto} from '../taxe/CategorieLocale.model';

export class LocaleDto extends BaseDto{

    public ref: string;

    public libelle: string;

    public complementAdresse: string;

    public dernierAnneeDePaiement: null | number;

    public dernierTrimestre: null | number;

    public superficie: null | number;

    public rue: RueDto ;
    public categorieLocale: CategorieLocaleDto ;
    

    constructor() {
        super();

        this.ref = '';
        this.libelle = '';
        this.complementAdresse = '';
        this.dernierAnneeDePaiement = null;
        this.dernierTrimestre = null;
        this.superficie = null;
        this.rue = new RueDto() ;

        }

}

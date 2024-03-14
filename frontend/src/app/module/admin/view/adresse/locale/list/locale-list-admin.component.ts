import {Component, OnInit} from '@angular/core';
import {LocaleAdminService} from 'src/app/controller/service/admin/adresse/LocaleAdmin.service';
import {LocaleDto} from 'src/app/controller/model/adresse/Locale.model';
import {LocaleCriteria} from 'src/app/controller/criteria/adresse/LocaleCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {RueDto} from 'src/app/controller/model/adresse/Rue.model';
import {RueAdminService} from 'src/app/controller/service/admin/adresse/RueAdmin.service';
import {CategorieLocaleDto} from 'src/app/controller/model/taxe/CategorieLocale.model';
import {CategorieLocaleAdminService} from 'src/app/controller/service/admin/taxe/CategorieLocaleAdmin.service';


@Component({
  selector: 'app-locale-list-admin',
  templateUrl: './locale-list-admin.component.html'
})
export class LocaleListAdminComponent extends AbstractListController<LocaleDto, LocaleCriteria, LocaleAdminService>  implements OnInit {

    override fileName = 'Locale';


    rues: Array<RueDto>;
    categorieLocales: Array<CategorieLocaleDto>;


    constructor( private localeService: LocaleAdminService  , private rueService: RueAdminService, private categorieLocaleService: CategorieLocaleAdminService) {
        super(localeService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Locale').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadRue();
                this.loadCategorieLocale();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'ref', header: 'Ref'},
            {field: 'libelle', header: 'Libelle'},
            {field: 'complementAdresse', header: 'Complement adresse'},
            {field: 'dernierAnneeDePaiement', header: 'Dernier annee de paiement'},
            {field: 'dernierTrimestre', header: 'Dernier trimestre'},
            {field: 'superficie', header: 'Superficie'},
            {field: 'rue?.libelle', header: 'Rue'},
            {field: 'categorieLocale?.libelle', header: 'Categorie locale'},
        ];
    }


    public async loadRue(){
       this.rueService.findAllOptimized().subscribe(rues => this.rues = rues, error => console.log(error))
    }
    public async loadCategorieLocale(){
       this.categorieLocaleService.findAllOptimized().subscribe(categorieLocales => this.categorieLocales = categorieLocales, error => console.log(error))
    }



   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Ref': e.ref ,
                 'Libelle': e.libelle ,
                 'Complement adresse': e.complementAdresse ,
                 'Dernier annee de paiement': e.dernierAnneeDePaiement ,
                 'Dernier trimestre': e.dernierTrimestre ,
                 'Superficie': e.superficie ,
                'Rue': e.rue?.libelle ,
                'Categorie locale': e.categorieLocale?.libelle ,
            }
        });

        this.criteriaData = [{
            'Ref': this.criteria.ref ? this.criteria.ref : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Complement adresse': this.criteria.complementAdresse ? this.criteria.complementAdresse : environment.emptyForExport ,
            'Dernier annee de paiement Min': this.criteria.dernierAnneeDePaiementMin ? this.criteria.dernierAnneeDePaiementMin : environment.emptyForExport ,
            'Dernier annee de paiement Max': this.criteria.dernierAnneeDePaiementMax ? this.criteria.dernierAnneeDePaiementMax : environment.emptyForExport ,
            'Dernier trimestre Min': this.criteria.dernierTrimestreMin ? this.criteria.dernierTrimestreMin : environment.emptyForExport ,
            'Dernier trimestre Max': this.criteria.dernierTrimestreMax ? this.criteria.dernierTrimestreMax : environment.emptyForExport ,
            'Superficie Min': this.criteria.superficieMin ? this.criteria.superficieMin : environment.emptyForExport ,
            'Superficie Max': this.criteria.superficieMax ? this.criteria.superficieMax : environment.emptyForExport ,
        //'Rue': this.criteria.rue?.libelle ? this.criteria.rue?.libelle : environment.emptyForExport ,
        //'Categorie locale': this.criteria.categorieLocale?.libelle ? this.criteria.categorieLocale?.libelle : environment.emptyForExport ,
        }];
      }
}

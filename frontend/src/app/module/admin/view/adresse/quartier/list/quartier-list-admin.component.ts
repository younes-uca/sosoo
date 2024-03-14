import {Component, OnInit} from '@angular/core';
import {QuartierAdminService} from 'src/app/controller/service/admin/adresse/QuartierAdmin.service';
import {QuartierDto} from 'src/app/controller/model/adresse/Quartier.model';
import {QuartierCriteria} from 'src/app/controller/criteria/adresse/QuartierCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-quartier-list-admin',
  templateUrl: './quartier-list-admin.component.html'
})
export class QuartierListAdminComponent extends AbstractListController<QuartierDto, QuartierCriteria, QuartierAdminService>  implements OnInit {

    override fileName = 'Quartier';




    constructor( private quartierService: QuartierAdminService  ) {
        super(quartierService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Quartier').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'libelle', header: 'Libelle'},
        ];
    }





   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Libelle': e.libelle ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        }];
      }
}

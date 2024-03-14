import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CategorieLocaleAdminService} from 'src/app/controller/service/admin/taxe/CategorieLocaleAdmin.service';
import {CategorieLocaleDto} from 'src/app/controller/model/taxe/CategorieLocale.model';
import {CategorieLocaleCriteria} from 'src/app/controller/criteria/taxe/CategorieLocaleCriteria.model';

@Component({
  selector: 'app-categorie-locale-view-admin',
  templateUrl: './categorie-locale-view-admin.component.html'
})
export class CategorieLocaleViewAdminComponent extends AbstractViewController<CategorieLocaleDto, CategorieLocaleCriteria, CategorieLocaleAdminService> implements OnInit {


    constructor(private categorieLocaleService: CategorieLocaleAdminService){
        super(categorieLocaleService);
    }

    ngOnInit(): void {
    }




}

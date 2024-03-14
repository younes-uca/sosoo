import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {LocaleAdminService} from 'src/app/controller/service/admin/adresse/LocaleAdmin.service';
import {LocaleDto} from 'src/app/controller/model/adresse/Locale.model';
import {LocaleCriteria} from 'src/app/controller/criteria/adresse/LocaleCriteria.model';

import {RueDto} from 'src/app/controller/model/adresse/Rue.model';
import {RueAdminService} from 'src/app/controller/service/admin/adresse/RueAdmin.service';
import {CategorieLocaleDto} from 'src/app/controller/model/taxe/CategorieLocale.model';
import {CategorieLocaleAdminService} from 'src/app/controller/service/admin/taxe/CategorieLocaleAdmin.service';
@Component({
  selector: 'app-locale-view-admin',
  templateUrl: './locale-view-admin.component.html'
})
export class LocaleViewAdminComponent extends AbstractViewController<LocaleDto, LocaleCriteria, LocaleAdminService> implements OnInit {


    constructor(private localeService: LocaleAdminService, private rueService: RueAdminService, private categorieLocaleService: CategorieLocaleAdminService){
        super(localeService);
    }

    ngOnInit(): void {
    }


    get rue(): RueDto {
       return this.rueService.item;
    }
    set rue(value: RueDto) {
        this.rueService.item = value;
    }
    get rues(): Array<RueDto> {
       return this.rueService.items;
    }
    set rues(value: Array<RueDto>) {
        this.rueService.items = value;
    }
    get categorieLocale(): CategorieLocaleDto {
       return this.categorieLocaleService.item;
    }
    set categorieLocale(value: CategorieLocaleDto) {
        this.categorieLocaleService.item = value;
    }
    get categorieLocales(): Array<CategorieLocaleDto> {
       return this.categorieLocaleService.items;
    }
    set categorieLocales(value: Array<CategorieLocaleDto>) {
        this.categorieLocaleService.items = value;
    }


}

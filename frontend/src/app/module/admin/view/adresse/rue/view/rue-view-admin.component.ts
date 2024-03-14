import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {RueAdminService} from 'src/app/controller/service/admin/adresse/RueAdmin.service';
import {RueDto} from 'src/app/controller/model/adresse/Rue.model';
import {RueCriteria} from 'src/app/controller/criteria/adresse/RueCriteria.model';

import {QuartierDto} from 'src/app/controller/model/adresse/Quartier.model';
import {QuartierAdminService} from 'src/app/controller/service/admin/adresse/QuartierAdmin.service';
@Component({
  selector: 'app-rue-view-admin',
  templateUrl: './rue-view-admin.component.html'
})
export class RueViewAdminComponent extends AbstractViewController<RueDto, RueCriteria, RueAdminService> implements OnInit {


    constructor(private rueService: RueAdminService, private quartierService: QuartierAdminService){
        super(rueService);
    }

    ngOnInit(): void {
    }


    get quartier(): QuartierDto {
       return this.quartierService.item;
    }
    set quartier(value: QuartierDto) {
        this.quartierService.item = value;
    }
    get quartiers(): Array<QuartierDto> {
       return this.quartierService.items;
    }
    set quartiers(value: Array<QuartierDto>) {
        this.quartierService.items = value;
    }


}

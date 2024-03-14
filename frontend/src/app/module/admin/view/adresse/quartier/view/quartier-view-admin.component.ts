import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {QuartierAdminService} from 'src/app/controller/service/admin/adresse/QuartierAdmin.service';
import {QuartierDto} from 'src/app/controller/model/adresse/Quartier.model';
import {QuartierCriteria} from 'src/app/controller/criteria/adresse/QuartierCriteria.model';

@Component({
  selector: 'app-quartier-view-admin',
  templateUrl: './quartier-view-admin.component.html'
})
export class QuartierViewAdminComponent extends AbstractViewController<QuartierDto, QuartierCriteria, QuartierAdminService> implements OnInit {


    constructor(private quartierService: QuartierAdminService){
        super(quartierService);
    }

    ngOnInit(): void {
    }




}

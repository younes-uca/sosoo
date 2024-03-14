import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {QuartierDto} from 'src/app/controller/model/adresse/Quartier.model';
import {QuartierCriteria} from 'src/app/controller/criteria/adresse/QuartierCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class QuartierAdminService extends AbstractService<QuartierDto, QuartierCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/quartier/');
    }

    public constrcutDto(): QuartierDto {
        return new QuartierDto();
    }

    public constrcutCriteria(): QuartierCriteria {
        return new QuartierCriteria();
    }
}

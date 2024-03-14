import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {CategorieLocaleDto} from 'src/app/controller/model/taxe/CategorieLocale.model';
import {CategorieLocaleCriteria} from 'src/app/controller/criteria/taxe/CategorieLocaleCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class CategorieLocaleAdminService extends AbstractService<CategorieLocaleDto, CategorieLocaleCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/categorieLocale/');
    }

    public constrcutDto(): CategorieLocaleDto {
        return new CategorieLocaleDto();
    }

    public constrcutCriteria(): CategorieLocaleCriteria {
        return new CategorieLocaleCriteria();
    }
}

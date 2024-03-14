import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {LocaleDto} from 'src/app/controller/model/adresse/Locale.model';
import {LocaleCriteria} from 'src/app/controller/criteria/adresse/LocaleCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class LocaleAdminService extends AbstractService<LocaleDto, LocaleCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/locale/');
    }

    public constrcutDto(): LocaleDto {
        return new LocaleDto();
    }

    public constrcutCriteria(): LocaleCriteria {
        return new LocaleCriteria();
    }
}

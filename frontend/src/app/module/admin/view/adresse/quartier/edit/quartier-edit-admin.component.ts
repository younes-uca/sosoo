import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {QuartierAdminService} from 'src/app/controller/service/admin/adresse/QuartierAdmin.service';
import {QuartierDto} from 'src/app/controller/model/adresse/Quartier.model';
import {QuartierCriteria} from 'src/app/controller/criteria/adresse/QuartierCriteria.model';



@Component({
  selector: 'app-quartier-edit-admin',
  templateUrl: './quartier-edit-admin.component.html'
})
export class QuartierEditAdminComponent extends AbstractEditController<QuartierDto, QuartierCriteria, QuartierAdminService>   implements OnInit {


    private _validQuartierCode = true;
    private _validQuartierLibelle = true;




    constructor( private quartierService: QuartierAdminService ) {
        super(quartierService);
    }

    ngOnInit(): void {
    }


    public override setValidation(value: boolean){
        this.validQuartierCode = value;
        this.validQuartierLibelle = value;
        }
    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateQuartierCode();
        this.validateQuartierLibelle();
    }
    public validateQuartierCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validQuartierCode = false;
        } else {
            this.validQuartierCode = true;
        }
    }
    public validateQuartierLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validQuartierLibelle = false;
        } else {
            this.validQuartierLibelle = true;
        }
    }






    get validQuartierCode(): boolean {
        return this._validQuartierCode;
    }
    set validQuartierCode(value: boolean) {
        this._validQuartierCode = value;
    }
    get validQuartierLibelle(): boolean {
        return this._validQuartierLibelle;
    }
    set validQuartierLibelle(value: boolean) {
        this._validQuartierLibelle = value;
    }

}

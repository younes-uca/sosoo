import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {RueAdminService} from 'src/app/controller/service/admin/adresse/RueAdmin.service';
import {RueDto} from 'src/app/controller/model/adresse/Rue.model';
import {RueCriteria} from 'src/app/controller/criteria/adresse/RueCriteria.model';
import {QuartierDto} from 'src/app/controller/model/adresse/Quartier.model';
import {QuartierAdminService} from 'src/app/controller/service/admin/adresse/QuartierAdmin.service';
@Component({
  selector: 'app-rue-create-admin',
  templateUrl: './rue-create-admin.component.html'
})
export class RueCreateAdminComponent extends AbstractCreateController<RueDto, RueCriteria, RueAdminService>  implements OnInit {



   private _validRueCode = true;
   private _validRueLibelle = true;
    private _validQuartierCode = true;
    private _validQuartierLibelle = true;

    constructor( private rueService: RueAdminService , private quartierService: QuartierAdminService) {
        super(rueService);
    }

    ngOnInit(): void {
        this.quartier = new QuartierDto();
        this.quartierService.findAll().subscribe((data) => this.quartiers = data);
    }





    public override setValidation(value: boolean){
        this.validRueCode = value;
        this.validRueLibelle = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateRueCode();
        this.validateRueLibelle();
    }

    public validateRueCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validRueCode = false;
        } else {
            this.validRueCode = true;
        }
    }
    public validateRueLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validRueLibelle = false;
        } else {
            this.validRueLibelle = true;
        }
    }


    public async openCreateQuartier(quartier: string) {
    const isPermistted = await this.roleService.isPermitted('Quartier', 'add');
    if(isPermistted) {
         this.quartier = new QuartierDto();
         this.createQuartierDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
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
    get createQuartierDialog(): boolean {
       return this.quartierService.createDialog;
    }
    set createQuartierDialog(value: boolean) {
        this.quartierService.createDialog= value;
    }



    get validRueCode(): boolean {
        return this._validRueCode;
    }

    set validRueCode(value: boolean) {
         this._validRueCode = value;
    }
    get validRueLibelle(): boolean {
        return this._validRueLibelle;
    }

    set validRueLibelle(value: boolean) {
         this._validRueLibelle = value;
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

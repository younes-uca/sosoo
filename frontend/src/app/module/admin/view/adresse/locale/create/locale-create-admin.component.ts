import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {LocaleAdminService} from 'src/app/controller/service/admin/adresse/LocaleAdmin.service';
import {LocaleDto} from 'src/app/controller/model/adresse/Locale.model';
import {LocaleCriteria} from 'src/app/controller/criteria/adresse/LocaleCriteria.model';
import {RueDto} from 'src/app/controller/model/adresse/Rue.model';
import {RueAdminService} from 'src/app/controller/service/admin/adresse/RueAdmin.service';
import {CategorieLocaleDto} from 'src/app/controller/model/taxe/CategorieLocale.model';
import {CategorieLocaleAdminService} from 'src/app/controller/service/admin/taxe/CategorieLocaleAdmin.service';
@Component({
  selector: 'app-locale-create-admin',
  templateUrl: './locale-create-admin.component.html'
})
export class LocaleCreateAdminComponent extends AbstractCreateController<LocaleDto, LocaleCriteria, LocaleAdminService>  implements OnInit {



   private _validLocaleRef = true;
   private _validLocaleLibelle = true;
    private _validRueCode = true;
    private _validRueLibelle = true;
    private _validCategorieLocaleCode = true;
    private _validCategorieLocaleLibelle = true;

    constructor( private localeService: LocaleAdminService , private rueService: RueAdminService, private categorieLocaleService: CategorieLocaleAdminService) {
        super(localeService);
    }

    ngOnInit(): void {
        this.rue = new RueDto();
        this.rueService.findAll().subscribe((data) => this.rues = data);
        this.categorieLocale = new CategorieLocaleDto();
        this.categorieLocaleService.findAll().subscribe((data) => this.categorieLocales = data);
    }





    public override setValidation(value: boolean){
        this.validLocaleRef = value;
        this.validLocaleLibelle = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateLocaleRef();
        this.validateLocaleLibelle();
    }

    public validateLocaleRef(){
        if (this.stringUtilService.isEmpty(this.item.ref)) {
        this.errorMessages.push('Ref non valide');
        this.validLocaleRef = false;
        } else {
            this.validLocaleRef = true;
        }
    }
    public validateLocaleLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validLocaleLibelle = false;
        } else {
            this.validLocaleLibelle = true;
        }
    }


    public async openCreateRue(rue: string) {
    const isPermistted = await this.roleService.isPermitted('Rue', 'add');
    if(isPermistted) {
         this.rue = new RueDto();
         this.createRueDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
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
    get createRueDialog(): boolean {
       return this.rueService.createDialog;
    }
    set createRueDialog(value: boolean) {
        this.rueService.createDialog= value;
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
    get createCategorieLocaleDialog(): boolean {
       return this.categorieLocaleService.createDialog;
    }
    set createCategorieLocaleDialog(value: boolean) {
        this.categorieLocaleService.createDialog= value;
    }



    get validLocaleRef(): boolean {
        return this._validLocaleRef;
    }

    set validLocaleRef(value: boolean) {
         this._validLocaleRef = value;
    }
    get validLocaleLibelle(): boolean {
        return this._validLocaleLibelle;
    }

    set validLocaleLibelle(value: boolean) {
         this._validLocaleLibelle = value;
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
    get validCategorieLocaleCode(): boolean {
        return this._validCategorieLocaleCode;
    }
    set validCategorieLocaleCode(value: boolean) {
        this._validCategorieLocaleCode = value;
    }
    get validCategorieLocaleLibelle(): boolean {
        return this._validCategorieLocaleLibelle;
    }
    set validCategorieLocaleLibelle(value: boolean) {
        this._validCategorieLocaleLibelle = value;
    }


}

package  ma.zs.univ.ws.dto.adresse;

import ma.zs.univ.zynerator.audit.Log;
import ma.zs.univ.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


import ma.zs.univ.ws.dto.taxe.CategorieLocaleDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocaleDto  extends AuditBaseDto {

    private String ref  ;
    private String libelle  ;
    private String complementAdresse  ;
    private Integer dernierAnneeDePaiement  = 0 ;
    private Integer dernierTrimestre  = 0 ;
    private BigDecimal superficie  ;

    private RueDto rue ;
    private CategorieLocaleDto categorieLocale ;



    public LocaleDto(){
        super();
    }



    @Log
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }

    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getComplementAdresse(){
        return this.complementAdresse;
    }
    public void setComplementAdresse(String complementAdresse){
        this.complementAdresse = complementAdresse;
    }

    @Log
    public Integer getDernierAnneeDePaiement(){
        return this.dernierAnneeDePaiement;
    }
    public void setDernierAnneeDePaiement(Integer dernierAnneeDePaiement){
        this.dernierAnneeDePaiement = dernierAnneeDePaiement;
    }

    @Log
    public Integer getDernierTrimestre(){
        return this.dernierTrimestre;
    }
    public void setDernierTrimestre(Integer dernierTrimestre){
        this.dernierTrimestre = dernierTrimestre;
    }

    @Log
    public BigDecimal getSuperficie(){
        return this.superficie;
    }
    public void setSuperficie(BigDecimal superficie){
        this.superficie = superficie;
    }


    public RueDto getRue(){
        return this.rue;
    }

    public void setRue(RueDto rue){
        this.rue = rue;
    }
    public CategorieLocaleDto getCategorieLocale(){
        return this.categorieLocale;
    }

    public void setCategorieLocale(CategorieLocaleDto categorieLocale){
        this.categorieLocale = categorieLocale;
    }






}

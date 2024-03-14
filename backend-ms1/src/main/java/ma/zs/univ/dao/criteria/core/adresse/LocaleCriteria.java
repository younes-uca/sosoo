package  ma.zs.univ.dao.criteria.core.adresse;


import ma.zs.univ.dao.criteria.core.taxe.CategorieLocaleCriteria;

import ma.zs.univ.zynerator.criteria.BaseCriteria;
import java.util.List;

public class LocaleCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String libelle;
    private String libelleLike;
    private String complementAdresse;
    private String complementAdresseLike;
    private String dernierAnneeDePaiement;
    private String dernierAnneeDePaiementMin;
    private String dernierAnneeDePaiementMax;
    private String dernierTrimestre;
    private String dernierTrimestreMin;
    private String dernierTrimestreMax;
    private String superficie;
    private String superficieMin;
    private String superficieMax;

    private RueCriteria rue ;
    private List<RueCriteria> rues ;
    private CategorieLocaleCriteria categorieLocale ;
    private List<CategorieLocaleCriteria> categorieLocales ;


    public LocaleCriteria(){}

    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public String getRefLike(){
        return this.refLike;
    }
    public void setRefLike(String refLike){
        this.refLike = refLike;
    }

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public String getComplementAdresse(){
        return this.complementAdresse;
    }
    public void setComplementAdresse(String complementAdresse){
        this.complementAdresse = complementAdresse;
    }
    public String getComplementAdresseLike(){
        return this.complementAdresseLike;
    }
    public void setComplementAdresseLike(String complementAdresseLike){
        this.complementAdresseLike = complementAdresseLike;
    }

    public String getDernierAnneeDePaiement(){
        return this.dernierAnneeDePaiement;
    }
    public void setDernierAnneeDePaiement(String dernierAnneeDePaiement){
        this.dernierAnneeDePaiement = dernierAnneeDePaiement;
    }   
    public String getDernierAnneeDePaiementMin(){
        return this.dernierAnneeDePaiementMin;
    }
    public void setDernierAnneeDePaiementMin(String dernierAnneeDePaiementMin){
        this.dernierAnneeDePaiementMin = dernierAnneeDePaiementMin;
    }
    public String getDernierAnneeDePaiementMax(){
        return this.dernierAnneeDePaiementMax;
    }
    public void setDernierAnneeDePaiementMax(String dernierAnneeDePaiementMax){
        this.dernierAnneeDePaiementMax = dernierAnneeDePaiementMax;
    }
      
    public String getDernierTrimestre(){
        return this.dernierTrimestre;
    }
    public void setDernierTrimestre(String dernierTrimestre){
        this.dernierTrimestre = dernierTrimestre;
    }   
    public String getDernierTrimestreMin(){
        return this.dernierTrimestreMin;
    }
    public void setDernierTrimestreMin(String dernierTrimestreMin){
        this.dernierTrimestreMin = dernierTrimestreMin;
    }
    public String getDernierTrimestreMax(){
        return this.dernierTrimestreMax;
    }
    public void setDernierTrimestreMax(String dernierTrimestreMax){
        this.dernierTrimestreMax = dernierTrimestreMax;
    }
      
    public String getSuperficie(){
        return this.superficie;
    }
    public void setSuperficie(String superficie){
        this.superficie = superficie;
    }   
    public String getSuperficieMin(){
        return this.superficieMin;
    }
    public void setSuperficieMin(String superficieMin){
        this.superficieMin = superficieMin;
    }
    public String getSuperficieMax(){
        return this.superficieMax;
    }
    public void setSuperficieMax(String superficieMax){
        this.superficieMax = superficieMax;
    }
      

    public RueCriteria getRue(){
        return this.rue;
    }

    public void setRue(RueCriteria rue){
        this.rue = rue;
    }
    public List<RueCriteria> getRues(){
        return this.rues;
    }

    public void setRues(List<RueCriteria> rues){
        this.rues = rues;
    }
    public CategorieLocaleCriteria getCategorieLocale(){
        return this.categorieLocale;
    }

    public void setCategorieLocale(CategorieLocaleCriteria categorieLocale){
        this.categorieLocale = categorieLocale;
    }
    public List<CategorieLocaleCriteria> getCategorieLocales(){
        return this.categorieLocales;
    }

    public void setCategorieLocales(List<CategorieLocaleCriteria> categorieLocales){
        this.categorieLocales = categorieLocales;
    }
}

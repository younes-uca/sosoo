package  ma.zs.univ.dao.specification.core.adresse;

import ma.zs.univ.dao.criteria.core.adresse.LocaleCriteria;
import ma.zs.univ.bean.core.adresse.Locale;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class LocaleSpecification extends  AbstractSpecification<LocaleCriteria, Locale>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("complementAdresse", criteria.getComplementAdresse(),criteria.getComplementAdresseLike());
        addPredicateInt("dernierAnneeDePaiement", criteria.getDernierAnneeDePaiement(), criteria.getDernierAnneeDePaiementMin(), criteria.getDernierAnneeDePaiementMax());
        addPredicateInt("dernierTrimestre", criteria.getDernierTrimestre(), criteria.getDernierTrimestreMin(), criteria.getDernierTrimestreMax());
        addPredicateBigDecimal("superficie", criteria.getSuperficie(), criteria.getSuperficieMin(), criteria.getSuperficieMax());
        addPredicateFk("rue","id", criteria.getRue()==null?null:criteria.getRue().getId());
        addPredicateFk("rue","id", criteria.getRues());
        addPredicateFk("rue","code", criteria.getRue()==null?null:criteria.getRue().getCode());
        addPredicateFk("categorieLocale","id", criteria.getCategorieLocale()==null?null:criteria.getCategorieLocale().getId());
        addPredicateFk("categorieLocale","id", criteria.getCategorieLocales());
        addPredicateFk("categorieLocale","code", criteria.getCategorieLocale()==null?null:criteria.getCategorieLocale().getCode());
    }

    public LocaleSpecification(LocaleCriteria criteria) {
        super(criteria);
    }

    public LocaleSpecification(LocaleCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

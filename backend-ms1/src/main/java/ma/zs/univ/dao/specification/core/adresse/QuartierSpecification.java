package  ma.zs.univ.dao.specification.core.adresse;

import ma.zs.univ.dao.criteria.core.adresse.QuartierCriteria;
import ma.zs.univ.bean.core.adresse.Quartier;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class QuartierSpecification extends  AbstractSpecification<QuartierCriteria, Quartier>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public QuartierSpecification(QuartierCriteria criteria) {
        super(criteria);
    }

    public QuartierSpecification(QuartierCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

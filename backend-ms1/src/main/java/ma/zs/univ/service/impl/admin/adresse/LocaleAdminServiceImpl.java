package ma.zs.univ.service.impl.admin.adresse;


import ma.zs.univ.bean.core.adresse.Locale;
import ma.zs.univ.dao.criteria.core.adresse.LocaleCriteria;
import ma.zs.univ.dao.facade.core.adresse.LocaleDao;
import ma.zs.univ.dao.specification.core.adresse.LocaleSpecification;
import ma.zs.univ.service.facade.admin.adresse.LocaleAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.univ.service.facade.admin.adresse.RueAdminService ;
import ma.zs.univ.bean.core.adresse.Rue ;
import ma.zs.univ.service.facade.admin.taxe.CategorieLocaleAdminService ;
import ma.zs.univ.bean.core.taxe.CategorieLocale ;

import java.util.List;
@Service
public class LocaleAdminServiceImpl extends AbstractServiceImpl<Locale, LocaleCriteria, LocaleDao> implements LocaleAdminService {






    public Locale findByReferenceEntity(Locale t){
        return  dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(Locale t){
        if( t != null) {
            t.setRue(rueService.findOrSave(t.getRue()));
            t.setCategorieLocale(categorieLocaleService.findOrSave(t.getCategorieLocale()));
        }
    }

    public List<Locale> findByRueId(Long id){
        return dao.findByRueId(id);
    }
    public int deleteByRueId(Long id){
        return dao.deleteByRueId(id);
    }
    public long countByRueCode(String code){
        return dao.countByRueCode(code);
    }
    public List<Locale> findByCategorieLocaleId(Long id){
        return dao.findByCategorieLocaleId(id);
    }
    public int deleteByCategorieLocaleId(Long id){
        return dao.deleteByCategorieLocaleId(id);
    }
    public long countByCategorieLocaleCode(String code){
        return dao.countByCategorieLocaleCode(code);
    }

    public List<Locale> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Locale.class, LocaleSpecification.class);
    }


    @Autowired
    private RueAdminService rueService ;
    @Autowired
    private CategorieLocaleAdminService categorieLocaleService ;

    public LocaleAdminServiceImpl(LocaleDao dao) {
        super(dao);
    }

}

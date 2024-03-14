package ma.zs.univ.service.facade.admin.adresse;

import java.util.List;
import ma.zs.univ.bean.core.adresse.Locale;
import ma.zs.univ.dao.criteria.core.adresse.LocaleCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface LocaleAdminService extends  IService<Locale,LocaleCriteria>  {

    List<Locale> findByRueId(Long id);
    int deleteByRueId(Long id);
    long countByRueCode(String code);
    List<Locale> findByCategorieLocaleId(Long id);
    int deleteByCategorieLocaleId(Long id);
    long countByCategorieLocaleCode(String code);




}

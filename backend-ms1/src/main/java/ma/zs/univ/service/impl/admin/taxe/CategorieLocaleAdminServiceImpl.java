package ma.zs.univ.service.impl.admin.taxe;


import ma.zs.univ.bean.core.taxe.CategorieLocale;
import ma.zs.univ.dao.criteria.core.taxe.CategorieLocaleCriteria;
import ma.zs.univ.dao.facade.core.taxe.CategorieLocaleDao;
import ma.zs.univ.dao.specification.core.taxe.CategorieLocaleSpecification;
import ma.zs.univ.service.facade.admin.taxe.CategorieLocaleAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class CategorieLocaleAdminServiceImpl extends AbstractServiceImpl<CategorieLocale, CategorieLocaleCriteria, CategorieLocaleDao> implements CategorieLocaleAdminService {






    public CategorieLocale findByReferenceEntity(CategorieLocale t){
        return  dao.findByCode(t.getCode());
    }


    public List<CategorieLocale> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(CategorieLocale.class, CategorieLocaleSpecification.class);
    }



    public CategorieLocaleAdminServiceImpl(CategorieLocaleDao dao) {
        super(dao);
    }

}

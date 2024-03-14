package ma.zs.univ.service.impl.admin.adresse;


import ma.zs.univ.bean.core.adresse.Quartier;
import ma.zs.univ.dao.criteria.core.adresse.QuartierCriteria;
import ma.zs.univ.dao.facade.core.adresse.QuartierDao;
import ma.zs.univ.dao.specification.core.adresse.QuartierSpecification;
import ma.zs.univ.service.facade.admin.adresse.QuartierAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class QuartierAdminServiceImpl extends AbstractServiceImpl<Quartier, QuartierCriteria, QuartierDao> implements QuartierAdminService {






    public Quartier findByReferenceEntity(Quartier t){
        return  dao.findByCode(t.getCode());
    }


    public List<Quartier> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Quartier.class, QuartierSpecification.class);
    }



    public QuartierAdminServiceImpl(QuartierDao dao) {
        super(dao);
    }

}

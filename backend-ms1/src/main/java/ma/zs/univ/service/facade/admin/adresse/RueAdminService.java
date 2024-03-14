package ma.zs.univ.service.facade.admin.adresse;

import java.util.List;
import ma.zs.univ.bean.core.adresse.Rue;
import ma.zs.univ.dao.criteria.core.adresse.RueCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface RueAdminService extends  IService<Rue,RueCriteria>  {

    List<Rue> findByQuartierId(Long id);
    int deleteByQuartierId(Long id);
    long countByQuartierCode(String code);




}

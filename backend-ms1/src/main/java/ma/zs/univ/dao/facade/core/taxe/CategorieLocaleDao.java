package ma.zs.univ.dao.facade.core.taxe;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.taxe.CategorieLocale;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.taxe.CategorieLocale;
import java.util.List;


@Repository
public interface CategorieLocaleDao extends AbstractRepository<CategorieLocale,Long>  {
    CategorieLocale findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW CategorieLocale(item.id,item.libelle) FROM CategorieLocale item")
    List<CategorieLocale> findAllOptimized();

}

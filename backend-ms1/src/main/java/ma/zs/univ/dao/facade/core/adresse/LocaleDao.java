package ma.zs.univ.dao.facade.core.adresse;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.adresse.Locale;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.adresse.Locale;
import java.util.List;


@Repository
public interface LocaleDao extends AbstractRepository<Locale,Long>  {
    Locale findByRef(String ref);
    int deleteByRef(String ref);

    List<Locale> findByRueId(Long id);
    int deleteByRueId(Long id);
    long countByRueCode(String code);
    List<Locale> findByCategorieLocaleId(Long id);
    int deleteByCategorieLocaleId(Long id);
    long countByCategorieLocaleCode(String code);

    @Query("SELECT NEW Locale(item.id,item.libelle) FROM Locale item")
    List<Locale> findAllOptimized();

}

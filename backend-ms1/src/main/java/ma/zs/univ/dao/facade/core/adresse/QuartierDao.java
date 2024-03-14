package ma.zs.univ.dao.facade.core.adresse;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.adresse.Quartier;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.adresse.Quartier;
import java.util.List;


@Repository
public interface QuartierDao extends AbstractRepository<Quartier,Long>  {
    Quartier findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Quartier(item.id,item.libelle) FROM Quartier item")
    List<Quartier> findAllOptimized();

}

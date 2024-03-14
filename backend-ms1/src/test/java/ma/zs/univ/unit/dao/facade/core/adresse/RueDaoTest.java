package ma.zs.univ.unit.dao.facade.core.adresse;

import ma.zs.univ.bean.core.adresse.Rue;
import ma.zs.univ.dao.facade.core.adresse.RueDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class RueDaoTest {

@Autowired
    private RueDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        Rue entity = new Rue();
        entity.setCode(code);
        underTest.save(entity);
        Rue loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        Rue entity = new Rue();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        Rue loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Rue entity = new Rue();
        entity.setId(id);
        underTest.save(entity);
        Rue loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Rue entity = new Rue();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Rue loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Rue> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Rue> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Rue given = constructSample(1);
        Rue saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Rue constructSample(int i) {
		Rue given = new Rue();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        given.setQuartier(new Quartier(1L));
        return given;
    }

}

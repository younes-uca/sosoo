package ma.zs.univ.unit.dao.facade.core.adresse;

import ma.zs.univ.bean.core.adresse.Quartier;
import ma.zs.univ.dao.facade.core.adresse.QuartierDao;

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
public class QuartierDaoTest {

@Autowired
    private QuartierDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        Quartier entity = new Quartier();
        entity.setCode(code);
        underTest.save(entity);
        Quartier loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        Quartier entity = new Quartier();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        Quartier loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Quartier entity = new Quartier();
        entity.setId(id);
        underTest.save(entity);
        Quartier loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Quartier entity = new Quartier();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Quartier loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Quartier> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Quartier> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Quartier given = constructSample(1);
        Quartier saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Quartier constructSample(int i) {
		Quartier given = new Quartier();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}

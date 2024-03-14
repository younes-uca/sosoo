package ma.zs.univ.unit.dao.facade.core.taxe;

import ma.zs.univ.bean.core.taxe.CategorieLocale;
import ma.zs.univ.dao.facade.core.taxe.CategorieLocaleDao;

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
public class CategorieLocaleDaoTest {

@Autowired
    private CategorieLocaleDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        CategorieLocale entity = new CategorieLocale();
        entity.setCode(code);
        underTest.save(entity);
        CategorieLocale loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        CategorieLocale entity = new CategorieLocale();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        CategorieLocale loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        CategorieLocale entity = new CategorieLocale();
        entity.setId(id);
        underTest.save(entity);
        CategorieLocale loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        CategorieLocale entity = new CategorieLocale();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        CategorieLocale loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<CategorieLocale> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<CategorieLocale> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        CategorieLocale given = constructSample(1);
        CategorieLocale saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private CategorieLocale constructSample(int i) {
		CategorieLocale given = new CategorieLocale();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}

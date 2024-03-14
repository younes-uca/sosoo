package ma.zs.univ.unit.dao.facade.core.adresse;

import ma.zs.univ.bean.core.adresse.Locale;
import ma.zs.univ.dao.facade.core.adresse.LocaleDao;

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
public class LocaleDaoTest {

@Autowired
    private LocaleDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        Locale entity = new Locale();
        entity.setRef(ref);
        underTest.save(entity);
        Locale loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        Locale entity = new Locale();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        Locale loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Locale entity = new Locale();
        entity.setId(id);
        underTest.save(entity);
        Locale loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Locale entity = new Locale();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Locale loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Locale> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Locale> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Locale given = constructSample(1);
        Locale saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Locale constructSample(int i) {
		Locale given = new Locale();
        given.setRef("ref-"+i);
        given.setLibelle("libelle-"+i);
        given.setComplementAdresse("complementAdresse-"+i);
        given.setDernierAnneeDePaiement(i);
        given.setDernierTrimestre(i);
        given.setSuperficie(BigDecimal.TEN);
        given.setRue(new Rue(1L));
        given.setCategorieLocale(new CategorieLocale(1L));
        return given;
    }

}

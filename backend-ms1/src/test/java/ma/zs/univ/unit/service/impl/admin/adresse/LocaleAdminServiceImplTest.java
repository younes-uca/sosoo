package ma.zs.univ.unit.service.impl.admin.adresse;

import ma.zs.univ.bean.core.adresse.Locale;
import ma.zs.univ.dao.facade.core.adresse.LocaleDao;
import ma.zs.univ.service.impl.admin.adresse.LocaleAdminServiceImpl;

import ma.zs.univ.bean.core.adresse.Rue ;
import ma.zs.univ.bean.core.taxe.CategorieLocale ;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;



import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class LocaleAdminServiceImplTest {

    @Mock
    private LocaleDao repository;
    private AutoCloseable autoCloseable;
    private LocaleAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new LocaleAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllLocale() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveLocale() {
        // Given
        Locale toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteLocale() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetLocaleById() {
        // Given
        Long idToRetrieve = 1L; // Example Locale ID to retrieve
        Locale expected = new Locale(); // You need to replace Locale with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Locale result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Locale constructSample(int i) {
		Locale given = new Locale();
        given.setId(id);
        given.setRef("ref-"+i);
        given.setRef(ref);
        given.setLibelle("libelle-"+i);
        given.setLibelle(libelle);
        given.setComplementAdresse("complementAdresse-"+i);
        given.setComplementAdresse(complementAdresse);
        given.setDernierAnneeDePaiement(i);
        given.setDernierAnneeDePaiement(dernierAnneeDePaiement);
        given.setDernierTrimestre(i);
        given.setDernierTrimestre(dernierTrimestre);
        given.setSuperficie(BigDecimal.TEN);
        given.setSuperficie(superficie);
        given.setRue(new Rue(1L));
        given.setRue(rue);
        given.setCategorieLocale(new CategorieLocale(1L));
        given.setCategorieLocale(categorieLocale);
        return given;
    }

}

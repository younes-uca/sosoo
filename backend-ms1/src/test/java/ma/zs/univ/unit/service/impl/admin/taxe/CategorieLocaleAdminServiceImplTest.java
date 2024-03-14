package ma.zs.univ.unit.service.impl.admin.taxe;

import ma.zs.univ.bean.core.taxe.CategorieLocale;
import ma.zs.univ.dao.facade.core.taxe.CategorieLocaleDao;
import ma.zs.univ.service.impl.admin.taxe.CategorieLocaleAdminServiceImpl;

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
class CategorieLocaleAdminServiceImplTest {

    @Mock
    private CategorieLocaleDao repository;
    private AutoCloseable autoCloseable;
    private CategorieLocaleAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CategorieLocaleAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllCategorieLocale() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveCategorieLocale() {
        // Given
        CategorieLocale toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteCategorieLocale() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetCategorieLocaleById() {
        // Given
        Long idToRetrieve = 1L; // Example CategorieLocale ID to retrieve
        CategorieLocale expected = new CategorieLocale(); // You need to replace CategorieLocale with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        CategorieLocale result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private CategorieLocale constructSample(int i) {
		CategorieLocale given = new CategorieLocale();
        given.setId(id);
        given.setCode("code-"+i);
        given.setCode(code);
        given.setLibelle("libelle-"+i);
        given.setLibelle(libelle);
        return given;
    }

}

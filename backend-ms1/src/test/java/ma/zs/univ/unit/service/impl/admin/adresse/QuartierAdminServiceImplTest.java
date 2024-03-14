package ma.zs.univ.unit.service.impl.admin.adresse;

import ma.zs.univ.bean.core.adresse.Quartier;
import ma.zs.univ.dao.facade.core.adresse.QuartierDao;
import ma.zs.univ.service.impl.admin.adresse.QuartierAdminServiceImpl;

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
class QuartierAdminServiceImplTest {

    @Mock
    private QuartierDao repository;
    private AutoCloseable autoCloseable;
    private QuartierAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new QuartierAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllQuartier() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveQuartier() {
        // Given
        Quartier toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteQuartier() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetQuartierById() {
        // Given
        Long idToRetrieve = 1L; // Example Quartier ID to retrieve
        Quartier expected = new Quartier(); // You need to replace Quartier with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Quartier result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Quartier constructSample(int i) {
		Quartier given = new Quartier();
        given.setId(id);
        given.setCode("code-"+i);
        given.setCode(code);
        given.setLibelle("libelle-"+i);
        given.setLibelle(libelle);
        return given;
    }

}

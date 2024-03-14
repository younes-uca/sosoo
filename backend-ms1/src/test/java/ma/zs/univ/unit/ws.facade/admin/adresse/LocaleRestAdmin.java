package ma.zs.univ.unit.ws.facade.admin.adresse;

import ma.zs.univ.bean.core.adresse.Locale;
import ma.zs.univ.service.impl.admin.adresse.LocaleAdminServiceImpl;
import ma.zs.univ.ws.converter.adresse.LocaleConverter;
import ma.zs.univ.ws.dto.adresse.LocaleDto;
import ma.zs.univ.ws.facade.admin.adresse.LocaleRestAdmin;
import org.aspectj.lang.annotation.Before;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LocaleRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private LocaleAdminServiceImpl service;
    @Mock
    private LocaleConverter converter;

    @InjectMocks
    private LocaleRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllLocaleTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<LocaleDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<LocaleDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveLocaleTest() throws Exception {
        // Mock data
        LocaleDto requestDto = new LocaleDto();
        Locale entity = new Locale();
        Locale saved = new Locale();
        LocaleDto savedDto = new LocaleDto();

        // Mock the converter to return the locale object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved locale DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<LocaleDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        LocaleDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved locale DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getComplementAdresse(), responseBody.getComplementAdresse());
        assertEquals(savedDto.getDernierAnneeDePaiement(), responseBody.getDernierAnneeDePaiement());
        assertEquals(savedDto.getDernierTrimestre(), responseBody.getDernierTrimestre());
        assertEquals(savedDto.getSuperficie(), responseBody.getSuperficie());
    }

}

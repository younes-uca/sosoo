package ma.zs.univ.unit.ws.facade.admin.taxe;

import ma.zs.univ.bean.core.taxe.CategorieLocale;
import ma.zs.univ.service.impl.admin.taxe.CategorieLocaleAdminServiceImpl;
import ma.zs.univ.ws.converter.taxe.CategorieLocaleConverter;
import ma.zs.univ.ws.dto.taxe.CategorieLocaleDto;
import ma.zs.univ.ws.facade.admin.taxe.CategorieLocaleRestAdmin;
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
public class CategorieLocaleRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private CategorieLocaleAdminServiceImpl service;
    @Mock
    private CategorieLocaleConverter converter;

    @InjectMocks
    private CategorieLocaleRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllCategorieLocaleTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<CategorieLocaleDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<CategorieLocaleDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveCategorieLocaleTest() throws Exception {
        // Mock data
        CategorieLocaleDto requestDto = new CategorieLocaleDto();
        CategorieLocale entity = new CategorieLocale();
        CategorieLocale saved = new CategorieLocale();
        CategorieLocaleDto savedDto = new CategorieLocaleDto();

        // Mock the converter to return the categorieLocale object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved categorieLocale DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<CategorieLocaleDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        CategorieLocaleDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved categorieLocale DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
    }

}

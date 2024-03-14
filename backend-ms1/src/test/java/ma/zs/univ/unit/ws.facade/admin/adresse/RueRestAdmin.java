package ma.zs.univ.unit.ws.facade.admin.adresse;

import ma.zs.univ.bean.core.adresse.Rue;
import ma.zs.univ.service.impl.admin.adresse.RueAdminServiceImpl;
import ma.zs.univ.ws.converter.adresse.RueConverter;
import ma.zs.univ.ws.dto.adresse.RueDto;
import ma.zs.univ.ws.facade.admin.adresse.RueRestAdmin;
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
public class RueRestAdmin {

    private MockMvc mockMvc;

    @Mock
    private RueAdminServiceImpl service;
    @Mock
    private RueConverter converter;

    @InjectMocks
    private RueRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllRueTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<RueDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<RueDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveRueTest() throws Exception {
        // Mock data
        RueDto requestDto = new RueDto();
        Rue entity = new Rue();
        Rue saved = new Rue();
        RueDto savedDto = new RueDto();

        // Mock the converter to return the rue object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved rue DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<RueDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        RueDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved rue DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
    }

}

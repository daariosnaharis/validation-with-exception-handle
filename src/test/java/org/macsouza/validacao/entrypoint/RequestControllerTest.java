package org.macsouza.validacao.entrypoint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = RequestController.class)
@WithMockUser
public class RequestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Testa campo1 vazio")
    public void verificarCampo1Vazio() throws Exception {

        String requestBody = "{\"campo1\":\"\",\"campo2\":\"valor 2\",\"document\":\"12345678901234\"}";
        String endpoint = "/test";
        String valorEsperado = "{\"code\":\"BAD_REQUEST\",\"title\":\"Campos obrigatórios\",\"detail\":\"Campo1 Não pode ser branco!\"}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(endpoint)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        String responseBody = response.getContentAsString(Charset.forName("utf-8"));

        // Verificando se é um RC 400
        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());

        // Verificando o retorno
        assertEquals(valorEsperado, responseBody);

    }

}
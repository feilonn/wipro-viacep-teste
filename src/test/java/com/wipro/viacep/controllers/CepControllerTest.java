package com.wipro.viacep.controllers;

import com.wipro.viacep.DTO.CepDTO;
import com.wipro.viacep.models.CepModel;
import com.wipro.viacep.models.FreteModel;
import com.wipro.viacep.services.CepService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CepControllerTest {

    @Test
    public void enderecoWithFrete_deve_retornar_frete() {
        CepDTO cepDTO = CepDTO.builder().cep("01001000").build();
        FreteModel freteModel = FreteModel.builder()
                .cep("01001000")
                .rua("Praça da Sé")
                .bairro("Sé")
                .cidade("São Paulo")
                .estado("SP")
                .frete(7.85)
                .build();
        CepService cepService = new CepService();
        CepController cepController = new CepController();
        cepController.cepService = cepService;

        ResponseEntity<FreteModel> response = cepController.enderecoWithFrete(cepDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(freteModel.getCep(), response.getBody().getCep().replaceAll("[-\\s]+", ""));
    }
}

package com.wipro.viacep.services;

import com.wipro.viacep.DTO.CepDTO;
import com.wipro.viacep.exceptions.NotFoundException;
import com.wipro.viacep.models.CepModel;
import com.wipro.viacep.models.FreteModel;
import com.wipro.viacep.utils.HelperFunctions;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CepService {
    private FreteModel buildFreteModel (CepModel cepModel) {
        Double frete = HelperFunctions.getFreteByRegiaoEstado(cepModel.getUf());
        double freteFormatado = new BigDecimal(frete).setScale(2, RoundingMode.HALF_UP).doubleValue();

        FreteModel freteModel = FreteModel.builder()
                .cep(cepModel.getCep())
                .rua(cepModel.getLogradouro())
                .bairro(cepModel.getBairro())
                .complemento(cepModel.getComplemento())
                .cidade(cepModel.getLocalidade())
                .estado(cepModel.getUf())
                .frete(freteFormatado)
                .build();

        return freteModel;
    }

    public FreteModel findByCep(CepDTO cepDTO) {
        String cep = cepDTO.getCep().replaceAll("[-\\s]+", "");;
        String viaCepUrl = "https://viacep.com.br/ws/"+cep+"/json/";

        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        CepModel cepModel = restTemplate.getForObject(viaCepUrl, CepModel.class);

        if (cepModel.getCep() == null) {
            throw new NotFoundException("O CEP " + cep + " não foi localizado.");
        }

        FreteModel freteModel = buildFreteModel(cepModel);

        return freteModel;
    }
}

package com.wipro.viacep.controllers;

import com.wipro.viacep.DTO.CepDTO;
import com.wipro.viacep.models.FreteModel;
import com.wipro.viacep.services.CepService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1")
@Api(value = "API REST Via CEP")
@CrossOrigin(origins = "*")
public class CepController {

    @Autowired
    CepService cepService;

    @PostMapping("consulta-endereco")
    @ApiOperation(value="Retorna um endereço através de um CEP")
    public ResponseEntity<FreteModel> enderecoWithFrete(@RequestBody CepDTO cepDTO) {
        FreteModel freteModel = cepService.findByCep(cepDTO);
        return new ResponseEntity<>(freteModel, HttpStatus.OK);
    }
}

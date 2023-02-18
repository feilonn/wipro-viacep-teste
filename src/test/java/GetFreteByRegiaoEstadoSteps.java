import com.wipro.viacep.DTO.CepDTO;
import com.wipro.viacep.controllers.CepController;
import com.wipro.viacep.models.FreteModel;
import com.wipro.viacep.utils.HelperFunctions;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

//-------
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertEquals;

public class GetFreteByRegiaoEstadoSteps {
    private String cep;
    private ResponseEntity<FreteModel> responseEntity;

    @Autowired
    private CepController cepController = new CepController();
//    -----------
    private String uf;
    private Double valorEsperado;
    private Double valorRetornado;

    @Dado("que eu possua a UF {string}")
    public void que_eu_possua_a_uf(String string) {
        this.uf = string;
    }

    @Quando("eu chamar a função getFreteByRegiaoEstado")
    public void eu_chamar_a_função_get_frete_by_regiao_estado() {
        valorRetornado = HelperFunctions.getFreteByRegiaoEstado(uf);
    }

    @Então("o valor retornado deve ser {string}")
    public void o_valor_retornado_deve_ser(String string) {
        valorEsperado = Double.parseDouble(string);
        System.out.println("Função para calculo de frete retornou corretamente para o Estado: "
                + uf +"\nEsperado: "
                +valorEsperado+"\nRetornado: "
                +valorRetornado);
        assertEquals(valorEsperado, valorRetornado);
    }

//    ---------

    @Dado("que o usuário informa o CEP {string}")
    public void que_o_usuário_informa_o_CEP(String cep) {
        this.cep = cep;
    }

    @Quando("o usuário realiza a consulta de endereço com frete")
    public void o_usuário_realiza_a_consulta_de_endereço_com_frete() {
        RestTemplate restTemplate = new RestTemplate();
        CepDTO cepDTO = new CepDTO();
        cepDTO.setCep(cep);
        HttpEntity<CepDTO> entity = new HttpEntity<>(cepDTO);

        responseEntity = restTemplate.exchange(
                "http://localhost:8080/v1/consulta-endereco",
                HttpMethod.POST,
                entity,
                FreteModel.class
        );
    }

    @Então("o sistema deve retornar o endereço com o valor do frete {string}")
    public void é_retornado_o_endereço_com_o_valor_do_frete(String valorFrete) {
        FreteModel freteModel = responseEntity.getBody();
//        System.out.println(freteModel.toString());
        Double valorFreteEsperado = Double.parseDouble(valorFrete);
        System.out.println("\nController retornou o endereço e o seu respectivo frete corretamente!\nValor esperado: R$"
                +valorFreteEsperado+"\nDados retornados:\n"+freteModel.toString());
        assertEquals(valorFreteEsperado, freteModel.getFrete());
    }
}

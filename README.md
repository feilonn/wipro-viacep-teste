# wipro-viacep-teste

Consumo da API: https://viacep.com.br/

# Documentação - Swagger
![image](https://user-images.githubusercontent.com/60004704/219874116-a2dec1ae-9186-40e3-b902-e86cceca0975.png)

# Consumo da API - /v1/consulta-endereco
Requisição do tipo POST.
<br>
Body da Requisição(JSON):
{
    "cep": "65073-660"
}

# Retorno da API - JSON
![image](https://user-images.githubusercontent.com/60004704/219874532-0fed8091-1325-4025-a455-7c88e4350466.png)


# Máscara para CEP
Para evitar erros na requisição ao servico da https://viacep.com.br/. Utilizei uma regex para remover os caraceteres: "-" e " ".
<br>
- REGEX: ("[-\\s]+", "")

# DTO
Data Transfer Object criado para padronizar o JSON da requisição
<br>
![image](https://user-images.githubusercontent.com/60004704/219874623-a4b0d501-1e5a-463a-9625-77b9bc44cf49.png)

# Testes
Durante a fase de testes, utilizei tanto os métodos convencionais: Swagger e Postman, como também JUnit e Cucumber. As principais funcionalidades foram testadas:
<br>
- Resposta do controller da API
- Função que define o valor de frete por região

# Demais observações
Para recuperar o resultado do serviço da https://viacep.com.br/. Foram utilizadas as classe RestTemplate e RestTemplateBuilder, podendo assim usufruir do método getForObjetc()
![image](https://user-images.githubusercontent.com/60004704/219874757-d284f156-5252-4d87-8cf1-8c9eff4fea48.png)
<br>
Para uma maior limpeza no código, utilizei Lombok nos Models e DTO.

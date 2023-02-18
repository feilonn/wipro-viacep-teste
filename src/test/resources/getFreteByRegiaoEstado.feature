# language: pt

  Funcionalidade: Testar o calculo de frete por regiao do estado

    Esquema do Cenário: Obter o valor de frete por regiao do estado
      Dado que eu possua a UF "<uf>"
      Quando eu chamar a função getFreteByRegiaoEstado
      Então o valor retornado deve ser "<valorEsperado>"
      Exemplos:
        | uf | valorEsperado |
        | SP | 7.85          |
        | CE | 15.98         |
        | GO | 12.5          |
        | AC | 20.83         |
        | AM | 20.83         |
        | AP | 20.83         |
        | PA | 20.83         |
        | RO | 20.83         |
        | RR | 20.83         |
        | TO | 20.83         |
        | AL | 15.98         |
        | BA | 15.98         |
        | MA | 15.98         |
        | NN | 0.0           |

    Cenário: Consulta de endereço com sucesso
      Dado que o usuário informa o CEP "65073310"
      Quando o usuário realiza a consulta de endereço com frete
      Então o sistema deve retornar o endereço com o valor do frete "15.98"
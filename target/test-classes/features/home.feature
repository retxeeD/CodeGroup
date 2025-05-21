#language: pt
@homePage
Funcionalidade: : Navegacao na home page com sucesso

  @CT-001
  Esquema do Cenario: Validar produtos sugeridos ao buscar por produto
    Dado que estou na página home da amazon
    Quando busco o produto "<PRODUTO>" na barra de pesquisa
    Entao a barra de sugestoes e exibida com produtos relacionados com "<PRODUTO>"
    Exemplos:
      | PRODUTO  |
      | carro    |
      | org      |

  @CT-002
  Esquema do Cenario: Validar responsividade da pagina
    Dado que estou na página home da amazon
    Quando altero as dimensoes da tela para ser equivalente ao dispositivo "<DISPOSITIVO>"
    Entao a pagina é alterada para os padroes do dipositivo "<DISPOSITIVO>"
    Exemplos:
      | DISPOSITIVO |
      | mobile      |
      | tablet      |

  @CT-003
  Cenario: Validar tempo de carregamento da pagina
    Dado que estou na página home da amazon
    Entao o tempo de carregamento da pagina deve ser menor que 3000 ms
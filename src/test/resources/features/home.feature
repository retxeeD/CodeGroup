#language: pt
@homePage
Funcionalidade: : Navegacao na home page com sucesso

  @CT-001 @CT-004
  Esquema do Cenario: Validar produtos sugeridos ao buscar por produto
    #CT-001 Validar produtos sugeridos ao buscar por nome parcial de produto
    #CT-004 Validar produtos sugeridos ao buscar por nome especifico de produto
    Dado que estou na página home da amazon
    Quando busco o produto "<PRODUTO>" na barra de pesquisa
    Entao a barra de sugestoes e exibida com produtos relacionados com "<PRODUTO>"
    Exemplos:
      | PRODUTO     |
      | org         |
      | samsung s24 |

  @CT-011 @CT-012
  Esquema do Cenario: Validar responsividade da pagina
    #CT-011 Validar exibição do menu em dispositivo desktop
    #CT-012 Validar exibição do menu em dispositivo mobile
    Dado que estou na página home da amazon
    Quando altero as dimensoes da tela para ser equivalente ao dispositivo "<DISPOSITIVO>"
    Entao a pagina é alterada para os padroes do dipositivo "<DISPOSITIVO>"
    Exemplos:
      | DISPOSITIVO |
      | desktop     |
      | mobile      |
      | tablet      |

  @CT-005
  Cenario: Validar tempo de carregamento da pagina
    Dado que estou na página home da amazon
    Entao o tempo de carregamento da pagina deve ser menor que 3000 ms
#language: pt
@homePage
Funcionalidade: Autocomplete

  @CT-AUT-011 @CT-AUT-014
  Esquema do Cenario: Validar produtos sugeridos ao buscar por produto
    #CT-AUT-011 Validar produtos sugeridos ao buscar por nome parcial de produto
    #CT-AUT-014 Validar produtos sugeridos ao buscar por nome especifico de produto
    Dado que estou na página home da amazon
    Quando busco o produto "<PRODUTO>" na barra de pesquisa
    Entao a barra de sugestoes e exibida com produtos relacionados com "<PRODUTO>"
    Exemplos:
      | PRODUTO             |
      | org                 |
      | samsung s24 256 gb  |
#language: pt
@homePage
Funcionalidade: Menu

  @CT-MEN-010 @CT-MEN-011
  Esquema do Cenario: Validar responsividade da pagina
    #CT-MEN-010 Validar exibição do menu em dispositivo desktop
    #CT-MEN-011 Validar exibição do menu em dispositivo mobile
    Dado que estou na página home da amazon
    Quando altero as dimensoes da tela para ser equivalente ao dispositivo "<DISPOSITIVO>"
    Entao a pagina é alterada para os padroes do dipositivo "<DISPOSITIVO>"
    Exemplos:
      | DISPOSITIVO |
      | desktop     |
      | mobile      |
      | tablet      |
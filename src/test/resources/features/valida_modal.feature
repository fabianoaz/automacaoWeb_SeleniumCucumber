Feature: Validar informacao em modal de consulta
  Eu como usuario da aplicação desejo detalhes de consulta em caixa de dialogo
  
  Scenario: Validar texto de modal de consulta
    Given acesse a pagina site.getnet.com.br
    And clico na lupa para iniciar pesquisa
    And no campo de pesquisa informo SuperGet
    And clico em Pesquisar
    And clico na linha com valor - Como acesso a minha conta SuperGet?
    Then valido se modal foi aberto
    And verifico se nele ha o texto - Como acesso a minha conta SuperGet?
    Then encerro a aplicacao
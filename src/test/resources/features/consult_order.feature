Feature: Consultar una orden existente en PetStore

  @consultarOrden
  Scenario: Consultar orden por id
    Given estoy en la pagina de mascota
    When consulto la orden con id 987
    Then el código de la respuesta es 200

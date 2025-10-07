Feature: Crear una orden valida PetStore

  @crearOrden
  Scenario: Crear una orden
    Given estoy en la pagina de mascota
    When creo una orden con el id 987, petId 123 y quantity 456
    Then el código de respuesta es 200
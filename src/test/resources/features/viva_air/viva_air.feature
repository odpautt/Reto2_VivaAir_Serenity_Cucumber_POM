@test
Feature: Buscar Vuelo

  Yo como usuario de Viva Air
  Quiero una opción de búsqueda de vuelos
  Para poder visualizar las opciones de viajes disponibles

  @Scenario
  Scenario: el usuario deberia poder buscar viajes de solo ida
    Given el usario esta en la pagina de inicio
    When el usuario selecciona la opcion viaje de ida
    And el usuario diligencia la informacion requeria del formulario de vuelos
      |origen   |destino       |fechaIda         |numeroPasajerosAdultos|numeroPasajerosNinos|numeroPasajerosInfantes|
      |bogota   |san andres    |3/Febrero/2023     |3                     |          1         |            1          |
    Then el sistema mostrara las opciones de viajes disponibles

#  @Scenario
#    Given El usario esta en la pagina de inicio
 #   When El usuario selecciona la opcion viaje de ida y regreso
  #  And El usuario diligencia la informacion requeria del formulario de vuelos
   #   |   origen   |   destino       |   fechaIda     |   fechaRegreso     |numeroPasajerosAdultos|numeroPasajerosNinos|numeroPasajerosInfantes|
    #  |   bogota   |   san andres    |   1/4/2022     |    28/4/2022       |          1           |          1         |            0          |
    #hen El sistema mostrara las opciones de viajes disponibles
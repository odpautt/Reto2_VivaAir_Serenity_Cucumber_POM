@test
Feature: Buscar Vuelo

  Yo como usuario de Viva Air
  Quiero una opción de búsqueda de vuelos
  Para poder visualizar las opciones de viajes disponibles

  @Scenario
  Scenario: el usuario deberia poder buscar viajes de ida y vuelta
    Given el usario esta en la pagina de inicio
    When el usuario selecciona la opcion viaje de ida y vuelta
    And el usuario diligencia la informacion requeria del formulario de vuelos
      |origen   |destino       |fechaIda               |numeroPasajerosAdultos|numeroPasajerosNinos|numeroPasajerosInfantes|fechaVuelta|
      |bogota   |san andres    |20/Septiembre/2022     |1                     |          0        |       0          |23/Noviembre/2022|
    Then el sistema mostrara las opciones de viajes disponibles


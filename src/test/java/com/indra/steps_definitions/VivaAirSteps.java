package com.indra.steps_definitions;

import com.indra.actions.VivaAirActions;
import com.indra.models.FormularioVuelos;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class VivaAirSteps {
    @Managed
    WebDriver driver;
    VivaAirActions vivaAirActions = new VivaAirActions(driver);
        @Given("^el usario esta en la pagina de inicio$")
    public void elUsarioEstaEnLaPaginaDeInicio() {
        vivaAirActions.open();
        vivaAirActions.aceptarCookies();
    }

    @When("^el usuario selecciona la opcion viaje de ida$")
    public void elUsuarioSeleccionaLaOpcionViajeDeIda() {
        vivaAirActions.seleccionarTipoVuelo();
    }

    @When("^el usuario diligencia la informacion requeria del formulario de vuelos$")
    public void elUsuarioDiligenciaLaInformacionRequeriaDelFormularioDeVuelos(List<FormularioVuelos>formularioVuelos) {
        vivaAirActions.llenarFormularioDeVuelos(formularioVuelos.get(0));

    }

    @Then("^el sistema mostrara las opciones de viajes disponibles$")
    public void elSistemaMostraraLasOpcionesDeViajesDisponibles() {
        vivaAirActions.hacerClicEnBuscarVuelo();
        vivaAirActions.muestraLaCantidadDeResultados();

    }
/** ########################## escenario de prueba 2 ######################################

    @Given("^El usario esta en la pagina de inicio$")
    public void elUsarioEstaEnLaPaginaDeInicio() {
        vivaAirActions.open();
    }

    @When("^El usuario selecciona la opcion viaje de ida y regreso$")
    public void elUsuarioSeleccionaLaOpcionViajeDeIdaYRegreso() {

    }

    @When("^El usuario diligencia la informacion requeria del formulario de vuelos$")
    public void elUsuarioDiligenciaLaInformacionRequeriaDelFormularioDeVuelos(List<FormularioVuelos> formularioVuelosList) {


    }

    @Then("^El sistema mostrará las opciones de viajes disponibles$")
    public void elSistemaMostraraLasOpcionesDeViajesDisponibles() {

    }
 */
}

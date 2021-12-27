package com.indra.steps_definitions;
import com.indra.actions.VivaAirActions;
import com.indra.models.FormularioVuelos;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
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

    @When("^el usuario selecciona la opcion viaje de ida y vuelta$")
    public void elUsuarioSeleccionaLaOpcionViajeDeIdaYVuelta() {
        vivaAirActions.seleccionarOpcionVueloIdaYVuelta();
    }

    @When("^el usuario diligencia la informacion requeria del formulario de vuelos$")
    public void elUsuarioDiligenciaLaInformacionRequeriaDelFormularioDeVuelos(List<FormularioVuelos>formularioVuelos) {
        vivaAirActions.llenarFormularioDeVuelos(formularioVuelos.get(0));
        vivaAirActions.hacerClicEnBuscarVuelo();

    }

    @Then("^el sistema mostrara las opciones de viajes disponibles$")
    public void elSistemaMostraraLasOpcionesDeViajesDisponibles() {
        int cantidadVueltos= vivaAirActions.muestraLaCantidadDeResultados();
        MatcherAssert.assertThat("la paguina muestra mas de 1 resultado de horarios de vuelos",
                cantidadVueltos, Matchers.greaterThanOrEqualTo(1));

    }
}

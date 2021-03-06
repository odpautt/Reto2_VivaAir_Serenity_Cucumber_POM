package com.indra.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DefaultUrl("https://www.vivaair.com/#/co/es")
public class VivaAirHomePages extends PageObject {

    public VivaAirHomePages(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//button[@type='button'])[1]")
    private WebElementFacade cookies;

    @FindBy(xpath = "//span[contains(.,'Solo ida')]")
    private WebElementFacade seleccionaSoloIda;

    @FindBy(xpath = "//span[contains(.,'Ida y regreso')]")
    private WebElementFacade seleccionaIdaYVuelta;

    @FindBy(xpath = "(//input[contains(@type,'text')])[1]")
    private WebElementFacade Origen;

    @FindBy(xpath = "(//input[@id='filter-station-second'])[1]")
    private WebElementFacade destino;

    @FindBy(xpath = "//span[contains(@class,'title --colombian-stations')]")
    private WebElementFacade listaDesplegable;



    /*****************************************************Elementos del calendario  *************************************/

    @FindBy(xpath = "(//img[@alt='Calendario'])[2]")
    private WebElementFacade btnCalendario;

    @FindBy(xpath = "//div[@class='chevron right big']")
    private WebElementFacade botonSiguieteCalendario;

    @FindBy(xpath = "//div[@class='calendar__date_picker']")
    private WebElementFacade calendario;

    @FindBy(xpath = "(//div[@class='calendar__date_picker']//div[@class='month']//div//span[@class='name'])[1]")
    private WebElementFacade nombreMes;

    /** Calendario de la derecha*/

    @FindBy(xpath = "(//div[@class='calendar__date_picker']//div[@class='month']//div//span[@class='year ml-1'])[1]")
    private WebElementFacade year;

    @FindBy(xpath = "(//div[contains(@class,'calendar__date_picker__container--grid calendar__date_picker__container__day--first')])[1]//div[@class='calendar__date_picker__container__day date low']")
    private List<WebElementFacade> d??asHabilitadosDeViajes;

    @FindBy(xpath = "(//div[contains(@class,'calendar__date_picker__container--grid calendar__date_picker__container__day--first')])[1]//div[@class='calendar__date_picker__container__day date high']")
    private List<WebElementFacade> d??asHabilitadosDeViajes2;

    @FindBy(xpath = "(//div[contains(@class,'calendar__date_picker__container--grid calendar__date_picker__container__day--first')])[1]//div[@class='calendar__date_picker__container__day date medium']")
    private List<WebElementFacade> d??asHabilitadosDeViajes3;

    /** Calendario de la izquierda*/

    @FindBy(xpath = "(//div[@class='calendar__date_picker']//div[@class='month']//div//span[@class='name'])[2]")
    private WebElementFacade nombreMesDerecha;

    @FindBy(xpath = "(//div[@class='calendar__date_picker']//div[@class='month']//div//span[@class='year ml-1'])[2]")
    private WebElementFacade yearDerecha;

    @FindBy(xpath = "(//div[contains(@class,'calendar__date_picker__container--grid calendar__date_picker__container__day--first')])[2]//div[@class='calendar__date_picker__container__day date low']")
    private List<WebElementFacade> d??asHabilitadosDeViajesDerecha;

    @FindBy(xpath = "(//div[contains(@class,'calendar__date_picker__container--grid calendar__date_picker__container__day--first')])[2]//div[@class='calendar__date_picker__container__day date high']")
    private List<WebElementFacade> d??asHabilitadosDeViajesDerecha2;

    @FindBy(xpath = "(//div[contains(@class,'calendar__date_picker__container--grid calendar__date_picker__container__day--first')])[2]//div[@class='calendar__date_picker__container__day date medium']")
    private List<WebElementFacade> d??asHabilitadosDeViajesDerecha3;
    /** Cantidad de pasajeros **/
    @FindBy(id = "passenger")
    private WebElementFacade seccionCantidadPasajeros;

    @FindBy(xpath = "(//div[@class='action__sign'][contains(.,'+')])[1]")
    private WebElementFacade agregarPasajeroAdulto;

    @FindBy(xpath = "(//div[@class='action__sign'][contains(.,'+')])[2]")
    private WebElementFacade agregarPasajeroNino;

    @FindBy(xpath = "(//div[@class='action__sign'][contains(.,'+')])[3]")
    private WebElementFacade agregarPasajeroInfante;

    @FindBy(xpath = "(//span[contains(.,'Buscar')])[1]")
    private WebElementFacade botonBuscarVuelos;

    @FindBy(xpath = "(//div[@class='detail details__departure d-flex flex-column align-items-center justify-content-center'])")
    private List<WebElementFacade> resultadoDelaBusquedaDelVuelo;


    @FindBy(xpath = "(//div[@class='calendar__date_picker']//div[@class='month']//div//span[@class='name'])")
    private List<WebElementFacade> listaDeInvento;

    public List<WebElementFacade> getResultadoDelaBusquedaDelVuelo() {
        return resultadoDelaBusquedaDelVuelo;
    }

    /*********************************************** Metodos Get de cada elemento ****************************************************/

    public List<WebElementFacade> getListaDeInvento() {
        return listaDeInvento;
    }

    public List<WebElementFacade> getD??asHabilitadosDeViajes() {
        return d??asHabilitadosDeViajes;
    }

    public List<WebElementFacade> getD??asHabilitadosDeViajes2() {
        return d??asHabilitadosDeViajes2;
    }

    public List<WebElementFacade> getD??asHabilitadosDeViajes3() {
        return d??asHabilitadosDeViajes3;
    }

    public WebElementFacade getYear() {
        return year;
    }

    public WebElementFacade getCalendario() {
        return calendario;
    }

    public WebElementFacade getNombreMes() {
        return nombreMes;
    }

    public WebElementFacade getListaDesplegable() {
        return listaDesplegable;
    }

    public WebElementFacade getBtnCalendario() {
        return btnCalendario;
    }

    public WebElementFacade getBotonSiguieteCalendario() {
        return botonSiguieteCalendario;
    }

    public WebElementFacade getSeleccionaSoloIda() {
        return seleccionaSoloIda;
    }

    public WebElementFacade getOrigen() {
        return Origen;
    }

    public WebElementFacade getDestino() {
        return destino;
    }

    public WebElementFacade getCookies() {
        return cookies;
    }

    public WebElementFacade getSeccionCantidadPasajeros() {
        return seccionCantidadPasajeros;
    }

    public WebElementFacade getAgregarPasajeroAdulto() {
        return agregarPasajeroAdulto;
    }

    public WebElementFacade getAgregarPasajeroNino() {
        return agregarPasajeroNino;
    }

    public WebElementFacade getAgregarPasajeroInfante() {
        return agregarPasajeroInfante;
    }

    public WebElementFacade getBotonBuscarVuelos() {
        return botonBuscarVuelos;
    }



    public WebElementFacade getNombreMesDerecha() {
        return nombreMesDerecha;
    }

    public WebElementFacade getYearDerecha() {
        return yearDerecha;
    }

    public List<WebElementFacade> getD??asHabilitadosDeViajesDerecha() {
        return d??asHabilitadosDeViajesDerecha;
    }

    public List<WebElementFacade> getD??asHabilitadosDeViajesDerecha2() {
        return d??asHabilitadosDeViajesDerecha2;
    }

    public List<WebElementFacade> getD??asHabilitadosDeViajesDerecha3() {
        return d??asHabilitadosDeViajesDerecha3;
    }

    public WebElementFacade getSeleccionaIdaYVuelta() {
        return seleccionaIdaYVuelta;
    }


}

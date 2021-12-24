package com.indra.actions;

import com.indra.models.FormularioVuelos;
import com.indra.pages.VivaAirHomePages;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://www.vivaair.com/#/co/es")

public class VivaAirActions extends VivaAirHomePages {

    public VivaAirActions(WebDriver driver) {
        super(driver);
    }


    public void aceptarCookies(){
        getCookies().click();
    }

    public void seleccionarTipoVuelo(){
        getSeleccionaSoloIda().click();
    }

    public void llenarFormularioDeVuelos(FormularioVuelos formularioVuelos ){
        llenarOrigen(formularioVuelos);
        llenarDestino(formularioVuelos);
        diligenciaFechaDeVuelo(formularioVuelos);
        agregarCantidadDePasajeros(formularioVuelos);
    }

    public void hacerClicCajaOrigen(){
        getOrigen().click();
    }

    public void  llenarOrigen(FormularioVuelos formularioVuelos){
        hacerClicCajaOrigen();
        getListaDesplegable().waitUntilPresent();
        enter(formularioVuelos.getOrigen(),Keys.ENTER).into(getOrigen());
    }

    public void  llenarDestino(FormularioVuelos formularioVuelos){
        enter(formularioVuelos.getDestino(),Keys.ENTER).into(getDestino());
    }

    public void seleccionarFechaDelVuelo(FormularioVuelos formularioVuelos){
        /** Se realiza una separacion de la fecha que esta en el feature*/
        String diaDeIda = formularioVuelos.getFechaIda().split("/")[0];
        String mesDeIda = formularioVuelos.getFechaIda().split("/")[1];
        String anioDeIda = formularioVuelos.getFechaIda().split("/")[2];
        //System.out.println("Dia ### "+diaDeIda+" Mes #### "+mesDeIda+" ### Año "+anioDeIda);
        String mesDeIdaCalendario = getNombreMes().getText();
        String anioDeIdaCalendario = getYear().getText();

        while( (anioDeIda.equals(anioDeIdaCalendario))== false && (mesDeIda.equals(mesDeIdaCalendario))==false) {
            //getYear().waitUntilVisible();
            getBotonSiguieteCalendario().waitUntilVisible();
            mesDeIdaCalendario = getNombreMes().getText();
            anioDeIdaCalendario = getYear().getText();
            getBotonSiguieteCalendario().click();
       }
        getCalendario().waitUntilVisible();

        /** se realiza la generacion de una sola lista de elementos web de los dias habilitados para viajar*/
        List<WebElementFacade> listadoDeDiasHabilitadosParaViaje = new ArrayList<WebElementFacade>(getDíasHabilitadosDeViajes());
        listadoDeDiasHabilitadosParaViaje.addAll(getDíasHabilitadosDeViajes2());
        listadoDeDiasHabilitadosParaViaje.addAll(getDíasHabilitadosDeViajes3());
        Boolean diaHabilitado= false;

        for (WebElementFacade dia : listadoDeDiasHabilitadosParaViaje){
            if(diaDeIda.equals(dia.getText())){
                dia.click();
                diaHabilitado=true;
                break;
            }
        }
        if (diaHabilitado==false){
                System.out.println("El dia no tiene viajes habilitados");
            }
    }

    public void hacerClickEnSeccionPasajeros(){
        getSeccionCantidadPasajeros().click();
    }

    public void agregarCantidadDePasajeros(FormularioVuelos formularioVuelos){
        hacerClickEnSeccionPasajeros();
        int  numPasajerosAdultos= Integer.parseInt(formularioVuelos.getNumeroPasajerosAdultos());
        int  numPasajerosNinos= Integer.parseInt(formularioVuelos.getNumeroPasajerosNinos());
        int  numPasajerosInfantes= Integer.parseInt(formularioVuelos.getNumeroPasajerosInfantes());

        if(numPasajerosAdultos>1){
            for (int i =1; i< numPasajerosAdultos; i++){
                getAgregarPasajeroAdulto().click();
            }
        }
        if(numPasajerosNinos>0){
            for (int i =0; i< numPasajerosNinos; i++) {
                getAgregarPasajeroNino().click();
            }
        }
        if(numPasajerosInfantes>0){
            for (int i =0; i< numPasajerosInfantes; i++) {
                getAgregarPasajeroInfante().click();
            }

        }
    }

    public void hacerClicEnBuscarVuelo(){
        getBotonBuscarVuelos().click();
    }

    public void muestraLaCantidadDeResultados(){
        getResultadoDelaBusquedaDelVuelo().waitUntilPresent();
        System.out.println(getResultadoDelaBusquedaDelVuelo().getText());

    }

    public void seleccionarFechaDelCalendarioDeLaIzquierda(FormularioVuelos formularioVuelos) {

        String diaDeIda = formularioVuelos.getFechaIda().split("/")[0];
        String mesDeIda = formularioVuelos.getFechaIda().split("/")[1];
        String anioDeIda = formularioVuelos.getFechaIda().split("/")[2];

        System.out.println("Dia ### "+diaDeIda+" Mes #### "+mesDeIda+" ### Año "+anioDeIda);
        //

        String mesCalendario = getNombreMes().getText();
        String anioCalendario = getYear().getText();

        for(int j=0; j<14;j++){

            getBotonSiguieteCalendario().waitUntilVisible();
            //System.out.println(getNombreMes().getText());
            /**for (WebElementFacade mes : getListaDeInvento()) {
                System.out.println(mes.getText());
            }*/
            mesCalendario = getNombreMes().getText();
            anioCalendario = getYear().getText();
            //WebElementFacade buscarMEs = getDriver().findElement(By.xpath( "(//div[@class='calendar__date_picker']//div[@class='month']//div//span[@class='name' and text()='"+mesDeIda+"'])"));
            //System.out.println(buscarMEs.getText());
            if(anioDeIda.equals(anioCalendario) && mesDeIda.equals(mesCalendario)){
                  break;
                }
            getBotonSiguieteCalendario().click();
        }
        getCalendario().waitUntilVisible();

        /** se realiza la generacion de una sola lista de elementos web de los dias habilitados para viajar*/
        List<WebElementFacade> listadoDeDiasHabilitadosParaViaje = new ArrayList<WebElementFacade>(getDíasHabilitadosDeViajes());
        listadoDeDiasHabilitadosParaViaje.addAll(getDíasHabilitadosDeViajes2());
        listadoDeDiasHabilitadosParaViaje.addAll(getDíasHabilitadosDeViajes3());
        Boolean diaHabilitado= false;

        for (WebElementFacade dia : listadoDeDiasHabilitadosParaViaje){
            if(diaDeIda.equals(dia.getText())){
                dia.click();
                diaHabilitado=true;
                break;
            }
        }
        if (diaHabilitado==false){
            System.out.println("El dia no tiene viajes habilitados");
        }



    }

    public void seleccionarFechaDelCalendarioDeLaDerecha(FormularioVuelos formularioVuelos) {

        String diaDeIda = formularioVuelos.getFechaIda().split("/")[0];
        String mesDeIda = formularioVuelos.getFechaIda().split("/")[1];
        String anioDeIda = formularioVuelos.getFechaIda().split("/")[2];

        System.out.println("Dia ### "+diaDeIda+" Mes #### "+mesDeIda+" ### Año "+anioDeIda);
        //

        String mesCalendarioDerecha = getNombreMesDerecha().getText();
        String anioCalendarioDerecha = getYearDerecha().getText();

        for(int j=0; j<14;j++){

            getBotonSiguieteCalendario().waitUntilVisible();
            //System.out.println(getNombreMes().getText());

            mesCalendarioDerecha = getNombreMesDerecha().getText();
            anioCalendarioDerecha = getYearDerecha().getText();

            if(anioDeIda.equals(anioCalendarioDerecha) && mesDeIda.equals(mesCalendarioDerecha)){
                break;
            }
            getBotonSiguieteCalendario().click();
        }
        getCalendario().waitUntilVisible();

        /** se realiza la generacion de una sola lista de elementos web de los dias habilitados para viajar*/
        List<WebElementFacade> listadoDeDiasHabilitadosParaViaje = new ArrayList<WebElementFacade>(getDíasHabilitadosDeViajesDerecha());
        listadoDeDiasHabilitadosParaViaje.addAll(getDíasHabilitadosDeViajesDerecha2());
        listadoDeDiasHabilitadosParaViaje.addAll(getDíasHabilitadosDeViajesDerecha3());
        Boolean diaHabilitado= false;

        for (WebElementFacade dia : listadoDeDiasHabilitadosParaViaje){
            if(diaDeIda.equals(dia.getText())){
                dia.click();
                diaHabilitado=true;
                break;
            }
        }
        if (diaHabilitado==false){
            System.out.println("El dia no tiene viajes habilitados");
        }

    }

    public void diligenciaFechaDeVuelo(FormularioVuelos formularioVuelos){
        String mesDeIda = formularioVuelos.getFechaIda().split("/")[1];

        if(mesDeIda.equals("Diciembre")||mesDeIda.equals("Febrero")||mesDeIda.equals("Abril")||mesDeIda.equals("Junio")||mesDeIda.equals("Agosto")||mesDeIda.equals("Octubre")){
            //System.out.println("izquierda");
            seleccionarFechaDelCalendarioDeLaIzquierda(formularioVuelos);
        }
        else if(mesDeIda.equals("Enero")||mesDeIda.equals("Marzo")||mesDeIda.equals("Mayo")||mesDeIda.equals("Julio")||mesDeIda.equals("Septiembre")||mesDeIda.equals("Noviembre")){
            //System.out.println("derecha");
            seleccionarFechaDelCalendarioDeLaDerecha(formularioVuelos);
       }
        else{
            System.out.println("no existe ese mes");
        }
    }



}

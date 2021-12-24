package com.indra.models;

public class FormularioVuelos {
    private String origen;
    private String destino;
    private String fechaIda;
    private String numeroPasajerosAdultos;
    private String numeroPasajerosNinos;
    private String numeroPasajerosInfantes;


    public String getNumeroPasajerosNinos() {
        return numeroPasajerosNinos;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getFechaIda() {
        return fechaIda;
    }

    public String getNumeroPasajerosAdultos() {
        return numeroPasajerosAdultos;
    }

    public String getNumeroPasajerosInfantes() {
        return numeroPasajerosInfantes;
    }
}

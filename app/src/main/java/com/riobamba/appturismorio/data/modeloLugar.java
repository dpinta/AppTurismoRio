package com.riobamba.appturismorio.data;

/**
 * Created by lllum on 13/12/2016.
 */

public class modeloLugar {

    public  String idLugar;
    public String nombreLugar;
    public  String direccionLugar;
    public  String descripcionLugar;
    public  String latitudLugar;
    public  String longitudLugar;

    public modeloLugar() {

    }

    public modeloLugar(String idLugar, String nombreLugar, String direccionLugar, String descripcionLugar, String latitudLugar, String longitudLugar) {
        this.idLugar = idLugar;
        this.nombreLugar = nombreLugar;
        this.direccionLugar = direccionLugar;
        this.descripcionLugar = descripcionLugar;
        this.latitudLugar = latitudLugar;
        this.longitudLugar = longitudLugar;
    }

    public String getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(String idLugar) {
        this.idLugar = idLugar;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    public String getDireccionLugar() {
        return direccionLugar;
    }

    public void setDireccionLugar(String direccionLugar) {
        this.direccionLugar = direccionLugar;
    }

    public String getDescripcionLugar() {
        return descripcionLugar;
    }

    public void setDescripcionLugar(String descripcionLugar) {
        this.descripcionLugar = descripcionLugar;
    }

    public String getLatitudLugar() {
        return latitudLugar;
    }

    public void setLatitudLugar(String latitudLugar) {
        this.latitudLugar = latitudLugar;
    }

    public String getLongitudLugar() {
        return longitudLugar;
    }

    public void setLongitudLugar(String longitudLugar) {
        this.longitudLugar = longitudLugar;
    }
}

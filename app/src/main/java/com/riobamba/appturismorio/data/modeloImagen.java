package com.riobamba.appturismorio.data;

/**
 * Created by lllum on 13/12/2016.
 */

public class modeloImagen {


    public String idImagen;
    public String pathImagen;
    public modeloLugar idLugar;

    public modeloImagen(String idImagen, String pathImagen, modeloLugar idLugar) {
        this.idImagen = idImagen;
        this.pathImagen = pathImagen;
        this.idLugar = idLugar;
    }

    public String getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(String idImagen) {
        this.idImagen = idImagen;
    }

    public String getPathImagen() {
        return pathImagen;
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }

    public modeloLugar getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(modeloLugar idLugar) {
        this.idLugar = idLugar;
    }
}

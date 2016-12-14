package com.riobamba.appturismorio.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by lllum on 13/12/2016.
 */

public class operacionDB {

    private static turismoRioDBHelper base;
    private static operacionDB operacion;
    private Context contexto;




    private operacionDB() {


    }

   /* public static operacionDB optenerInstancia(Context contexto) {
        if (base == null) {
            base = new turismoRioDBHelper(contexto);

        }
        return operacion;
    }*/

    // insetar informacion

    public void insertarLugar(modeloLugar lugar)
    {
        ContentValues valores= new ContentValues();

        base = new turismoRioDBHelper(contexto);
        // db = base.getWritableDatabase();
        SQLiteDatabase db=base.getWritableDatabase();

        valores.put("idLugar",lugar.idLugar );
        valores.put("nombreLugar",lugar.nombreLugar );
        valores.put("direccionLugar",lugar.direccionLugar );
        valores.put("descripcionLugar",lugar.descripcionLugar );
        valores.put("latitudLugar",lugar.latitudLugar );
        valores.put("longitudLugar",lugar.longitudLugar );
        db.insert("lugar",null,valores);

            }

    public void insertarImagen(modeloImagen imagen)
    {
        ContentValues valores = new ContentValues();
        SQLiteDatabase db= base.getWritableDatabase();

        valores.put("idImagen",imagen.idImagen);
        valores.put("pathImagen",imagen.pathImagen);
        valores.put("idLugar",imagen.idLugar.idLugar);
     db.insert("imagenLugar",null,valores);


    }




}

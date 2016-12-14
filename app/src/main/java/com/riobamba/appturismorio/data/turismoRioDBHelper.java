package com.riobamba.appturismorio.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lllum on 12/12/2016.
 */

public class turismoRioDBHelper extends SQLiteOpenHelper {

    private static int version=1;
    private static String DB_NAME="turismoRio";
    private static SQLiteDatabase.CursorFactory factory=null;

    public turismoRioDBHelper(Context context) {
        super(context, DB_NAME, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREAACION DE LA TABLA LUGAR
     //   db.execSQL(" CREATE TABLE lugar (id_lugar SERIAL NOT NULL,nombre_lugar TEXT NOT NULL, direccion_lugar TEXT NOT NULL, descripcion_lugar TEXT NOT NULL, latitud_lugar TEXT NOT NULL, longitud_lugar TEXT NOT NULL, PRIMARY KEY (id_lugar)); ");
        //CREACION DE LA TABLA IMAGEN
      //  db.execSQL("CREATE TABLE imagenLugar (id_imagen_lugar serial NOT NULL, path_imagen TEXT NOT NULL, id_lugar SERIAL NOT NULL REFERENCES lugar(id_lugar), PRIMARY KEY(id_imagen_lugar) )");
        db.execSQL("CREATE TABLE lugar (idLugar INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,nombreLugar TEXT NOT NULL, direccionLugar TEXT NOT NULL, descripcionLugar TEXT NOT NULL, latitud_lugar TEXT NOT NULL, longitudLugar TEXT NOT NULL)");
        db.execSQL("CREATE TABLE imagenLugar (idImagenLugar INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, pathImagen TEXT NOT NULL, idLugar INTEGER NOT NULL REFERENCES lugar(idLugar) )");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

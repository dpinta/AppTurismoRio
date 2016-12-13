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
        db.execSQL("create table lugar (id_lugar INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,nombre_lugar TEXT NOT NULL, direccion_lugar TEXT NOT NULL, descripcion_lugar TEXT NOT NULL, latitud_lugar TEXT NOT NULL, longitud_lugar TEXT NOT NULL) ");
        //CREACION DE LA TABLA IMAGEN
        db.execSQL("create table imagenLugar (id_imagen_lugar INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, path_imagen TEXT NOT NULL, id_lugar INTEGER NOT NULL REFERENCES lugar(id_lugar) )");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

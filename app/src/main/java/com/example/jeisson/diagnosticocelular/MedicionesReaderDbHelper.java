package com.example.jeisson.diagnosticocelular;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jeisson on 1/07/16.
 */
public class MedicionesReaderDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Mediciones.db";
    public static final int DATABASE_VERSION = 1;

    public MedicionesReaderDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Crear la tabla Mediciones
        db.execSQL(MedicionesDataSource.CREATE_MEDICIONES_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //  Añade los cambios que se realizarán en el esquema
        //  en tu proxima versión
    }
}


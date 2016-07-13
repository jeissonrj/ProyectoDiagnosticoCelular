package com.example.jeisson.diagnosticocelular;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jeisson on 15/06/16.
 */
public class Basededatos extends SQLiteOpenHelper {

    String sqlCreate =
            "CREATE TABLE Mediciones (" +
                    "id INTEGER, " +
                    "cliente TEXT, " +
                    "nit INTEGER," +
                    "sucursal TEXT, " +
                    "direccion TEXT," +
                    "ciudad TEXT," +
                    "abonado TEXT," +
                    "hora INTEGER, " +
                    "fecha INTEGER, " +
                    "latitud INTEGER, " +
                    "longitud INTEGER, " +
                    "operador_sim_card TEXT, " +
                    "tecno_sim_card TEXT, " +
                    "op_red_1_2g TEXT, " +
                    "tecno_op_red_1_2g TEXT, " +
                    "csq_op_red_1_2g INTEGER, " +
                    "op_red_2_2g TEXT, " +
                    "tecno_op_red_2_2g TEXT, " +
                    "csq_op_red_2_2g INTEGER, " +
                    "op_red_3_2g TEXT, " +
                    "tecno_op_red_3_2g TEXT, " +
                    "csq_op_red_3_2g INTEGER, " +
                    "op_mejor_cqs_2g TEXT, " +
                    "op_red_1_3g TEXT, " +
                    "tecno_op_red_1_3g TEXT, " +
                    "csq_op_red_1_3g INTEGER, " +
                    "op_red_2_3g TEXT, " +
                    "tecno_op_red_2_3g TEXT, " +
                    "csq_op_red_2_3g INTEGER, " +
                    "op_red_3_3g TEXT, " +
                    "tecno_op_red_3_3g TEXT, " +
                    "csq_op_red_3_3g INTEGER, " +
                    "op_mejor_cqs_3g TEXT)";

    public Basededatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate);  // si no existe la base de datos la crea y ejecuta los comandos siguientes.

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {    //funciona para cuando se actualice una version

        //se eleimina la version anterior de la base de datos
        db.execSQL("DROP TABLE IF EXISTS Mediciones");

        //crear de nuevo la base de datos con una version mas reciente
        db.execSQL(sqlCreate);

    }
}

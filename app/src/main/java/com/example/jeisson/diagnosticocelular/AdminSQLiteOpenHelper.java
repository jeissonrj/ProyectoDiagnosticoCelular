package com.example.jeisson.diagnosticocelular;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jeisson on 3/07/16.
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Registros(_id integer primary key, " +
                "cliente text, " +
                "nit integer, " +
                "sucursal text, " +
                "direccion text, " +
                "ciudad text, " +
                "abonado text, " +
                "hora text, " +
                "fecha text, " +
                "latitud text, " +
                "longitud text, " +
                "operador_sim_card text, " +
                "tecno_sim_card text, " +
                "op_red_1_2g text, " +
                "tecno_op_red_1_2g text, " +
                "csq_op_red_1_2g integer, " +
                "op_red_2_2g text, " +
                "tecno_op_red_2_2g text, " +
                "csq_op_red_2_2g integer, " +
                "op_red_3_2g text, " +
                "tecno_op_red_3_2g text, " +
                "csq_op_red_3_2g integer, " +
                "op_mejor_cqs_2g text, " +
                "op_red_1_3g text, " +
                "tecno_op_red_1_3g text, " +
                "csq_op_red_1_3g integer, " +
                "op_red_2_3g text, " +
                "tecno_op_red_2_3g text, " +
                "csq_op_red_2_3g integer, " +
                "op_red_3_3g text, " +
                "tecno_op_red_3_3g text, " +
                "csq_op_red_3_3g integer, " +
                "op_mejor_cqs_3g text)");  //_id podria quedar _id integer primary key autoincrement
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionPosterior) {
        db.execSQL("drop table if exists Registros");
        db.execSQL("create table Registros(dni integer primary key, cliente text, nit integer, sucursal text, direccion text, ciudad text, abonado text)");
    }


}

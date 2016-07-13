package com.example.jeisson.diagnosticocelular;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by jeisson on 1/07/16.
 */
public class MedicionesDataSource {

    //Metainformación de la base de datos
    public static final String MEDICIONES_TABLE_NAME = "Mediciones";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";

    //Campos de la tabla Mediciones
    public static class ColumnMediciones{
        public static final String ID_MEDICIONES = BaseColumns._ID;
        public static final String CLIENTE_MEDICIONES = "cliente";
        public static final String NIT_MEDICIONES = "nit";
        public static final String SUCURSAL_MEDICIONES = "sucursal";
        public static final String DIRECCION_MEDICIONES = "direccion";
        public static final String CIUDAD_MEDICIONES = "ciudad";
        public static final String ABONADO_MEDICIONES = "abonado";
        public static final String HORA_MEDICIONES = "hora";
        public static final String FECHA_MEDICIONES = "fecha";
        public static final String LATITUD_MEDICIONES = "latitud";
        public static final String LONGITUD_MEDICIONES = "longitud";
        public static final String OPERADORSIM_MEDICIONES = "operador_sim";
        public static final String TECNOSIM_MEDICIONES = "tecnologia_sim";
        public static final String OPRED12G_MEDICIONES = "operador_red_1_2g";
        public static final String TECNOOPRED12G_MEDICIONES = "tecnologia_operador_red_1_2g";
        public static final String CSQOPRED12G_MEDICIONES = "csq_operador_red_1_2g";
        public static final String OPRED22G_MEDICIONES = "operador_red_2_2g";
        public static final String TECNOOPRED22G_MEDICIONES = "tecnologia_operador_red_2_2g";
        public static final String CSQOPRED22G_MEDICIONES = "csq_operador_red_2_2g";
        public static final String OPRED32G_MEDICIONES = "operador_red_3_2g";
        public static final String TECNOOPRED32G_MEDICIONES = "tecnologia_operador_red_3_2g";
        public static final String CSQOPRED32G_MEDICIONES = "csq_operador_red_3_2g";
        public static final String OPRED13G_MEDICIONES = "operador_red_1_3g";
        public static final String TECNOOPRED13G_MEDICIONES = "tecnologia_operador_red_1_3g";
        public static final String CSQOPRED13G_MEDICIONES = "csq_operador_red_1_3g";
        public static final String OPRED23G_MEDICIONES = "operador_red_2_3g";
        public static final String TECNOOPRED23G_MEDICIONES = "tecnologia_operador_red_2_3g";
        public static final String CSQOPRED23G_MEDICIONES = "csq_operador_red_2_3g";
        public static final String OPRED33G_MEDICIONES = "operador_red_3_3g";
        public static final String TECNOOPRED33G_MEDICIONES = "tecnologia_operador_red_3_3g";
        public static final String CSQOPRED33G_MEDICIONES = "csq_operador_red_3_3g";
    }

    //Script de Creación de la tabla Mediciones
    public static final String CREATE_MEDICIONES_SCRIPT =
            "create table "+MEDICIONES_TABLE_NAME+"(" +
                    ColumnMediciones.ID_MEDICIONES+" "+INT_TYPE+" primary key autoincrement," +
                    ColumnMediciones.CLIENTE_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.NIT_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.SUCURSAL_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.DIRECCION_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.CIUDAD_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.ABONADO_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.HORA_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.FECHA_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.LATITUD_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.LONGITUD_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.OPERADORSIM_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.TECNOSIM_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.OPRED12G_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.TECNOOPRED12G_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.CSQOPRED12G_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.OPRED22G_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.TECNOOPRED22G_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.CSQOPRED22G_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.OPRED32G_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.TECNOOPRED32G_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.CSQOPRED32G_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.OPRED13G_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.TECNOOPRED13G_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.CSQOPRED13G_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.OPRED23G_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.TECNOOPRED23G_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.CSQOPRED23G_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.OPRED33G_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.TECNOOPRED33G_MEDICIONES+" "+STRING_TYPE+" not null," +
                    ColumnMediciones.CSQOPRED33G_MEDICIONES+" "+STRING_TYPE+" not null)" ;

    //Scripts de inserción por defecto
    //public static final String INSERT_MEDICIONES_SCRIPT =
    //"insert into "+MEDICIONES_TABLE_NAME+" values("
    //        + "null," + "\"CREPES & WAFLES\"," + "\"845673645\"," + "\"CHAPINERO\"," + "\"CRA13 CON 67\"," + "\"BOGOTA\","+ "\"5F3E\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\")," +
    //        "(null," +
    //        "\"PRIETO Y CARRIZOSA\"," + "\"768574635\"," + "\"CHICO\"," + "\"CRA 15 CON 100\"," + "\"BOGOTA\"," + "\"4823\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\","+ "\"NA\")";

    //Variables para manipulación de datos
    private MedicionesReaderDbHelper openHelper;
    private SQLiteDatabase database;

    public MedicionesDataSource(Context context) {
        //Creando una instancia hacia la base de datos
        openHelper = new MedicionesReaderDbHelper(context);
        database = openHelper.getWritableDatabase();
    }

    public void saveMedicionesRow(String cliente,String nit,String sucursal ,String direccion, String ciudad ,String abonado,String hora,String fecha,String latitud,String longitud,String operador_sim,String tecnologia_sim,String operador_red_1_2g,String tecnologia_operador_red_1_2g,String csq_operador_red_1_2g,String operador_red_2_2g,String tecnologia_operador_red_2_2g,String csq_operador_red_2_2g,String operador_red_3_2g,String tecnologia_operador_red_3_2g,String csq_operador_red_3_2g,String operador_red_1_3g,String tecnologia_operador_red_1_3g,String csq_operador_red_1_3g,String operador_red_2_3g,String tecnologia_operador_red_2_3g,String csq_operador_red_2_3g,String operador_red_3_3g,String tecnologia_operador_red_3_3g,String csq_operador_red_3_3g){
        //Nuestro contenedor de valores
        ContentValues values = new ContentValues();

        //Seteando body y author
        values.put(MedicionesDataSource.ColumnMediciones.CLIENTE_MEDICIONES,cliente);
        values.put(MedicionesDataSource.ColumnMediciones.NIT_MEDICIONES,nit);
        values.put(MedicionesDataSource.ColumnMediciones.DIRECCION_MEDICIONES,direccion);
        values.put(MedicionesDataSource.ColumnMediciones.CIUDAD_MEDICIONES,ciudad);
        values.put(MedicionesDataSource.ColumnMediciones.ABONADO_MEDICIONES,abonado);
        values.put(MedicionesDataSource.ColumnMediciones.HORA_MEDICIONES,hora);
        values.put(MedicionesDataSource.ColumnMediciones.FECHA_MEDICIONES,fecha);
        values.put(MedicionesDataSource.ColumnMediciones.LATITUD_MEDICIONES,latitud);
        values.put(MedicionesDataSource.ColumnMediciones.LONGITUD_MEDICIONES,longitud);
        values.put(MedicionesDataSource.ColumnMediciones.SUCURSAL_MEDICIONES,sucursal);
        values.put(MedicionesDataSource.ColumnMediciones.OPERADORSIM_MEDICIONES,operador_sim);
        values.put(MedicionesDataSource.ColumnMediciones.TECNOSIM_MEDICIONES,tecnologia_sim);
        values.put(MedicionesDataSource.ColumnMediciones.OPRED12G_MEDICIONES,operador_red_1_2g);
        values.put(MedicionesDataSource.ColumnMediciones.TECNOOPRED12G_MEDICIONES,tecnologia_operador_red_1_2g);
        values.put(MedicionesDataSource.ColumnMediciones.CSQOPRED12G_MEDICIONES,csq_operador_red_1_2g);
        values.put(MedicionesDataSource.ColumnMediciones.OPRED22G_MEDICIONES,operador_red_2_2g);
        values.put(MedicionesDataSource.ColumnMediciones.TECNOOPRED22G_MEDICIONES,tecnologia_operador_red_2_2g);
        values.put(MedicionesDataSource.ColumnMediciones.CSQOPRED22G_MEDICIONES,csq_operador_red_2_2g);
        values.put(MedicionesDataSource.ColumnMediciones.OPRED32G_MEDICIONES,operador_red_3_2g);
        values.put(MedicionesDataSource.ColumnMediciones.TECNOOPRED32G_MEDICIONES,tecnologia_operador_red_3_2g);
        values.put(MedicionesDataSource.ColumnMediciones.CSQOPRED32G_MEDICIONES,csq_operador_red_3_2g);
        values.put(MedicionesDataSource.ColumnMediciones.OPRED13G_MEDICIONES,operador_red_1_3g);
        values.put(MedicionesDataSource.ColumnMediciones.TECNOOPRED13G_MEDICIONES,tecnologia_operador_red_1_3g);
        values.put(MedicionesDataSource.ColumnMediciones.CSQOPRED13G_MEDICIONES,csq_operador_red_1_3g);
        values.put(MedicionesDataSource.ColumnMediciones.OPRED23G_MEDICIONES,operador_red_2_3g);
        values.put(MedicionesDataSource.ColumnMediciones.TECNOOPRED23G_MEDICIONES,tecnologia_operador_red_2_3g);
        values.put(MedicionesDataSource.ColumnMediciones.CSQOPRED23G_MEDICIONES,csq_operador_red_2_3g);
        values.put(MedicionesDataSource.ColumnMediciones.OPRED33G_MEDICIONES,operador_red_3_3g);
        values.put(MedicionesDataSource.ColumnMediciones.TECNOOPRED33G_MEDICIONES,tecnologia_operador_red_3_3g);
        values.put(MedicionesDataSource.ColumnMediciones.CSQOPRED33G_MEDICIONES,csq_operador_red_3_3g);

        //Insertando en la base de datos
        database.insert(MEDICIONES_TABLE_NAME,null,values);
    }

    public Cursor getAllQuotes(){
        //Seleccionamos todas las filas de la tabla Quotes
        return database.rawQuery(
                "select * from " + MEDICIONES_TABLE_NAME, null);
    }

}

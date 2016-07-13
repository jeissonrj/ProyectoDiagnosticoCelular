package com.example.jeisson.diagnosticocelular;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class cuadro_mediciones extends AppCompatActivity implements View.OnClickListener{

    TextView cliente, nit, sucursal, direccion, ciudad, abonado, hora, fecha, latitud, longitud, operador_sim, tecnologia_sim, operador_red_1, operador_red_2, operador_red_3, tecno_op_red_1_2g, tecno_op_red_2_2g, tecno_op_red_3_2g, señal_op_red_1_2g, señal_op_red_2_2g, señal_op_red_3_2g, tecno_op_red_1_3g, tecno_op_red_2_3g, tecno_op_red_3_3g, señal_op_red_1_3g, señal_op_red_2_3g, señal_op_red_3_3g;
    GPSTracker gps;
    String Operador_sim, Operador_red_1, Operador_red_2, Operador_red_3;
    String[] tecnologia = {"DESCONOCIDA", "GPRS (2G)", "EDGE (2G)", "UMTS (3G)", "CDMA (2G)", "EDVO_0 (3G)", "EDVO_A (3G)", "1xRTT", "HSDPA (3G)", "HSUPA (3G)", "HSPA (3G)", "IDEN (3G)", "EDVO_B (3G)", "LTE (4G)", "EHRPD (4G)", "HSPA+ (3G)"};
    int tipo_conexion;
    Button configurar_red_2g, configurar_red_3g, configurar_operador2_2g, configurar_operador3_2g, configurar_operador2_3g, configurar_operador3_3g;
    TelephonyManager telephonyManager;
    public static int MILISEGUNDOS_ESPERA = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadro_mediciones);

        cliente = (TextView) findViewById(R.id.cliente);
        nit = (TextView) findViewById(R.id.nit);
        sucursal = (TextView) findViewById(R.id.sucursal);
        direccion = (TextView) findViewById(R.id.direccion);
        ciudad = (TextView) findViewById(R.id.ciudad);
        abonado = (TextView) findViewById(R.id.abonado);
        hora = (TextView) findViewById(R.id.hora);
        fecha = (TextView) findViewById(R.id.fecha);
        latitud = (TextView) findViewById(R.id.latitud);
        longitud = (TextView) findViewById(R.id.longitud);
        operador_sim = (TextView) findViewById(R.id.operador_sim);
        tecnologia_sim = (TextView) findViewById(R.id.tecnologia_sim);
        operador_red_1 = (TextView) findViewById(R.id.operador_red_1);
        operador_red_2 = (TextView) findViewById(R.id.operador_red_2);
        operador_red_3 = (TextView) findViewById(R.id.operador_red_3);
        tecno_op_red_1_2g = (TextView) findViewById(R.id.tecno_op_red_1_2g);
        tecno_op_red_2_2g = (TextView) findViewById(R.id.tecno_op_red_2_2g);
        tecno_op_red_3_2g = (TextView) findViewById(R.id.tecno_op_red_3_2g);
        señal_op_red_1_2g = (TextView) findViewById(R.id.señal_op_red_1_2g);
        señal_op_red_2_2g = (TextView) findViewById(R.id.señal_op_red_2_2g);
        señal_op_red_3_2g = (TextView) findViewById(R.id.señal_op_red_3_2g);
        tecno_op_red_1_3g = (TextView) findViewById(R.id.tecno_op_red_1_3g);
        tecno_op_red_2_3g = (TextView) findViewById(R.id.tecno_op_red_2_3g);
        tecno_op_red_3_3g = (TextView) findViewById(R.id.tecno_op_red_3_3g);
        señal_op_red_1_3g = (TextView) findViewById(R.id.señal_op_red_1_3g);
        señal_op_red_2_3g = (TextView) findViewById(R.id.señal_op_red_2_3g);
        señal_op_red_3_3g = (TextView) findViewById(R.id.señal_op_red_3_3g);


        configurar_red_2g = (Button) findViewById(R.id.configurar_red_2g);
        configurar_red_2g.setOnClickListener(this);
        configurar_operador2_2g = (Button) findViewById(R.id.configurar_operador2_2g);
        configurar_operador2_2g.setOnClickListener(this);
        configurar_operador3_2g = (Button) findViewById(R.id.configurar_operador3_2g);
        configurar_operador3_2g.setOnClickListener(this);
        configurar_red_3g = (Button) findViewById(R.id.configurar_red_3g);
        configurar_red_3g.setOnClickListener(this);
        configurar_operador2_3g = (Button) findViewById(R.id.configurar_operador2_3g);
        configurar_operador2_3g.setOnClickListener(this);
        configurar_operador3_3g = (Button) findViewById(R.id.configurar_operador3_3g);
        configurar_operador3_3g.setOnClickListener(this);


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "bdregistros", null, 1);   //bdregistros = nombre de la base de datos
        SQLiteDatabase bd = admin.getWritableDatabase();
        Cursor fila = bd.rawQuery(  //devuelve 0 o 1 fila //es una consulta
                "select cliente,nit,sucursal,direccion,ciudad,abonado  from Registros", null);   //='" + cliente +"'"    ***pilas con el formato cuando la variable a buscar es text o integer (SQlite)
        if (fila.moveToLast()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)
            cliente.setText(fila.getString(0));
            nit.setText(fila.getString(1));
            sucursal.setText(fila.getString(2));
            direccion.setText(fila.getString(3));
            ciudad.setText(fila.getString(4));
            abonado.setText(fila.getString(5));
            Calendar calendar = Calendar.getInstance();
            hora.setText(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
            fecha.setText(calendar.get(Calendar.DATE) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.YEAR));
            //coordenadas habitacion la estrada
            //4.673910,-74.090198
            gps = new GPSTracker(cuadro_mediciones.this);
            if (gps.canGetLocation()) {
                double latitude = gps.getLatitude();
                double longitude = gps.getLongitude();
                latitud.setText(Double.toString(latitude));
                longitud.setText(Double.toString(longitude));
                //Toast.makeText(getApplicationContext(), "su ubicación es -\nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
            } else {
                gps.showSettingsAlert();
            }
            TelephonyManager telMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            Operador_sim = telMgr.getSimOperatorName();
            operador_sim.setText(Operador_sim);
            tipo_conexion = telMgr.getNetworkType();
            tecnologia_sim.setText(tecnologia[tipo_conexion]);
        }
        else {}
        bd.close();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.configurar_red_2g) {
            configurar_red_2g.setEnabled(false);
            configurar_operador2_2g.setEnabled(true);
            startActivityForResult(new Intent(android.provider.Settings.ACTION_DATA_ROAMING_SETTINGS), 0);
            TelephonyManager telMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            Operador_red_1 = telMgr.getNetworkOperatorName();
            operador_red_1.setText(Operador_red_1);
            tipo_conexion = telMgr.getNetworkType();
            tecno_op_red_1_2g.setText(tecnologia[tipo_conexion]);

        }
        if (v.getId() == R.id.configurar_operador2_2g) {
            configurar_operador2_2g.setEnabled(false);
            configurar_operador3_2g.setEnabled(true);
            startActivityForResult(new Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS), 0);
            TelephonyManager telMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            Operador_red_2 = telMgr.getNetworkOperatorName();
            operador_red_2.setText(Operador_red_2);
            tipo_conexion = telMgr.getNetworkType();
            tecno_op_red_2_2g.setText(tecnologia[tipo_conexion]);
        }
        if (v.getId() == R.id.configurar_operador3_2g) {
            configurar_operador3_2g.setEnabled(false);
            configurar_red_3g.setEnabled(true);
            startActivityForResult(new Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS), 0);
            TelephonyManager telMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            Operador_red_3 = telMgr.getNetworkOperatorName();
            operador_red_3.setText(Operador_red_3);
            tipo_conexion = telMgr.getNetworkType();
            tecno_op_red_3_2g.setText(tecnologia[tipo_conexion]);
        }
        if (v.getId() == R.id.configurar_red_3g) {
            configurar_red_3g.setEnabled(false);
            configurar_operador2_3g.setEnabled(true);
            startActivityForResult(new Intent(android.provider.Settings.ACTION_DATA_ROAMING_SETTINGS), 0);
            TelephonyManager telMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            //Operador_red_1 = telMgr.getNetworkOperatorName();
            //operador_red_1.setText(Operador_red_1);
            tipo_conexion = telMgr.getNetworkType();
            tecno_op_red_1_3g.setText(tecnologia[tipo_conexion]);
        }
        if (v.getId() == R.id.configurar_operador2_3g) {
            configurar_operador2_3g.setEnabled(false);
            configurar_operador3_3g.setEnabled(true);
            startActivityForResult(new Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS), 0);
            TelephonyManager telMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            //Operador_red_2 = telMgr.getNetworkOperatorName();
            //operador_red_2.setText(Operador_red_2);
            tipo_conexion = telMgr.getNetworkType();
            tecno_op_red_2_3g.setText(tecnologia[tipo_conexion]);

        }
        if (v.getId() == R.id.configurar_operador3_3g) {
            configurar_operador3_3g.setEnabled(false);
            startActivityForResult(new Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS), 0);
            TelephonyManager telMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            //Operador_red_3 = telMgr.getNetworkOperatorName();
            //operador_red_3.setText(Operador_red_3);
            tipo_conexion = telMgr.getNetworkType();
            tecno_op_red_3_3g.setText(tecnologia[tipo_conexion]);

        }
    }
}
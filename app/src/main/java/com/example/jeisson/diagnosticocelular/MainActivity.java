package com.example.jeisson.diagnosticocelular;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;
//import java.util.List;

//import android.telephony.CellSignalStrengthWcdma;
//import android.telephony.CellSignalStrengthLte;
//import android.telephony.CellInfo;
//import android.telephony.CellInfoWcdma;
//import android.telephony.CellInfoLte;
//import android.telephony.CellLocation;
//import android.telephony.NeighboringCellInfo;


public class MainActivity extends AppCompatActivity {

    // Whether there is a Wi-Fi connection.
    private static boolean wifiConnected = false;
    // Whether there is a mobile connection.
    private static boolean mobileConnected = false;

    String MCCMNCS, CodigoPaisMCCS, CodigoOperadorMNCS, NombreOperadorS, MCCMNC, CodigoPaisMCC, CodigoOperadorMNC, NombreOperador, NivelBateria;
    String[] TipoConexionDatos = {"DESCONOCIDA", "GPRS (2G)", "EDGE (2G)", "UMTS (3G)", "CDMA (2G)", "EDVO_0 (3G)", "EDVO_A (3G)", "1xRTT", "HSDPA (3G)", "HSUPA (3G)", "HSPA (3G)", "IDEN (3G)", "EDVO_B (3G)", "LTE (4G)", "EHRPD (4G)", "HSPA+ (3G)"};
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22;

    TelephonyManager telephonyManager;
    myPhoneStateListener pslistener;

    int TipoConexion;
    int Estadosenal;
    int mLastSignalStrength;
    int mLastSignalStrengthDbm;
    int mLastSignalStrengthGsm;

    GPSTracker gps;
    boolean useIPv4;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(MainActivity.this, PantallaInicio.class);
        finish(); // finaliza el MainActivity
        startActivity(i);

        //startActivityForResult(new Intent(android.provider.Settings.ACTION_DATA_ROAMING_SETTINGS), 0);

        View dato1 = findViewById(R.id.textView1);
        textView1 = (TextView) dato1;
        View dato2 = findViewById(R.id.textView2);
        textView2 = (TextView) dato2;
        View dato3 = findViewById(R.id.textView3);
        textView3 = (TextView) dato3;
        View dato4 = findViewById(R.id.textView4);
        textView4 = (TextView) dato4;
        View dato5 = findViewById(R.id.textView5);
        textView5 = (TextView) dato5;
        View dato6 = findViewById(R.id.textView6);
        textView6 = (TextView) dato6;
        View dato7 = findViewById(R.id.textView7);
        textView7 = (TextView) dato7;
        View dato8 = findViewById(R.id.textView8);
        textView8 = (TextView) dato8;
        View dato9 = findViewById(R.id.textView9);
        textView9 = (TextView) dato9;
        View dato10 = findViewById(R.id.textView10);
        textView10 = (TextView) dato10;
        View dato11 = findViewById(R.id.textView11);
        textView11 = (TextView) dato11;
        View dato12 = findViewById(R.id.textView12);
        textView12 = (TextView) dato12;
        View dato13 = findViewById(R.id.textView13);
        textView13 = (TextView) dato13;
        View dato14 = findViewById(R.id.textView14);
        textView14 = (TextView) dato14;
        View dato15 = findViewById(R.id.textView15);
        textView15 = (TextView) dato15;
        View dato16 = findViewById(R.id.textView16);
        textView16 = (TextView) dato16;
        View dato17 = findViewById(R.id.textView17);
        textView17 = (TextView) dato17;
        View dato18 = findViewById(R.id.textView18);
        textView18 = (TextView) dato18;
        View dato19 = findViewById(R.id.textView19);
        textView19 = (TextView) dato19;
        View dato20 = findViewById(R.id.textView20);
        textView20 = (TextView) dato20;
        View dato21 = findViewById(R.id.textView21);
        textView21 = (TextView) dato21;

        TelephonyManager telMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        MCCMNCS = telMgr.getSimOperator();
        CodigoPaisMCCS = MCCMNCS.substring(0, 3);
        CodigoOperadorMNCS = MCCMNCS.substring(3, 6);
        textView1.setText("MCC SIM CARD:                                  " + CodigoPaisMCCS);
        textView2.setText("MNC SIM CARD:                                  " + CodigoOperadorMNCS);
        NombreOperadorS = telMgr.getSimOperatorName();
        textView3.setText("OPERADOR SIM CARD:                             " + NombreOperadorS);
        MCCMNC = telMgr.getNetworkOperator();
        CodigoPaisMCC = MCCMNC.substring(0, 3);
        CodigoOperadorMNC = MCCMNC.substring(3, 6);
        textView4.setText("MCC OPERADOR:                                  " + CodigoPaisMCC);
        textView5.setText("MNC OPERADOR:                                  " + CodigoOperadorMNC);
        NombreOperador = telMgr.getNetworkOperatorName();
        textView6.setText("OPERADOR DE RED:                               " + NombreOperador);



        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo modoConexion = connMgr.getActiveNetworkInfo();

        if (modoConexion != null && modoConexion.isConnected()) {
            wifiConnected = modoConexion.getType() == ConnectivityManager.TYPE_WIFI;
            mobileConnected = modoConexion.getType() == ConnectivityManager.TYPE_MOBILE;
            if (wifiConnected) {
                textView7.setText("CONNECTADO ATRAVEZ DE WIFI");
            } else if (mobileConnected) {
                textView7.setText("CONECTADO ATRAVEZ DE DATOS");
            }
        } else {
            textView7.setText("NO HAY CONEXION A INTERNET");
        }
        TipoConexion = telMgr.getNetworkType();
        textView8.setText("TECNOLOGIA DE CONEXION:                        " + TipoConexionDatos[TipoConexion]);

        pslistener = new myPhoneStateListener();
        telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);//getActivity().getSystemService(Context.TELEPHONY_SERVICE);
        telephonyManager.listen(pslistener, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);


/*        if(telMgr.getNetworkType()==TelephonyManager.NETWORK_TYPE_UMTS){
            connMgr.setNetworkPreference(TelephonyManager.NETWORK_TYPE_EDGE);
            connMgr.startUsingNetworkFeature(TelephonyManager.NETWORK_TYPE_EDGE, "Deneme");
        }
        else if(telMgr.getNetworkType()==TelephonyManager.NETWORK_TYPE_EDGE){
            connMgr.setNetworkPreference(TelephonyManager.NETWORK_TYPE_UMTS);
            connMgr.startUsingNetworkFeature(TelephonyManager.NETWORK_TYPE_UMTS, "Deneme");
        }
        else {
            connMgr.setNetworkPreference(TelephonyManager.NETWORK_TYPE_LTE);
            connMgr.startUsingNetworkFeature(TelephonyManager.NETWORK_TYPE_LTE, "Deneme");
        }
*/


        IntentFilter batIntentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent battery = this.registerReceiver(null, batIntentFilter);
        int Bateria = battery.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        //Toast.makeText(getApplicationContext(), "Nivel de Bateria: " + Bateria + " %", Toast.LENGTH_LONG).show();
        textView13.setText("NIVEL DE BATERIA:                             " + Integer.toString(Bateria));                // pendiente ver como publicar valor de novel de bateria

        //telMgr.listen(pslistener, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
        //Toast.makeText(getApplicationContext(), "Nivel de señal: " + SignalStrength + " ", Toast.LENGTH_LONG).show();//muestra 0
        //textView17.setText("NIVEL DE SEÑAL:                               " + Integer.toString(SignalStrength));

        gps = new GPSTracker(MainActivity.this);
        if (gps.canGetLocation()) {
            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();
            textView10.setText("LATITUD:                                  " + Double.toString(latitude));
            textView11.setText("LONGITUD:                                 " + Double.toString(longitude));
            //Toast.makeText(getApplicationContext(), "su ubicación es -\nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
        } else {
            gps.showSettingsAlert();
        }
    }

    public class myPhoneStateListener extends PhoneStateListener {
        public int signalStrengthValue;

        @TargetApi(Build.VERSION_CODES.M)
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);

            Estadosenal = signalStrength.getLevel();
            textView18.setText("estado señal :              " + Integer.toString(Estadosenal) + "de 0 a 4, 4= excelente");
            if (signalStrength.isGsm()) {
                if (signalStrength.getGsmSignalStrength() != 99) {
                    signalStrengthValue = signalStrength.getGsmSignalStrength() * 2 - 113;
                    textView17.setText("Signal Strength :              " + signalStrengthValue + "GSM en dBs");
                }
                else{
                    signalStrengthValue = signalStrength.getGsmSignalStrength();
                    textView17.setText("Signal Strength :              " + signalStrengthValue + "GSM NORMAL");
                }
            }
            else {
                signalStrengthValue = signalStrength.getCdmaDbm();
                textView17.setText("Signal Strength :                " + signalStrengthValue + "CDMA en dBs");
            }
        }
    }
}

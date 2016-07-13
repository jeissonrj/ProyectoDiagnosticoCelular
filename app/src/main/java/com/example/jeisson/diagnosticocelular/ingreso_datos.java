package com.example.jeisson.diagnosticocelular;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ingreso_datos extends AppCompatActivity implements View.OnClickListener {

    EditText texto1, texto2, texto3, texto4, texto5, texto6;
    public String cliente, nit, sucursal, direccion, ciudad, abonado;
    private MedicionesDataSource dataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ingreso_datos);

        Button bdiagnosticar = (Button) findViewById(R.id.diagnosticar);
        bdiagnosticar.setOnClickListener(this);
        Button bconsultar = (Button) findViewById(R.id.consultar);
        bconsultar.setOnClickListener(this);
        texto1 = (EditText) findViewById(R.id.editText1);
        texto2 = (EditText) findViewById(R.id.editText2);
        texto3 = (EditText) findViewById(R.id.editText3);
        texto4 = (EditText) findViewById(R.id.editText4);
        texto5 = (EditText) findViewById(R.id.editText5);
        texto6 = (EditText) findViewById(R.id.editText6);
    }

    @Override
    public void onClick(View v) {
        Context context = getApplicationContext();
        Toast toast;
        CharSequence text;
        String texto;
        int duration = Toast.LENGTH_SHORT;
        if (v.getId() == R.id.diagnosticar) {
            cliente = texto1.getText().toString();
            nit = texto2.getText().toString();
            sucursal = texto3.getText().toString();
            direccion = texto4.getText().toString();
            ciudad = texto5.getText().toString();
            abonado = texto6.getText().toString();

            if (TextUtils.isEmpty(cliente) || TextUtils.isEmpty(nit) || TextUtils.isEmpty(sucursal) || TextUtils.isEmpty(direccion) || TextUtils.isEmpty(ciudad)) {
                toast = Toast.makeText(context, "favor ingrese todos los datos solicitados", duration);
                toast.show();
                return;
            }
            else {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"bdregistros", null, 1);   //bdregistros = nombre de la base de datos
                SQLiteDatabase bd = admin.getWritableDatabase();
                ContentValues registrar = new ContentValues();  //es una clase para guardar datos
                registrar.put("cliente", cliente);
                registrar.put("nit", nit);
                registrar.put("sucursal", sucursal);
                registrar.put("direccion", direccion);
                registrar.put("ciudad", ciudad);
                registrar.put("abonado", abonado);
                bd.insert("Registros", null, registrar);
                bd.close();
                texto1.setText("");
                texto2.setText("");
                texto3.setText("");
                texto4.setText("");
                texto5.setText("");
                texto6.setText("");
                Toast.makeText(this, "Datos de cliente guardados", Toast.LENGTH_SHORT).show();
                //https://www.youtube.com/watch?v=LMrfQufwEcc&feature=youtu.be
                //http://cursoandroidstudio.blogspot.com.co/2014/07/base-de-datos-sqlite.html
                Intent i = new Intent(ingreso_datos.this, cuadro_mediciones.class);
                finish(); // finaliza el MainActivity
                startActivity(i);
            }
        }
        if (v.getId() == R.id.consultar) {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"bdregistros", null, 1);   //bdregistros = nombre de la base de datos
            SQLiteDatabase bd = admin.getWritableDatabase();
            String cliente = texto1.getText().toString();
            Cursor fila = bd.rawQuery(  //devuelve 0 o 1 fila //es una consulta
                    "select _id,nit,sucursal,direccion,ciudad,abonado  from Registros where cliente='" + cliente +"'", null);   //='" + cliente +"'"    ***pilas con el formato cuando la variable a buscar es text o integer (SQlite)
            if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)
                texto2.setText(fila.getString(1));
                texto3.setText(fila.getString(2));
                texto4.setText(fila.getString(3));
                texto5.setText(fila.getString(4));
                texto6.setText(fila.getString(5));
            }
            else {
                Toast.makeText(this, "No existe un cliente con este nombre",
                        Toast.LENGTH_SHORT).show();
                texto1.setText("");
                texto2.setText("");
                texto3.setText("");
                texto4.setText("");
                texto5.setText("");
                texto6.setText("");
            }
            bd.close();
        }
    }
}
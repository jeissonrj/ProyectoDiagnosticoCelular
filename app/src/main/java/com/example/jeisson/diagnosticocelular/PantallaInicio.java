package com.example.jeisson.diagnosticocelular;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class PantallaInicio extends Activity {   //public class PantallaInicio extends AppCompatActivity { sirve para que no se vea el titulo en la presentación

    public static int MILISEGUNDOS_ESPERA = 2500;
    TextView title, mensaje;     //imagen en titulo
    ImageView icon;     //imagen en titulo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pantalla_inicio);

        esperarYpasar(MILISEGUNDOS_ESPERA);
    }

    public void esperarYpasar(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos

                Intent i = new Intent(PantallaInicio.this, ingreso_datos.class);
                finish();
                startActivity(i);
            }
        }, milisegundos);
    }

    //https://www.google.com.co/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjLif6UqbvNAhWHGh4KHa1eC3kQjRwIBw&url=http%3A%2F%2Fsp.depositphotos.com%2F22283687%2Fstock-illustration-technology-polygonal-cell-abstract-background.html&psig=AFQjCNF8ZlBIKLB-ukbqoyqKw0CaU6eiiA&ust=1466673868577322
    //https://www.google.com.co/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwiW6PDpqbvNAhUFKh4KHauFBOgQjRwIBw&url=https%3A%2F%2Fes.wikipedia.org%2Fwiki%2FLupa&psig=AFQjCNFG8AwHjD_Xmx6QSr-7Vts-bKLNQQ&ust=1466674279945823
}

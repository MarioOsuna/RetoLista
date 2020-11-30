package com.proyecto.restolista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText producto, mapa;
    private Datos datos = new Datos();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button agregar, lista, buscar_mapa;

        agregar = findViewById(R.id.buttonAgregar);
        lista = findViewById(R.id.buttonVisualizar);
        producto = findViewById(R.id.editTextComprar);
        mapa = findViewById(R.id.editTextTienda);
        buscar_mapa = findViewById(R.id.buttonBuscarTienda);

        //Toast.makeText(this, "Elementos añadidos: " + datos.lista_productos.size(), Toast.LENGTH_SHORT).show();


        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!producto.getText().toString().equals(" ")) {

                   /* if (datos.lista_productos.size() >= 10) {
                        Toast.makeText(MainActivity.this, "Ya se han añadido 10 productos", Toast.LENGTH_SHORT).show();
                    } else {*/
                        datos.lista_productos.add(producto.getText().toString());

                        Toast.makeText(MainActivity.this, "Se ha añadido el producto: " + producto.getText().toString(), Toast.LENGTH_SHORT).show();
                   // }

                } else {
                    Toast.makeText(MainActivity.this, "Introduzca un producto para añadir a la lista", Toast.LENGTH_SHORT).show();
                }
            }
        });

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (datos.lista_productos.size() > 0) {
                    Intent intent = new Intent(MainActivity.this, ComprarActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "No se han añadido aún productos a la lista", Toast.LENGTH_SHORT).show();
                }


            }
        });
buscar_mapa.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String loc = mapa.getText().toString();

        // Parse the location and create the intent.
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        // Find an activity to handle the intent, and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "¡No puedo manejar esto!");
        }
    }
});

    }


}
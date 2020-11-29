package com.proyecto.restolista;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class ComprarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);


        Datos datos = new Datos();
        TextView textView;
        LinearLayout linearLayout = findViewById(R.id.LinearLayout);

        for (int i = 0; i < datos.lista_productos.size(); i++) {
            textView = new TextView(this);

            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            textView.setTextSize(30);
           textView.setTextColor(Color.parseColor("black"));
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            textView.setText(datos.lista_productos.get(i));

            textView.setId(View.generateViewId());
            linearLayout.addView(textView);

        }
    }
}
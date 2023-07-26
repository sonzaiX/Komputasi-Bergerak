package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button kalkulatorButton = findViewById(R.id.kalkulator);
        Button konversiSuhuButton = findViewById(R.id.Konversi_Suhu);
        Button indexButton = findViewById(R.id.index);

        kalkulatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KalkulatorActivity.class);
                startActivity(intent);
            }
        });

        konversiSuhuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk membuka KonversiSuhuActivity
                Intent intent = new Intent(MainActivity.this, KonversiSuhuActivity.class);
                startActivity(intent);
            }
        });

        indexButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IndexUMTActivity.class);
                startActivity(intent);
            }
        });
    }

}



package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class KalkulatorActivity extends AppCompatActivity {

    private EditText inputAngka;
    private double angkaPertama = 0;
    private String operator = "";
    private boolean isOperatorClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);

        inputAngka = findViewById(R.id.inputAngka);
        inputAngka.setText("0");

        Button bClear = findViewById(R.id.bClear);
        Button bEnter = findViewById(R.id.bEnter);
        Button bPlus = findViewById(R.id.bPlus);
        Button bKali = findViewById(R.id.bKali);
        Button bBagi = findViewById(R.id.bBagi);
        Button bPersen = findViewById(R.id.bPersen);
        Button bTitik = findViewById(R.id.bTitik);
        Button b0 = findViewById(R.id.b0);
        Button b1 = findViewById(R.id.b1);
        Button b2 = findViewById(R.id.b2);
        Button b3 = findViewById(R.id.b3);
        Button b4 = findViewById(R.id.b4);
        Button b5 = findViewById(R.id.b5);
        Button b6 = findViewById(R.id.b6);
        Button b7 = findViewById(R.id.b7);
        Button b8 = findViewById(R.id.b8);
        Button b9 = findViewById(R.id.b9);

        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputAngka.setText("0");
                angkaPertama = 0;
                operator = "";
            }
        });

        bEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung();
            }
        });

        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperator("+");
            }
        });

        bKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperator("*");
            }
        });

        bBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperator("/");
            }
        });

        bPersen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperator("%");
            }
        });

        bTitik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!inputAngka.getText().toString().contains(".")) {
                    inputAngka.append(".");
                }
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahkanAngka("0");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahkanAngka("1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahkanAngka("2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahkanAngka("3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahkanAngka("4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahkanAngka("5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahkanAngka("6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahkanAngka("7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahkanAngka("8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahkanAngka("9");
            }
        });
    }

    private void tambahkanAngka(String angka) {
        if (inputAngka.getText().toString().equals("0") || isOperatorClicked) {
            inputAngka.setText(angka);
            isOperatorClicked = false;
        } else {
            inputAngka.append(angka);
        }
    }

    private void setOperator(String op) {
        angkaPertama = Double.parseDouble(inputAngka.getText().toString());
        operator = op;
        isOperatorClicked = true;
    }

    private void hitung() {
        if (!operator.isEmpty() && !isOperatorClicked) {
            double angkaKedua = Double.parseDouble(inputAngka.getText().toString());
            switch (operator) {
                case "+":
                    angkaPertama += angkaKedua;
                    break;
                case "-":
                    angkaPertama -= angkaKedua;
                    break;
                case "*":
                    angkaPertama *= angkaKedua;
                    break;
                case "/":
                    angkaPertama /= angkaKedua;
                    break;
                case "%":
                    angkaPertama %= angkaKedua;
                    break;
            }
            inputAngka.setText(String.valueOf(angkaPertama));
            operator = "";
        }
    }
}

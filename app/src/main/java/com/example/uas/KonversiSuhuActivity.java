package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class KonversiSuhuActivity extends AppCompatActivity {

    private EditText inputCelcius, inputFahrenheit, inputKelvin;
    private boolean isUpdatingCelcius = false;
    private boolean isUpdatingFahrenheit = false;
    private boolean isUpdatingKelvin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konversi);

        inputCelcius = findViewById(R.id.inputCelcius);
        inputFahrenheit = findViewById(R.id.inputFahrenheit);
        inputKelvin = findViewById(R.id.inputKelvin);

        inputCelcius.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (!isUpdatingCelcius) {
                    double celcius = 0;
                    if (!s.toString().isEmpty()) {
                        celcius = Double.parseDouble(s.toString());
                    }
                    isUpdatingFahrenheit = true;
                    updateFahrenheit(celcius);
                    isUpdatingFahrenheit = false;

                    isUpdatingKelvin = true;
                    updateKelvin(celcius);
                    isUpdatingKelvin = false;
                }
            }
        });

        inputFahrenheit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (!isUpdatingFahrenheit) {
                    double fahrenheit = 0;
                    if (!s.toString().isEmpty()) {
                        fahrenheit = Double.parseDouble(s.toString());
                    }
                    isUpdatingCelcius = true;
                    updateCelcius(fahrenheit);
                    isUpdatingCelcius = false;

                    isUpdatingKelvin = true;
                    updateKelvinFromFahrenheit(fahrenheit);
                    isUpdatingKelvin = false;
                }
            }
        });

        inputKelvin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (!isUpdatingKelvin) {
                    double kelvin = 0;
                    if (!s.toString().isEmpty()) {
                        kelvin = Double.parseDouble(s.toString());
                    }
                    isUpdatingCelcius = true;
                    updateCelciusFromKelvin(kelvin);
                    isUpdatingCelcius = false;

                    isUpdatingFahrenheit = true;
                    updateFahrenheitFromKelvin(kelvin);
                    isUpdatingFahrenheit = false;
                }
            }
        });
    }

    private void updateFahrenheit(double celcius) {
        double fahrenheit = (celcius * 9 / 5) + 32;
        inputFahrenheit.setText(String.valueOf(fahrenheit));
    }

    private void updateKelvin(double celcius) {
        double kelvin = celcius + 273.15;
        inputKelvin.setText(String.valueOf(kelvin));
    }

    private void updateCelcius(double fahrenheit) {
        double celcius = (fahrenheit - 32) * 5 / 9;
        inputCelcius.setText(String.valueOf(celcius));
    }

    private void updateKelvinFromFahrenheit(double fahrenheit) {
        double kelvin = (fahrenheit + 459.67) * 5 / 9;
        inputKelvin.setText(String.valueOf(kelvin));
    }

    private void updateCelciusFromKelvin(double kelvin) {
        double celcius = kelvin - 273.15;
        inputCelcius.setText(String.valueOf(celcius));
    }

    private void updateFahrenheitFromKelvin(double kelvin) {
        double fahrenheit = (kelvin * 9 / 5) - 459.67;
        inputFahrenheit.setText(String.valueOf(fahrenheit));
    }
}

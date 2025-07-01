package com.example.contador;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView editTextNumber;
    private EditText etValor;
    private Button btnIncrementar, btnDecrementar;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.editTextNumber);
        etValor = findViewById(R.id.etValor);
        btnIncrementar = findViewById(R.id.btnIncrementar);
        btnDecrementar = findViewById(R.id.btnDecrementar);

        editTextNumber.setText(String.valueOf(contador));

        btnIncrementar.setOnClickListener(v -> {
            int valorAOperar = obtenerValorDelEditText();
            contador += valorAOperar;
            editTextNumber.setText(String.valueOf(contador));
        });

        btnDecrementar.setOnClickListener(v -> {
            int valorAOperar = obtenerValorDelEditText();
            contador -= valorAOperar;
            editTextNumber.setText(String.valueOf(contador));
        });
    }

    private int obtenerValorDelEditText() {
        String valorStr = etValor.getText().toString();
        if (valorStr.isEmpty()) {
            return 1;
        }
        return Integer.parseInt(valorStr);
    }
}
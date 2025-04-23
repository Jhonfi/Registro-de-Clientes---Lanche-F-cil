package com.example.atv03;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputEditText;

public class RegistrationActivity extends AppCompatActivity {

    TextInputEditText textInputEditTextNome;
    Button buttonFinalizarCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationactivity);

        textInputEditTextNome = findViewById(R.id.textInputEditTextNome);

        buttonFinalizarCadastro = findViewById(R.id.buttonFinalizarCadastro);

        buttonFinalizarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeCliente = textInputEditTextNome.getText().toString().trim();

                if (nomeCliente.isEmpty()) {
                    Toast.makeText(RegistrationActivity.this, "Por favor, insira seu nome.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(RegistrationActivity.this, ConfirmationActivity.class);
                    intent.putExtra("NOME_CLIENTE", nomeCliente);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
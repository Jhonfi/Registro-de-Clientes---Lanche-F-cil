package com.example.atv03;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmationActivity extends AppCompatActivity {

    TextView textViewMensagemBoasVindas;
    Button buttonNovoCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // *** CORRIGIDO: Nome do layout para activity_confirmation ***
        setContentView(R.layout.activity_confirmationactivity);
        textViewMensagemBoasVindas = findViewById(R.id.textViewMensagemBoasVindas);
        buttonNovoCadastro = findViewById(R.id.buttonNovoCadastro);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nomeCliente = extras.getString("NOME_CLIENTE");
            if (nomeCliente != null && !nomeCliente.isEmpty()) {
                textViewMensagemBoasVindas.setText("Bem-vindo, " + nomeCliente + "!");
            } else {
                textViewMensagemBoasVindas.setText("Bem-vindo!");
            }
        } else {
            textViewMensagemBoasVindas.setText("Bem-vindo!");
        }

        buttonNovoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmationActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
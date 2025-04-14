package br.com.aula.ex_03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmacaoActivity extends AppCompatActivity {

    TextView textMensagem;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);

        textMensagem = findViewById(R.id.textMensagem);
        btnVoltar = findViewById(R.id.btnVoltar);

        String nome = getIntent().getStringExtra("nomeCliente");
        textMensagem.setText("Bem-vindo, " + nome + "!");

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent voltar = new Intent(ConfirmacaoActivity.this, MainActivity.class);
                voltar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // limpa pilha
                startActivity(voltar);
            }
        });
    }
}

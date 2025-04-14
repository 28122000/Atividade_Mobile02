package br.com.aula.ex_04;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResumoActivity extends AppCompatActivity {

    private TextView textResumo;
    private ImageView imagePedidoConcluido;
    private Button btnVoltarInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        textResumo = findViewById(R.id.textResumo);
        imagePedidoConcluido = findViewById(R.id.imagePedidoConcluido);
        btnVoltarInicio = findViewById(R.id.btnVoltarInicio);

        // Recebe os dados da Intent
        Intent intent = getIntent();
        String nomeCliente = intent.getStringExtra("nome");
        String lancheEscolhido = intent.getStringExtra("lanche");

        // Mensagem personalizada
        String mensagem = "Olá, " + nomeCliente + "!\nSeu pedido de \"" + lancheEscolhido + "\" foi registrado com sucesso!";
        textResumo.setText(mensagem);

        // Voltar para a tela inicial
        btnVoltarInicio.setOnClickListener(v -> {
            Intent voltarIntent = new Intent(ResumoActivity.this, MainActivity.class);
            voltarIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Limpa o histórico
            startActivity(voltarIntent);
        });
    }
}

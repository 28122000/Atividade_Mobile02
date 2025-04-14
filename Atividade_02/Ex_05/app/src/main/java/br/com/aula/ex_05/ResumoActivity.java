package br.com.aula.ex_05;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResumoActivity extends AppCompatActivity {

    private TextView textResumo;
    private Button btnNovoPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        textResumo = findViewById(R.id.textResumo);
        btnNovoPedido = findViewById(R.id.btnNovoPedido);

        // Recebe os dados da Activity anterior
        Intent intent = getIntent();
        String tamanho = intent.getStringExtra("tamanho");
        String pagamento = intent.getStringExtra("pagamento");
        double valor = intent.getDoubleExtra("valor", 0);

        // Exibe o resumo
        String resumo = "Tamanho: " + tamanho + "\nMétodo de Pagamento: " + pagamento +
                "\nValor Total: R$" + valor;
        textResumo.setText(resumo);

        // Novo pedido
        btnNovoPedido.setOnClickListener(v -> {
            Intent novoPedidoIntent = new Intent(ResumoActivity.this, SelecaoPizzaActivity.class);
            startActivity(novoPedidoIntent);
        });
    }
}

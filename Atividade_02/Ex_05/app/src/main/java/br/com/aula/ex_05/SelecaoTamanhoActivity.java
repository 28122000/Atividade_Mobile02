package br.com.aula.ex_05;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class SelecaoTamanhoActivity extends AppCompatActivity {

    private RadioGroup radioGroupTamanho, radioGroupPagamento;
    private Button btnConfirmarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_tamanho);

        radioGroupTamanho = findViewById(R.id.radioGroupTamanho);
        radioGroupPagamento = findViewById(R.id.radioGroupPagamento);
        btnConfirmarPedido = findViewById(R.id.btnConfirmarPedido);

        // Recebe os dados da Activity anterior (tipos de pizza)
        Intent intent = getIntent();
        boolean calabresa = intent.getBooleanExtra("calabresa", false);
        boolean marguerita = intent.getBooleanExtra("marguerita", false);
        boolean portuguesa = intent.getBooleanExtra("portuguesa", false);

        btnConfirmarPedido.setOnClickListener(v -> {
            int selectedTamanhoId = radioGroupTamanho.getCheckedRadioButtonId();
            int selectedPagamentoId = radioGroupPagamento.getCheckedRadioButtonId();

            // Verifica o tamanho e método de pagamento
            RadioButton radioTamanho = findViewById(selectedTamanhoId);
            RadioButton radioPagamento = findViewById(selectedPagamentoId);

            String tamanho = radioTamanho != null ? radioTamanho.getText().toString() : "";
            String pagamento = radioPagamento != null ? radioPagamento.getText().toString() : "";

            // Calcula o valor total do pedido
            double valorTotal = calcularTotal(calabresa, marguerita, portuguesa, tamanho);

            // Passa os dados para a próxima Activity
            Intent resumoIntent = new Intent(SelecaoTamanhoActivity.this, ResumoActivity.class);
            resumoIntent.putExtra("tamanho", tamanho);
            resumoIntent.putExtra("pagamento", pagamento);
            resumoIntent.putExtra("valor", valorTotal);

            startActivity(resumoIntent);
        });
    }

    private double calcularTotal(boolean calabresa, boolean marguerita, boolean portuguesa, String tamanho) {
        double valorPizza = 0;
        if (calabresa) valorPizza += 25;
        if (marguerita) valorPizza += 30;
        if (portuguesa) valorPizza += 35;

        // Calcula preço de acordo com o tamanho
        switch (tamanho) {
            case "Pequena":
                valorPizza *= 1;
                break;
            case "Média":
                valorPizza *= 1.5;
                break;
            case "Grande":
                valorPizza *= 2;
                break;
        }

        return valorPizza;
    }
}

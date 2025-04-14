package br.com.aula.ex_04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    private TextInputLayout inputLayoutNome;
    private TextInputEditText editTextNome;
    private RadioGroup radioGroupLanches;
    private Button btnConfirmarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        inputLayoutNome = findViewById(R.id.inputLayoutNome);
        editTextNome = findViewById(R.id.editTextNome);
        radioGroupLanches = findViewById(R.id.radioGroupLanches);
        btnConfirmarPedido = findViewById(R.id.btnConfirmarPedido);

        btnConfirmarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeCliente = editTextNome.getText() != null ? editTextNome.getText().toString() : "";

                int selectedId = radioGroupLanches.getCheckedRadioButtonId();

                if (nomeCliente.isEmpty()) {
                    inputLayoutNome.setError("Digite seu nome");
                    return;
                } else {
                    inputLayoutNome.setError(null);
                }

                if (selectedId == -1) {
                    Toast.makeText(FormularioActivity.this, "Selecione um lanche", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton radioButtonSelecionado = findViewById(selectedId);
                String lancheEscolhido = radioButtonSelecionado.getText().toString();

                // Passa os dados para a próxima activity
                Intent intent = new Intent(FormularioActivity.this, ResumoActivity.class);
                intent.putExtra("nome", nomeCliente);
                intent.putExtra("lanche", lancheEscolhido);
                startActivity(intent);
            }
        });
    }
}

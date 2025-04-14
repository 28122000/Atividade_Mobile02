package br.com.aula.ex_02;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText inputSalario;
    RadioGroup radioGroup;
    Button btnCalcular;
    TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputSalario = findViewById(R.id.inputSalario);
        radioGroup = findViewById(R.id.radioGroup);
        btnCalcular = findViewById(R.id.btnCalcular);
        textResultado = findViewById(R.id.textResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String salarioTexto = inputSalario.getText().toString();

                if (!salarioTexto.isEmpty()) {
                    double salario = Double.parseDouble(salarioTexto);
                    double novoSalario = 0;

                    int selecionadoId = radioGroup.getCheckedRadioButtonId();

                    if (selecionadoId == R.id.radio40) {
                        novoSalario = salario * 1.40;
                    } else if (selecionadoId == R.id.radio45) {
                        novoSalario = salario * 1.45;
                    } else if (selecionadoId == R.id.radio50) {
                        novoSalario = salario * 1.50;
                    } else {
                        Toast.makeText(MainActivity.this, "Selecione o percentual de aumento", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    textResultado.setText(String.format("Novo salário: R$ %.2f", novoSalario));
                } else {
                    Toast.makeText(MainActivity.this, "Digite o salário atual", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

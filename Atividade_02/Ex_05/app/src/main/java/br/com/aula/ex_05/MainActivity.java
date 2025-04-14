package br.com.aula.ex_05;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkCalabresa, checkMarguerita, checkPortuguesa;
    private Button btnIrParaTamanho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkCalabresa = findViewById(R.id.checkCalabresa);
        checkMarguerita = findViewById(R.id.checkMarguerita);
        checkPortuguesa = findViewById(R.id.checkPortuguesa);
        btnIrParaTamanho = findViewById(R.id.btnIrParaTamanho);

        btnIrParaTamanho.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SelecaoTamanhoActivity.class);

            // Passar os dados para a próxima Activity
            intent.putExtra("calabresa", checkCalabresa.isChecked());
            intent.putExtra("marguerita", checkMarguerita.isChecked());
            intent.putExtra("portuguesa", checkPortuguesa.isChecked());

            startActivity(intent);
        });
    }
}

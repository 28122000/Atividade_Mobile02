package br.com.aula.ex_01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox checkArroz, checkLeite, checkCarne, checkFeijao, checkRefrigerante;
    Button btnCalcular;
    TextView textTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkArroz = findViewById(R.id.checkArroz);
        checkLeite = findViewById(R.id.checkLeite);
        checkCarne = findViewById(R.id.checkCarne);
        checkFeijao = findViewById(R.id.checkFeijao);
        checkRefrigerante = findViewById(R.id.checkRefrigerante);
        btnCalcular = findViewById(R.id.btnCalcular);
        textTotal = findViewById(R.id.textTotal);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double total = 0.0;

                if (checkArroz.isChecked()) {
                    total += 2.69;
                }
                if (checkLeite.isChecked()) {
                    total += 2.70;
                }
                if (checkCarne.isChecked()) {
                    total += 16.70;
                }
                if (checkFeijao.isChecked()) {
                    total += 3.38;
                }
                if (checkRefrigerante.isChecked()) {
                    total += 3.00;
                }

                textTotal.setText(String.format("Total: R$ %.2f", total));
            }
        });
    }
}

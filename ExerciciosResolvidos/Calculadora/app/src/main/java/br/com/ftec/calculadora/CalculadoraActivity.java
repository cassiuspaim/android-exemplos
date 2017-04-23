package br.com.ftec.calculadora;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculadoraActivity extends AppCompatActivity {

    EditText ednumero1;
    EditText ednumero2;
    Button btsomar;
    Button btsubtrair;
    Button btdividir;
    Button btmultiplicar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Esse método vem da classe pai AppCompatActivity ou Activity
        super.onCreate(savedInstanceState);

        //Indicação da view
        //(arquivo de recurso res\layout\activity_layout)
        setContentView(R.layout.activity_calculadora);

        ednumero1 = (EditText) findViewById(R.id.ednumero1);
        ednumero2 = (EditText) findViewById(R.id.ednumero2);
        btsomar = (Button) findViewById(R.id.btsomar);
        btsubtrair = (Button) findViewById(R.id.btsubstrair );
        btdividir = (Button) findViewById(R.id.btdividir );
        btmultiplicar = (Button) findViewById(R.id.btmultiplicar);

        btsomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(ednumero1.getText().toString());
                double num2 = Double.parseDouble(ednumero2.getText().toString());
                double soma = num1 + num2;

                Toast.makeText(CalculadoraActivity.this,
                            "O valor da soma é " + soma,
                            Toast.LENGTH_SHORT ).show();
            }
        });

        btsubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(ednumero1.getText().toString());
                double num2 = Double.parseDouble(ednumero2.getText().toString());
                double subtracao = num1 - num2;

                Toast.makeText(CalculadoraActivity.this,
                        "O valor da subtração é " + subtracao,
                        Toast.LENGTH_SHORT ).show();
            }
        });

        btdividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(ednumero1.getText().toString());
                double num2 = Double.parseDouble(ednumero2.getText().toString());
                double divisao = num1 / num2;

                Toast.makeText(CalculadoraActivity.this,
                        "O valor da divisão é " + divisao,
                        Toast.LENGTH_SHORT ).show();
            }
        });

        btmultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(ednumero1.getText().toString());
                double num2 = Double.parseDouble(ednumero2.getText().toString());
                double multiplicacao = num1 * num2;

                Toast.makeText(CalculadoraActivity.this,
                        "O valor da multiplicação é " + multiplicacao,
                        Toast.LENGTH_SHORT ).show();
            }
        });


    }
}

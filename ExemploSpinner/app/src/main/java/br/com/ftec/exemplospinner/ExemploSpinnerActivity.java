package br.com.ftec.exemplospinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class ExemploSpinnerActivity extends Activity {
    // Planetas
    private int[] imagens = {R.drawable.planeta_01_mercurio,
            R.drawable.planeta_02_venus,
            R.drawable.planeta_03_terra, R.drawable.planeta_04_marte, R.drawable.planeta_05_jupiter,
            R.drawable.planeta_06_saturno, R.drawable.planeta_07_urano, R.drawable.planeta_08_neptuno,
            R.drawable.planeta_09_plutao};

    private String[] planetas = new String[]{"Mercúrio", "Vênus", "Terra", "Marte", "Júpiter",
            "Saturno", "Urano", "Netuno", "Plutão"};

    private Spinner combo;
    private Button btOK;
    private ImageView imagem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exemplo_spinner);

        imagem = (ImageView) findViewById(R.id.img);
        btOK = (Button) findViewById(R.id.btOK);
        combo = (Spinner) findViewById(R.id.comboPlanetas);

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item,
                        planetas);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);
//        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        combo.setAdapter(adaptador);

        // Se selecionar algum planeta atualiza a imagem
        combo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(
                    AdapterView<?> parent,
                    View v,
                    int posicao,
                    long id) {
                // Atualiza a imagem
                imagem.setImageResource(imagens[posicao]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });

        btOK.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(ExemploSpinnerActivity.this, "Selecionada a opção " + combo.getSelectedItem() , Toast.LENGTH_SHORT).show();
            }
        });

    }
}

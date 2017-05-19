package br.com.ftec.persistencia;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String ID_PREFERENCIA = "PREF_AULA";
    public static final String VALOR_PADRAO_TVHELLO = "VALOR_PADRAO_TVHELLO";
    private SharedPreferences preferencias;
    private EditText etHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHello = (EditText) findViewById(R.id.etHello);
        Button btSalvar = (Button) findViewById(R.id.btSalvar);

        preferencias = this.getSharedPreferences(ID_PREFERENCIA, 0);
        String valorPref = preferencias
                                .getString(VALOR_PADRAO_TVHELLO,
                                "PRIMEIRA_VEZ");
        etHello.setText(valorPref);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Recupera editor de preferencias
                SharedPreferences.Editor editor
                         = preferencias.edit();

                //Atribuição de valor para preferencia
                editor.putString(
                        VALOR_PADRAO_TVHELLO,
                        etHello.getText().toString());

                editor.commit(); //Conclui transação
            }
        });
    }
}

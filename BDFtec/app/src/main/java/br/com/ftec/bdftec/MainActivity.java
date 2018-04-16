package br.com.ftec.bdftec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etCerveja
                = (EditText) findViewById(R.id.etCerveja);
        final EditText etQuantidade
                = (EditText) findViewById(R.id.etQuantidade);
        final EditText etTipo
                = (EditText) findViewById(R.id.etTipo);
        Button btSalvar
                = (Button) findViewById(R.id.btSalvar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cerveja cerveja = new Cerveja();
                cerveja
                  .setNome(etCerveja.getText().toString());
                cerveja
                  .setQuantidade(
                          Integer.valueOf(
                                  etQuantidade.getText().toString()
                          ));
                cerveja
                  .setTipo(etTipo.getText().toString());

                CervejaDB cervejaDB = new CervejaDB(MainActivity.this);
                cervejaDB.salvar(cerveja);

            }
        });

    }
}

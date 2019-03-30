package br.com.ftec.cadastrousuarionovo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edNome = (EditText) findViewById(R.id.edNome);
                Intent intent = new Intent(MainActivity.this, DadosUsuarioActivity.class);
                intent.putExtra("NOME_USUARIO", edNome.getText().toString());
                startActivity(intent);
            }
        });


    }
}

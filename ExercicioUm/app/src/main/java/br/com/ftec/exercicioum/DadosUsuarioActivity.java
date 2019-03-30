package br.com.ftec.exercicioum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DadosUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_usuario);

        Intent intent = getIntent();
        if (null != intent) {
            String nomeUsuario = intent.getStringExtra("NOME_USUARIO");
            TextView txtNomeUsuario = findViewById(R.id.txtNomeUsuario);
            txtNomeUsuario.setText(nomeUsuario);
        }

    }
}

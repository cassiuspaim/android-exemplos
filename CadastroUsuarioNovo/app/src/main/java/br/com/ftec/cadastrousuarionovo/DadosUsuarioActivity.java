package br.com.ftec.cadastrousuarionovo;

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
        String nomeUsuario = intent.getStringExtra("NOME_USUARIO");

        TextView txtView = (TextView) findViewById(R.id.txtNomeUsuario);
        txtView.setText(nomeUsuario);

    }
}

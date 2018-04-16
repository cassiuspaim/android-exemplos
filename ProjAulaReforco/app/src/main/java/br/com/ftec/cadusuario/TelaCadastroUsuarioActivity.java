package br.com.ftec.cadusuario;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by CASSIUS on 06/05/2017.
 */

public class TelaCadastroUsuarioActivity extends AppCompatActivity{

    EditText etNome, etUsuario, etEmail;
    Usuario usuario = new Usuario();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tela_cadastro_usuario);
        etNome = (EditText) findViewById(R.id.etNome);
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etEmail = (EditText) findViewById(R.id.etEmail);

        Intent it = getIntent();
        Usuario usuarioIntent = (Usuario) it.getSerializableExtra("usuario");
        if (usuarioIntent != null){
            this.usuario = usuarioIntent;
            etNome.setText( usuario.getNome());
            etUsuario.setText( usuario.getNomeUsuario ());
            etEmail.setText( usuario.getEmail());
        }

        Button btSalvar = (Button) findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usuario.setNome( etNome.getText().toString() );
                usuario.setNomeUsuario( etUsuario.getText().toString() );
                usuario.setEmail( etEmail.getText().toString() );
                if (usuario.getId() == null) {
                    DAO.incluirUsuario(usuario);
                } else {
                    DAO.alterarUsuario(usuario);
                }

                finish();
            }
        });

    }
}

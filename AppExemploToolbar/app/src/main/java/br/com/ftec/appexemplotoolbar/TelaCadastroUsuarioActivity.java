package br.com.ftec.appexemplotoolbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCadastroUsuarioActivity extends AppCompatActivity {

    private static final String TAG = "_TELA_CAD_USUARIO_";

    EditText edNome;
    EditText edTelefone;
    EditText edEmail;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_usuario_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.setSubtitle(getResources().getString(R.string.tela_edicao_usuario));
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edNome = (EditText) findViewById(R.id.edNome);
        edEmail = (EditText) findViewById(R.id.edEmail);
        edTelefone = (EditText) findViewById(R.id.edTelefone);

        Intent intent = getIntent();
        usuario = (Usuario) intent.getSerializableExtra("usuario");
        if (usuario != null) {
            edNome.setText(usuario.getNome());
            edTelefone.setText(usuario.getTelefone());
            edEmail.setText(usuario.getEmail());
        }

        Button btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean usuarioNovo = false;
                if (usuario == null) {
                    usuario = new Usuario();
                    usuarioNovo = true;
                }
                usuario.setNome(edNome.getText().toString());
                usuario.setTelefone(edTelefone.getText().toString());
                usuario.setEmail(edEmail.getText().toString());
                try {
                    if (usuarioNovo) {
                        DAO.incluirUsuario(usuario);
                    } else {
                        DAO.alterarUsuario(usuario);
                    }

                    Toast.makeText(TelaCadastroUsuarioActivity.this, "Usuário " + usuario.getNome() + " cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    Log.e(TAG, "Ocorreu um erro ao tentar salvar " + edNome.getText().toString());
                }
                finish();

            }
        });
    }
}

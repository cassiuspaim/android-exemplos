package br.com.ftec.relativelayoutexemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btLogin;
    EditText campoValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1 - Cast para tipo de componente (COMPONENTE)
        //2 - Busca pelo componente pelo ID (BUSCA PELO ID)

        btLogin = (Button) findViewById(R.id.btLogin);
        campoValor = (EditText) findViewById(R.id.campoUsuario);
        campoValor.getText().toString();
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( MainActivity.this,
                                "Olá",
                                Toast.LENGTH_SHORT ).show();
            }
        });
    }

}

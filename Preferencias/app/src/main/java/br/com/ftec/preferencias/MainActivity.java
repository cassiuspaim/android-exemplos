package br.com.ftec.preferencias;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = this.getSharedPreferences("ID_PREF_EXEMPLO", 0);
        String valor = pref.getString("nome", "valor_padrao");

        et = (EditText) findViewById(R.id.etNome);
        et.setText(valor);
        Button btSalvar = (Button) findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                SharedPreferences pref = getContexto().getSharedPreferences("ID_PREF_EXEMPLO", 0);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("nome",  et.getText().toString());
                editor.commit();
            }
        });
    }

    public Context getContexto(){
        return this;
    }

}

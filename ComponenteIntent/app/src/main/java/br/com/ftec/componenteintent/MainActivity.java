package br.com.ftec.componenteintent;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by CASSIUS on 22/04/2017.
 */

public class MainActivity extends AppCompatActivity {

    private static final int ACTIVITY_SIM_NAO = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Button btStartActivityForResult = (Button) findViewById(R.id.btIntent_startActivityForResult);
        btStartActivityForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, ExemploTelaSimNao.class), ACTIVITY_SIM_NAO);
            }
        });

        Button btStartActivity = (Button) findViewById(R.id.btIntent_startActivity);
        btStartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ExemploTelaSimNao.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int codigo, int resultado, Intent it) {
        if (codigo == ACTIVITY_SIM_NAO) {
            Bundle params = it != null ? it.getExtras() : null;
            if (params != null) {
                String msg = params.getString("msg");
                switch (resultado) {
                    case 1:
                        Toast.makeText(MainActivity.this, "Escolheu Sim: " + msg, Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Escolheu Não: " + msg, Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Não definido: " + msg, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }
    }
}

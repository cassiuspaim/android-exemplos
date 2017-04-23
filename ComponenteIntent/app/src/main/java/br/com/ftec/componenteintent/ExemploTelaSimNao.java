package br.com.ftec.componenteintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExemploTelaSimNao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_sim_nao);

        Button btSim = (Button) findViewById(R.id.btSim);
        btSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cria a Intent
                Intent it = new Intent();
                //Seta a mensagem de retorno
                it.putExtra("msg", "Clicou em Sim!");
                //Seta o status do resultado e a Intent
                setResult(1, it);
                //Fim desta activity
                finish();
            }
        });

        Button btNao = (Button) findViewById(R.id.btNao);
        btNao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cria a Intent
                Intent it = new Intent();
                //Seta a mensagem de retorno
                it.putExtra("msg", "Clicou em Não!");
                //Seta o status do resultado e a Intent
                setResult(2, it);
                //Fim desta activity
                finish();
            }
        });
    }
}

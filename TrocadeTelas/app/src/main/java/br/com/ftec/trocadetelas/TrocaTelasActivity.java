package br.com.ftec.trocadetelas;

import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
import android.view.*;

public class TrocaTelasActivity extends Activity {

    Button bttelaprincipal, bttela2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CarregarTelaPrincipal();
    }
    public void CarregarTelaPrincipal() {
        setContentView(R.layout.tela_principal);
        bttela2 = (Button) findViewById(R.id.bttela2);
        bttela2.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           CarregarTela2();
                                       }
                                   });
    }

    public void CarregarTela2() {
        setContentView(R.layout.tela2);
        bttelaprincipal = (Button) findViewById (R.id.bttelaprincipal);
        bttelaprincipal.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   CarregarTelaPrincipal();
                                               }
                                           });
    }
}
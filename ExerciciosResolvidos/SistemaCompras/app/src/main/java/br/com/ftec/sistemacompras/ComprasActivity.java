package br.com.ftec.sistemacompras;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;
import android.view.*;
import android.app.*;
public class ComprasActivity extends AppCompatActivity {

    CheckBox chkandroidemacao, chkGoogleAndroid,
             chkuseCabeca, chkDesenvApp,
             chkDesignPatterns;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        chkandroidemacao = (CheckBox) findViewById(R.id.chkandroidemacao);
        chkGoogleAndroid = (CheckBox) findViewById(R.id.chkGoogleAndroid);
        chkuseCabeca = (CheckBox) findViewById(R.id.chkuseCabeca);
        chkDesenvApp = (CheckBox) findViewById(R.id.chkDesenvApp);
        chkDesignPatterns = (CheckBox) findViewById(R.id.chkDesignPatterns);

        Button bttotal = (Button) findViewById(R.id.bttotal);

        bttotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                double total = 0;
                if (chkandroidemacao.isChecked())
                    total += 70.69;
                if (chkGoogleAndroid.isChecked())
                    total += 180.00;
                if (chkuseCabeca.isChecked())
                    total += 100;
                if (chkDesenvApp.isChecked())
                    total += 80.30;
                if (chkDesignPatterns.isChecked())
                    total += 66.00;

                AlertDialog.Builder dialogo = new AlertDialog.Builder(
                        ComprasActivity.this);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Valor total da compra :"
                        + String.valueOf(total));
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }
        });
    }
}
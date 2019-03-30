package br.com.ftec.sistemadecompras2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Double valorTotal = 0d;

    CheckBox chkAndroidEmAcao;
    CheckBox chkGoogleAndroid;
    CheckBox chkUseACabeca;
    CheckBox chkDesenvolvimentoParaApp;
    CheckBox chkDesignPatterns;

    TextView txtValorTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkAndroidEmAcao = (CheckBox) findViewById(R.id.chkAndroidEmAcao);
        chkGoogleAndroid = (CheckBox) findViewById(R.id.chkGoogleAndroid );
        chkUseACabeca = (CheckBox) findViewById(R.id.chkUseACabeca );
        chkDesenvolvimentoParaApp = (CheckBox) findViewById(R.id.chkDesenvolvimentoParaApp );
        chkDesignPatterns = (CheckBox) findViewById(R.id.chkDesignPatterns );

        txtValorTotal = (TextView) findViewById(R.id.txtValorTotal);

        chkAndroidEmAcao.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                atualizarValorTotal(isChecked, 70.69d);
            }
        });

        chkGoogleAndroid.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                atualizarValorTotal(isChecked, 180.00d);
            }
        });

        chkUseACabeca.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                atualizarValorTotal(isChecked, 100.00d);
            }
        });

        chkDesenvolvimentoParaApp.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                atualizarValorTotal(isChecked, 80.30d);
            }
        });

        chkDesignPatterns.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                atualizarValorTotal(isChecked, 66.00d);
            }
        });

        Button btnComprar = (Button) findViewById(R.id.btnComprar);
        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valorTotal = 0d;

                if (chkAndroidEmAcao.isChecked()) {
                    valorTotal += 70.69d;
                }

                if (chkGoogleAndroid.isChecked()) {
                    valorTotal += 180.00d;
                }

                if (chkUseACabeca.isChecked()) {
                    valorTotal += 100.00d;
                }

                if (chkDesenvolvimentoParaApp.isChecked()) {
                    valorTotal += 80.30d;
                }

                if (chkDesignPatterns.isChecked()) {
                    valorTotal += 66.00d;
                }

                txtValorTotal.setText( String.valueOf(valorTotal));

            }
        });



    }

    private void atualizarValorTotal(boolean isChecked, Double valorLivro) {
        if (isChecked) {
            valorTotal += valorLivro;
        } else {
            valorTotal -= valorLivro;
        }
        txtValorTotal.setText( String.valueOf(valorTotal));
    }
}

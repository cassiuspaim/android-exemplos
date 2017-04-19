package br.com.ftec.componenteradio;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = (RadioGroup) findViewById(R.id.rdGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rdSim) {
                    Toast.makeText(MainActivity.this, "Radio Button Sim clicado", Toast.LENGTH_SHORT).show();
                }
                if (checkedId == R.id.rdNao) {
                    Toast.makeText(MainActivity.this, "Radio Button Não clicado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button bt = (Button) findViewById(R.id.btn);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idRadioButton = rg.getCheckedRadioButtonId();
                if (idRadioButton == R.id.rdSim) {
                    Toast.makeText(MainActivity.this, "Radio Button Sim checado", Toast.LENGTH_SHORT).show();
                }
                if (idRadioButton == R.id.rdNao) {
                    Toast.makeText(MainActivity.this, "Radio Button Não checado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

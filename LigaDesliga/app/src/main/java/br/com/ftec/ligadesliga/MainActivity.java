package br.com.ftec.ligadesliga;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    CheckBox chkSim;
    CheckBox chkNao;
    ToggleButton tb;
    Switch st;

    private static final String CATEGORIA = "__Chechbox__";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkSim = (CheckBox) findViewById(R.id.chkSim);
        chkNao = (CheckBox) findViewById(R.id.chkNao);
        tb = (ToggleButton) findViewById(R.id.tb);
        st = (Switch) findViewById(R.id.st);

        chkSim.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(CATEGORIA, "Checkbox sim " + ( isChecked ? " marcado " : " desmarcado " ));
            }
        });

        chkNao.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(CATEGORIA, "Checkbox nao " + ( isChecked ? " marcado " : " desmarcado " ));
            }
        });

        tb.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(CATEGORIA, "ToggleButton " + ( isChecked ? " marcado " : " desmarcado " ));
            }
        });

        st.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(CATEGORIA, "SwitchButton " + ( isChecked ? " marcado " : " desmarcado " ));
            }
        });

        Button bt = (Button) findViewById(R.id.btn);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg;
                if (chkSim.isChecked()) {
                    msg = "CheckBox Sim macardo.\n";
                } else {
                    msg = "CheckBox Sim desmarcado.\n";
                }

                if (chkNao.isChecked()) {
                    msg += "CheckBox Não macardo.\n";
                } else {
                    msg += "CheckBox Não desmarcado.\n";
                }

                if (tb.isChecked() ) {
                    msg += "ToggleButton checado.\n";
                } else {
                    msg += "ToggleButton não está checado.\n";
                }

                if (st.isChecked() ) {
                    msg += "Switch checado.";
                } else {
                    msg += "Switch não está checado.";
                }

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

    }
}

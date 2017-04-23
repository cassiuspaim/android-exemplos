package br.com.ftec.logcatexemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Exemplo_Log_Cat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "log de verbose");
        Log.d(TAG, "log de debug");
        Log.i(TAG, "log de informação");
        Log.w(TAG, "log de aviso");
        Log.e(TAG, "log de erro");

    }
}

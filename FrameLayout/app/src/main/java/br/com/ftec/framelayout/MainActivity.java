package br.com.ftec.framelayout;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListViewCompat listView = (ListViewCompat) findViewById(R.id.listView);
        String[] conceitos = new String[] { "Programação Orientada a Objetos",
                                            "Angular JS",
                                            "Android",
                                            "JSF",
                                            "Java",
                                            "Jquery",
                                            "Windows",
                                            "Linux"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                conceitos);

        listView.setAdapter(adaptador);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pb = (ProgressBar) findViewById(R.id.pgBar);
                        pb.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }).start();


    }

}

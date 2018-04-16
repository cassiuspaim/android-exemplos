package br.com.ftec.listadecursosactivitycustomview;

/**
 * Created by CASSIUS on 18/04/2017.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    // Array of strings...
    ListView simpleList;
    String animalList[] = {"Lion","Tiger","Monkey","Elephant","Dog","Cat","Camel"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleList = (ListView) findViewById(R.id.simpleListView);

        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(
                        this /* contexto */ ,
                        R.layout.activity_list_view /* recurso de layout */ ,
                        R.id.textView /* Id do TextView dentro do layout que deve ser populado */ ,
                        animalList /* array de dados */ );
        simpleList.setAdapter(arrayAdapter);
    }

}

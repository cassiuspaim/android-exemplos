package br.com.ftec.tabhostexemplo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

/**
 * Created by CASSIUS on 23/04/2017.
 */

public class Tab1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Cria o layout
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        layout.setPadding(10, 10, 10, 10); //pixels
        layout.setBackgroundColor(Color.GRAY);
        TextView nome = new TextView(this);
        nome.setText("Texto da Tab 1A");
        nome.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        layout.addView(nome);
        setContentView(layout);
    }
}

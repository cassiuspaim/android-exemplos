package br.com.ftec.imageviewtrocar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btImagemUm;
    private Button btImagemDois;

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btImagemUm = (Button) findViewById(R.id.btImagemUm);
        btImagemDois = (Button) findViewById(R.id.btImagemDois);
        iv = (ImageView) findViewById(R.id.imageView);


        btImagemUm.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                iv.setImageResource(R.drawable.timer_auto_black_48x48);
            }
        });

        btImagemDois.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                iv.setImageResource(R.drawable.trophy_48);
            }
        });
    }
}

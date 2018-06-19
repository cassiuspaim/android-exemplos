package br.com.ftec.consumows;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

public class PokemonActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_pokemon);

        Button btn = (Button) findViewById(R.id.btnShowPokemon);
        etName = (EditText) findViewById(R.id.etName);
        etWeight  = (EditText) findViewById(R.id.etWeight);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executarTarefaAssincrona();
            }


        });
    }

    private void executarTarefaAssincrona() {
        TarefaDownload download = new TarefaDownload();
        download.execute();

    }

    private class TarefaDownload extends AsyncTask<Void, Void, Pokemon> {

        @Override
        protected Pokemon doInBackground(Void... voids) {
            Pokemon pokemon = null;
            pokemon = DownloadDados.getPokemon();
            return pokemon;
        }

        @Override
        protected void onPostExecute(Pokemon pokemon) {
            etName.setText(pokemon.getName());
            etWeight.setText(String.valueOf(pokemon.getWeight()));
        }
    }

}

package br.com.ftec.listacontatos;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class ListaContatosActivity extends AppCompatActivity {

    private ListView lista_contatos;
    private Contato[] contatos = {
            new Contato("Marcelo Augusto da Silva", "Marcelo", "da Silva", "Testador", false),
            new Contato("Carlos Alberto de Nobrega", "Carlos", "de Nobrega", "Humorista", false),
            new Contato("Cassius Ariovaldo Paim", "Cassius", "Paim", "Desenvolvedor", false),
            new Contato("Pedro Álvares Cabral", "Pedro", "Cabral", "Descobridor", false),
            new Contato("Augusta Ada Byron", "Augusta", "Byron", "Programadora", true),
    };

    private AppCompatActivity getContexto(){
        return this;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);

        lista_contatos = (ListView) findViewById(R.id.lista_contatos);
        CustomListAdapter adapter = new CustomListAdapter(ListaContatosActivity.this, contatos);
        lista_contatos.setAdapter(adapter);

        lista_contatos.setOnItemClickListener(new
              AdapterView.OnItemClickListener() {
                  @Override
                  public void onItemClick(AdapterView<?> parent,
                                          View view,
                                          int position,
                                          long id) {

                      Contato contato = (Contato) lista_contatos.getItemAtPosition(position);

                      AlertDialog.Builder dialogo =
                              new AlertDialog.Builder(ListaContatosActivity.this);
                      dialogo.setTitle("Contato");
                      dialogo.setMessage("Contato selecionado: " + contato.getNomeCompleto());
                      dialogo.setNeutralButton("OK", null);
                      dialogo.show();
                  }
              }
        );
    }
}

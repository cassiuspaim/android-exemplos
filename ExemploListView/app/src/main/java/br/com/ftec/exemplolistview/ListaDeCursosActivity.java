package br.com.ftec.exemplolistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaDeCursosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_cursos);

        List<Curso> cursos = todosOsCursos();
        ListView listaDeCursos = (ListView) findViewById(R.id.lista);

        ArrayAdapter<Curso> adapter = new ArrayAdapter<Curso>(this,
                android.R.layout.simple_list_item_1,
                cursos);
        listaDeCursos.setAdapter(adapter);

    }

    private List<Curso> todosOsCursos() {
        ArrayList lista = new ArrayList();
        lista.add(new Curso("Análise e desenvolvimento de sistemas", "Curso de graduação", EstadoAtual.FAZENDO));
        lista.add(new Curso("Sistemas de informação", "Curso de graduação", EstadoAtual.FAZENDO));
        lista.add(new Curso("Ciência da Computação", "Curso de graduação", EstadoAtual.FAZENDO));
        return lista;
    }

}

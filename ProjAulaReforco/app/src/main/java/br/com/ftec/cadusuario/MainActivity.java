package br.com.ftec.cadusuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar está no arquivo include_toolbar e é inserido no arquivo
        //activity_main.xml
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle( getResources().getString(R.string.tituloToolBar) );
        toolbar.setSubtitle( getResources().getString(R.string.subTituloToolBar));
        //Informando para a Activity que existe uma toolbar
        setSupportActionBar(toolbar);

    }

    /**
     * Método acionado ao ser criado um menu da Toolbar
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater(); //Retorna o inflater de menu
        menuInflater.inflate(R.menu.menu, menu);       //Atribui ao menu(res/menu/menu.xml) a view
        return true;
    }

    /**
     * Recebe por parâmetro o menu selecionado(clicado) da ToolBar
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_save:
                //Dois parâmetros para o método startActivity
                //Contexto da activity atual
                //Classe da activity que deve ser acionada
                startActivity(new Intent(MainActivity.this, TelaCadastroUsuarioActivity.class ));
                break;
            case R.id.menu_list:
                startActivity( new Intent(MainActivity.this, ListaUsuariosActivity.class));
                break;
        }

        return true;
    }
}

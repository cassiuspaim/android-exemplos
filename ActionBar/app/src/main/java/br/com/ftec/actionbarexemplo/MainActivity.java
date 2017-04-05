package br.com.ftec.actionbarexemplo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Retorna a barra que aparece na parte de cima
        //da aplicação
        //ActionBar actionBar = getActionBar();
        ActionBar actionbar = getSupportActionBar();

        actionbar.setTitle("ActionBarEx1");
        //Habilita a seta para voltar
        actionbar.setDisplayHomeAsUpEnabled(true);
    }

    /*
    Método para atribuir comportamentos as opções do menu
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla o menu com os botões da action bar
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }
    /*
    Método para indicar o que deve ser feito ao se clicar
    em algum item do menu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            toast("Clicou em Search!");
            return true;
        } else if (id == R.id.action_refresh) {
            toast("Clicou em Refresh!");
            return true;
        }else if (id == R.id.action_settings) {
            toast("Clicou em Settings!");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}

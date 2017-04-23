package br.com.ftec.menuexemploum;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Configura um menu na ActionBar através do res/menu/menu.xml
 */
public class AndroidMenusActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater(); //Retorna o inflater de menu
        menuInflater.inflate(R.menu.menu, menu);       //Atribui ao menu(res/menu/menu.xml) a view
        return true;
    }

    /**
     * Gerenciador de eventos para o clique no menu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_bookmark:
                Toast.makeText(AndroidMenusActivity.this, R.string.bookmark + " está selecionado", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_save:
                Toast.makeText(AndroidMenusActivity.this, R.string.save + " está selecionado", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_search:
                Toast.makeText(AndroidMenusActivity.this, R.string.search + " está selecionado", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_share:
                Toast.makeText(AndroidMenusActivity.this, R.string.share + " está selecionado", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_delete:
                Toast.makeText(AndroidMenusActivity.this, R.string.delete + " está selecionado", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_preferences:
                Toast.makeText(AndroidMenusActivity.this, R.string.preferences + " está selecionado", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
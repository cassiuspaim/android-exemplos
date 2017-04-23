package br.com.ftec.menucontextoexemplo;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String contatos[] = {"Alex", "Bruno", "Eduardo", "Valéria", "Camila"};

    private static final int ID_MENU_LIGAR = 1;
    private static final int ID_MENU_SMS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contatos);
        listView.setAdapter(adapter);

        // Registra o menu de contexto
        registerForContextMenu(listView);
    }

    /**
     * Cria as opções do menu
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Selecione a ação");
        menu.add(0, ID_MENU_LIGAR, 20,R.string.LIGAR);
        //int groupId, int itemId, int order, CharSequence title
        menu.add(0, ID_MENU_SMS, 10,R.string.SMS);
        //menu.add(R.string.SMS);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == ID_MENU_LIGAR) {
            Toast.makeText(getApplicationContext(), "Ítem " + getResources().getString(R.string.LIGAR) + " acionado", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == ID_MENU_SMS ) {
            Toast.makeText(getApplicationContext(), "Ítem " + getResources().getString(R.string.SMS) + " acionado", Toast.LENGTH_LONG).show();
        } else {
            return false;
        }
        return true;
    }
}